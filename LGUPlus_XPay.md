```Kotlin
class XPay : AppCompatActivity() {

    lateinit var bindingObject: ~~
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        bindingObject = DataBindingUtil.setContentView(this, R.layout.layout_xpay)

        bindingObject.webView.run {
          xPayBackendURL = "http://www.example.com/xpay.php"
          var requestBody = "param1=" + URLEncoder.encode("param1", "UTF-8") +
                            "&param2=" + URLEncoder.encode("param2", "UTF-8")
          
          postUrl(requestURL, requestBody.toByteArray())
          
          setWebViewClient(xPayWebViewClient())
          setWebChromeClient(xPayWebChromeClient())
          setNetworkAvailable(true)
          getSettings().setDefaultTextEncodingName("utf-8")
          getSettings().setJavaScriptEnabled(true)
          
          addJavascriptInterface(WebBridge(),callbackPrefix)
        }
    }
    
    internal inner class xPayWebViewClient : WebViewClient() {
        override fun shouldOverrideKeyEvent(view: WebView, event: KeyEvent): Boolean {
            super.shouldOverrideKeyEvent(view, event)
            var keyCode: Int = event.getKeyCode();

            if ((keyCode == KeyEvent.KEYCODE_DPAD_LEFT) && bindingObject.webView.canGoBack()) {
                bindingObject.webView.goBack();
                return true;
            } else if ((keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) && bindingObject.webView.canGoForward()) {
                bindingObject.webView.goForward();
                return true;
            }

            return false
        }

        override fun onReceivedHttpAuthRequest(view: WebView, handler: HttpAuthHandler, host: String, realm: String) {
            super.onReceivedHttpAuthRequest(view, handler, host, realm);
        }

        override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {
            super.onReceivedError(view, errorCode, description, failingUrl);
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url);
        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {

            // WebViewClient 안에 구현
            if (url.startsWith("http://") || url.startsWith("https://")) {
                view.loadUrl(url)
                return true
            }

            // 모바일ISP 커스텀 스키마
            if (url.startsWith("ispmobile://")) {
                var isatallFlag = isPackageInstalled(getApplicationContext(), "kvp.jjy.MispAndroid320");
                if (isatallFlag) {
                    var override = false;
                    var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.putExtra(Browser.EXTRA_APPLICATION_ID, getPackageName());

                    try {
                        startActivity(intent);
                        override = true;
                    } catch (ex: ActivityNotFoundException) {
                    }
                    return override;
                } else {
                    showAlert("확인버튼을 누르시면 구글플레이로 이동합니다.", "확인", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface, which: Int) {
                            view.loadUrl("http://mobile.vpay.co.kr/jsp/MISP/andown.jsp");
                        }
                    }, "취소", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface, which: Int) {
                            dialog.cancel();
                        }
                    });
                    return true;
                }
            }

            // 계좌이체 커스텀 스키마
            if (url.startsWith("smartxpay-transfer://")) {
                val isatallFlag = isPackageInstalled(applicationContext, "kr.co.uplus.ecredit")
                if (isatallFlag) {
                    var override = false
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    intent.addCategory(Intent.CATEGORY_BROWSABLE)
                    intent.putExtra(Browser.EXTRA_APPLICATION_ID, packageName)

                    try {
                        startActivity(intent)
                        override = true
                    } catch (ex: ActivityNotFoundException) {
                    }

                    return override
                } else {
                    showAlert("확인버튼을 누르시면 구글플레이로 이동합니다.", "확인", DialogInterface.OnClickListener { dialog, which ->
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=kr.co.uplus.ecredit"))
                        intent.addCategory(Intent.CATEGORY_BROWSABLE)
                        intent.putExtra(Browser.EXTRA_APPLICATION_ID, packageName)
                        startActivity(intent)
                        overridePendingTransition(0, 0)
                    }, "취소", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
                    return true
                }
            }

            // MyWebClient 클래스 shouldOverrideUrlLoading 메서드 내용
            if ((url.startsWith("http://") || url.startsWith("https://")) && (url.contains("market.android.com") || url.contains("m.ahnlab.com/kr/site/download"))) {
                var uri: Uri = Uri.parse(url);
                var intent: Intent = Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(intent);
                    return true;
                } catch (e: ActivityNotFoundException) {
                    return false;
                }
            } else if (url != null
                    && (url.contains("vguard") || url.contains("droidxantivirus") || url.contains("smhyundaiansimclick://")
                            || url.contains("smshinhanansimclick://") || url.contains("smshinhancardusim://") || url.contains("smartwall://") || url.contains("appfree://")
                            || url.contains("v3mobile") || url.endsWith(".apk") || url.contains("market://") || url.contains("ansimclick")
                            || url.contains("market://details?id=com.shcard.smartpay") || url.contains("shinhan-sr-ansimclick://"))) {
                var intent: Intent? = null;
                // 인텐트 정합성 체크
                try {
                    intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                    //Log.e("intent getScheme     +++===>", intent.getScheme());
                    //Log.e("intent getDataString +++===>", intent.getDataString());
                } catch (ex: URISyntaxException) {
                    Log.e("Browser", "Bad URI " + url + ":" + ex.message);
                    return false;
                }

                try {
                    var retval: Boolean = true;
                    //chrome 버젼 방식
                    if (url.startsWith("intent")) {
                        // 앱설치 체크를 합니다.
                        if (getPackageManager().resolveActivity(intent, 0) == null) {
                            var packagename: String = intent.getPackage();
                            if (packagename != null) {
                                var uri: Uri = Uri.parse("market://search?q=pname:" + packagename);
                                intent = Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                                retval = true;
                            }
                        } else {
                            intent.addCategory(Intent.CATEGORY_BROWSABLE);
                            intent.setComponent(null);
                            try {
                                if (startActivityIfNeeded(intent, -1)) {
                                    retval = true;
                                }
                            } catch (ex: ActivityNotFoundException) {
                                retval = false;
                            }
                        }
                    } else { // 구 방식
                        var uri: Uri = Uri.parse(url);
                        intent = Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        retval = true;
                    }
                    return retval;
                } catch (e: ActivityNotFoundException) {
                    Log.e("error ===>", e.message);
                    e.printStackTrace();
                    return false;
                }
            }

            return false
        }

    }
    
    internal inner class xPayWebChromeClient : WebChromeClient() {
        override fun onJsAlert(view: WebView, url: String, message: String, result: android.webkit.JsResult): Boolean {
            AlertDialog.Builder(this@XPayActivity)
                    .setTitle("")
                    .setMessage(message)
                    .setPositiveButton(getString(android.R.string.ok), DialogInterface.OnClickListener { dialog, which ->
                        result.confirm()
                    }).setCancelable(false).create().show()
            return true
        }

        override fun onJsConfirm(view: WebView, url: String, message: String, result: JsResult): Boolean {
            AlertDialog.Builder(this@XPayActivity).setTitle("").setMessage(message)
                    .setPositiveButton(android.R.string.ok) { dialog, which -> result.confirm() }
                    .setNegativeButton(android.R.string.cancel) { dialog, which -> result.cancel() }.create().show()
            return true
        }
    }

    // App 체크 메소드 // 존재:true, 존재하지않음:false
    fun isPackageInstalled(ctx: Context, pkgName: String): Boolean {
        try {
            ctx.getPackageManager().getPackageInfo(pkgName, PackageManager.GET_ACTIVITIES)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            return false
        }

        return true
    }

    companion object {
        var handler : Handler? = Handler()
    }

// If you want to use Activity


/*    
        class WebBridge {

        lateinit var mContext: Context


        constructor(c: Context ) {
            mContext = c;
        }
*/


    class WebBridge {

        @JavascriptInterface
        fun getResponse(num : Int) {
            handler?.post {

            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && bindingObject.webView.canGoBack()) {
            bindingObject.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    fun showAlert(message: String, positiveButton: String, positiveListener: DialogInterface.OnClickListener, negativeButton: String, negativeListener: DialogInterface.OnClickListener) {
        val alert = AlertDialog.Builder(this)
        alert.setMessage(message)
        alert.setPositiveButton(positiveButton, positiveListener)
        alert.setNegativeButton(negativeButton, negativeListener)
        alert.show()
    }

}
```
