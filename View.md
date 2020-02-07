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

# 2. Add View

```Kotlin
var layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
var inflaterLayout = R.layout.appendLayout
val mAppendBinding: AppendLayoutBinding = DataBindingUtil.inflate(layoutInflater, inflaterLayout, null, false)

itemList.addView(mAppendBinding.root)
```

# Do stuff when view is loaded

```Kotlin
var vto: ViewTreeObserver  = mBinding.viewID.getViewTreeObserver();
    vto.addOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener() {
        // Do stuff
    });
```

# Detect view is shown
```Kotlin
val displayMetrics = DisplayMetrics()
windowManager.defaultDisplay.getMetrics(displayMetrics)

var height = displayMetrics.heightPixels
            
var rect: Rect = Rect()
if (mBinding.bodys.getGlobalVisibleRect(rect)) {
    var diffElem = (mBinding.view.height 
        /* It must be start by bottom of toolbar, bottom of it contains all not overed elements of bottom */
        - (height - mBinding.toolbar.height))

    if (scrollY > diffElem) {
        // View is hidden
    } else {
        // View is shown
    }
} else {
    // View is overed
}
```
