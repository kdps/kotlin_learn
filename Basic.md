## DataBinding

Layout XML Name : layout_basic.xml

```
class YourActivity : BaseActivity() {
  lateinit var mBinding: LayoutBasicBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      mBinding = DataBindingUtil.setContentView(this, R.layout.layout_basic)
  }
  
}
```

## Set Drawable To Element

```
var imageDrawable = R.drawable.image

mBinding.element.setImageDrawable(
  ContextCompat.getDrawable(
    mActivity,
    imageDrawable
  )
)
```

```
mBinding.element.setImageDrawable(
  CommonLib.getDrawable(
    mActivity, 
    R.drawable.image
  )
)
```
