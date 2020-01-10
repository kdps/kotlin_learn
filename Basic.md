# 1. Activity

## 1.1 DataBinding (Activity)

Layout XML Name : activity_basic.xml

```
class YourActivity : BaseActivity() {
  lateinit var mBinding: ActivityBasicBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      mBinding = DataBindingUtil.setContentView(this, R.layout.activity_basic)
  }
  
}
```

# 2. Fragment

## 2.1 DataBinding (Fragment)

```
class YourFragment : BaseFragment() {
  
    lateinit var mBinding: YourFragment
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
        
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_basic, container, false)
        
        return mBinding
    }
}
```

## 2.2 Finish Fragment Of Activity

```
((activity as YourActivity).getFragment() as YourFragment).fragmentFinish()
```

# 3. Drawable

## 3.1 Set Drawable To Element

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

# 4. Glide

## 4.1 Rounded Image

```
var requestOptions = RequestOptions()
requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))

Glide
    .with(context)
    .load( url )
    .apply(requestOptions)
    .into( mBinding.element )
```

## 4.2 Circle Crop Image

```
Glide
    .with(context)
    .load( url )
    .apply(RequestOptions.circleCropTransform())
    .into( mBinding.element )
```

## 4.3 Center Crop

```
Glide
    .with(this)
    .apply(RequestOptions.centerCropTransform())
    .load( url )
    .into( mBinding.element )
```

# 5. Handler

## 5.1 postDelayed

```
Handler().postDelayed({
  // Input Code
},delayMillis:Int = 1000)
```
