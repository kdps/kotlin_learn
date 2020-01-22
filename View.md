# 1. View Attributes

## 1.1. Set Margin

```Kotlin

fun View.setMargin(left: Int = -1, top: Int = -1, right: Int = -1, bottom: Int = -1) {
    val params = layoutParams as ViewGroup.MarginLayoutParams
    params.setMargins(
        if (left != -1) left else params.leftMargin, 
        if (top != -1) top else params.topMargin, 
        if (right != -1) right else params.rightMargin, 
        if (bottom != -1) bottom else params.bottomMargin
        )
        
    layoutParams = params
}

fun setMargin() {
    bindingView.setMargin(5, -1, 10)
}
```

## 1.2. Set Width/Height

```Kotlin
var width:Int = 1000
val params = LinearLayout.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT)
bindingView.layoutParams = params
```
