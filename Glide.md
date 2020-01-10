## Rounded Image

```
var requestOptions = RequestOptions()
requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))

Glide
    .with(context)
    .load( url )
    .apply(requestOptions)
    .into( mBinding.element )
```

## Circle Crop Image

```
Glide
    .with(context)
    .load( url )
    .apply(RequestOptions.circleCropTransform())
    .into( mBinding.element )
```

## Center Crop

```
Glide
    .with(this)
    .apply(RequestOptions.centerCropTransform())
    .load( url )
    .into( mBinding.element )
```
