# 1. Setter

https://stackoverflow.com/questions/34832578/android-databinding-how-to-get-dimensions-from-dimens-xml/34835249

Use Dimention to layout_marginBottom Attribute

```Kotlin
@BindingAdapter("android:layout_marginBottom")
fun setBottomMargin(view: View, bottomMargin: Float) {
    var layoutParams: ViewGroup.MarginLayoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, bottomMargin.roundToInt());
    view.layoutParams = layoutParams;
}

@BindingAdapter("android:debugValue")
fun debugValue(view: View, msg: String, tag: String) {
    Log.d(tag, msg)
}

@BindingAdapter("android:toggle")
fun setBindingToggleByBooleanValue(view: View, bool: Boolean) {
    view.visibility = if (bool) View.VISIBLE else View.GONE
}

@BindingAdapter("android:visibility")
fun setVisibility(view: View, visibility: Int) {
    view.visibility = visibility;
}

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, uri: Uri) {
    Glide.with(view.context)
            .load(uri)
            .into(view)
}

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, resId: Int) {
    Glide.with(view.context)
            .load(resId)
            .into(view)
}

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, path: String) {
    Glide.with(view.context)
            .load(path)
            .into(view)
}
@BindingAdapter("android:debugValue")
fun setBindingDebugValue(view: View, msg: String, tag: String) {
    Log.d(tag, msg)
}

@BindingAdapter("android:onClickMessage")
fun onClickMessage(view: View, msg: String) {
    view.setOnClickListener(View.OnClickListener {
        Toast.makeText(it.context, msg, Toast.LENGTH_SHORT).show()
    })
}
```

# 2. Getter

```Kotlin
@InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
fun getTextString(view: TextView): String {
    return view.text
}
```
