### Options

```Kotlin
setNetworkAvailable(boolean)
setVerticalScrollBarEnabled(boolean)
setHorizontalScrollBarEnabled(boolean)
setVerticalScrollbarOverlay(boolean)
setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY)

getSettings().setDatabaseEnabled(boolean)
getSettings().setGeolocationEnabled(boolean)
getSettings().setDomStorageEnabled(boolean)
getSettings().setDefaultTextEncodingName("utf-8")
getSettings().setJavaScriptEnabled(boolean)
getSettings().setSupportMultipleWindows(boolean)
getSettings().setJavaScriptCanOpenWindowsAutomatically(boolean)
getSettings().setBuiltInZoomControls(boolean)
getSettings().setUseWideViewPort(boolean)
getSettings().setLightTouchEnabled(boolean)
getSettings().setSavePassword(boolean)
getSettings().setSaveFormData(boolean)
getSettings().setPluginsEnabled(boolean)
getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE)

getWindow().addFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED) // Use GPU Accelerator
if (android.os.Build.VERSION.SDK_INT >= 11) {
    getWindow().addFlags(16777216) // Use Hardware Accelerator
}
```

### Javascript Interface

```Kotlin
companion object {
    var handler : Handler? = Handler()
}

class WebBridge {
    @JavascriptInterface
    fun getResponse(num : Int) {
        handler?.post {

        }
    }
}
```

### POST Request

```Kotlin
var params: String = ""

postUrl(requestURL, params.toByteArray());
```
