# 1. View Attributes

## 1.1. Set Margin

```Kotlin
  fun View.setMarginLeftRight(leftMargin: Int, rightMargin: Int) {
      val params = layoutParams as ViewGroup.MarginLayoutParams
      params.setMargins(leftMargin, params.topMargin, rightMargin, params.bottomMargin)
      layoutParams = params
  }
```

## 1.2. Set Width/Height

```Kotlin
var width:Int = 1000
val params = LinearLayout.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT)
bindingView.layoutParams = params
```
