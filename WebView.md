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
