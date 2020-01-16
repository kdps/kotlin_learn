
### Do not set tag to ImageView

Maybe Your application is crash

# Sprintf Function Of C Language, Format Function of Java

```
println(java.lang.String.format("%s, %s, %6f : %3f", "A", "B", 3.0, 4.0))
```

# 1. Activity

## 1.1 DataBinding (Activity)

Layout XML Name : activity_basic.xml

```Kotlin
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

```Kotlin
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

```Kotlin
((activity as YourActivity).getFragment() as YourFragment).fragmentFinish()
```

# 3. Drawable

## 3.1 Set Drawable To Element

```Kotlin
var imageDrawable = R.drawable.image

mBinding.element.setImageDrawable(
  ContextCompat.getDrawable(
    mActivity,
    imageDrawable
  )
)
```

```Kotlin
mBinding.element.setImageDrawable(
  CommonLib.getDrawable(
    mActivity, 
    R.drawable.image
  )
)
```

# 4. Glide

## 4.1 Rounded Image

```Kotlin
var requestOptions = RequestOptions()
requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))

Glide
    .with(context)
    .load( url )
    .apply(requestOptions)
    .into( mBinding.element )
```

## 4.2 Circle Crop Image

```Kotlin
Glide
    .with(context)
    .load( url )
    .apply(RequestOptions.circleCropTransform())
    .into( mBinding.element )
```

## 4.3 Center Crop

```Kotlin
Glide
    .with(this)
    .apply(RequestOptions.centerCropTransform())
    .load( url )
    .into( mBinding.element )
```

# 5. Handler

## 5.1 postDelayed

```Kotlin
Handler().postDelayed({
  // Input Code
},delayMillis:Int = 1000)
```

# 6. Service

## 6.1 Detect Network is Connected

```Kotlin
fun isNetworkConnected(mActivity: Activity) : Boolean {
    val connectivityManager ConnectivityManager = mActivity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetworkInfo

    return (activeNetwork != null && activeNetwork.isConnectedOrConnecting)
}
```

# 7. JSON

## 7.1 Parse JSON Data

```Kotlin
fun parseJson(str: String) : JsonObject? {
  var result: JsonObject?
  var jsonParser = JsonParser()
  result = jSonObject = jsonParser.parse(str) as JsonObject
}

fun parseJson(str: String) : JsonArray? {
  var result: JsonObject?
  var jsonParser = JsonParser()
  result = jSonObject = jsonParser.parse(str) as JsonArray
}
```
