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

