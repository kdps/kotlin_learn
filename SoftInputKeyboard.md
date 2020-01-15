# 1. Hide Soft Input Keyboard

```Kotlin
val imm: InputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
imm.hideSoftInputFromWindow(activity.currentFocus.windowToken, 0)
```
