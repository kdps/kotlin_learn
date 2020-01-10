## Rounded Image

```
var requestOptions = RequestOptions()
requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))

Glide.with(context)
    .load( url )
    .apply(requestOptions).into( mBinding.element )
```
