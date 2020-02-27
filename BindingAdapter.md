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
