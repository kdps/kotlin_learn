# 1. Show Dialog (With DataBinding)

```
val mDialogBinding: LayoutBasicBinding = DataBindingUtil.inflate(getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater, R.layout.layout_basic, null, false)
var mDialog = Dialog(mActivity)
mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
mDialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
mDialog.setContentView(mDialogBinding.root)

mDialogBinding.btnClose.setOnClickListener {
    mDialog.dismiss()
}

mDialog.show()
```

# 2. Resize Dialog

## 2.1 Get DisplayMetrics

```
fun getDisplayMetrics() {
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    
    return displayMetrics
}
```

## 2.2 Get DIsplay Pixels

```
fun getWidthPixels() {
    var displayMetrics = getDisplayMetrics()
    val displayWidth = displayMetrics.widthPixels
    return displayWidth
}

fun getWidthPixels() {
    var displayMetrics = getDisplayMetrics()
    val displayWidth = displayMetrics.heightPixels
    return displayWidth
}
```
