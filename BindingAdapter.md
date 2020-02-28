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
```

```Kotlin
@BindingAdapter("android:debugValue")
fun debugValue(view: View, msg: String, tag: String) {
    Log.d(tag, msg)
}
```

```Kotlin
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
