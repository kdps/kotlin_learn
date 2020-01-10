## Set Drawable Of Element

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
