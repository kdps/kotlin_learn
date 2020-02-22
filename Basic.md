# Bit Operation

| Operator | Instead Function | Example |
|:---|:---|:---|
|&|and|1.and(1)|
|\||or|1.or(1)|
|^|xor|1.xor(1)|
|~|inv|1.inv(1)|

### Title is not centered when use setNavigationIcon

```XML
android:layout_marginRight="?android:attr/actionBarSize"

OR

android:layout_marginEnd="?android:attr/actionBarSize"

<android.support.v7.widget.Toolbar
    android:id="@+id/custom_toolbar"
    android:layout_width="match_parent"
    android:layout_height="?android:attr/actionBarSize"
    android:background="@android:color/holo_red_dark">
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="abc"
        android:textColor="@android:color/white"
        android:textSize="20sp"
        android:layout_marginRight="?android:attr/actionBarSize"
        android:gravity="center"/>

</android.support.v7.widget.Toolbar>
```

### Use inner print function

```Kotlin
var x = 1
var y = 5
println("x AND y = ${x and y}")
```

### Detect application is first launched

``` Kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val PREFS_NAME = "MyPrefsFile"

    val settings = getSharedPreferences(PREFS_NAME, 0)

    if (settings.getBoolean("my_first_time", true)) {
        // First launched
        settings.edit().putBoolean("my_first_time", false).commit()
    } else {
        // Other
    }
}
```

# forEach Indexed

```Kotlin
var result = ""
val data = arrayOf("1", "2", "3", "4", "5")

run loop@{
    data.forEachIndexed { index, string ->
        if (index == 3) {
            result = string
            return@loop
        }
    }
}

print(result)
```

# Sprintf Function Of C Language, Format Function of Java

```Kotlin
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

## 1.2 Use Onclick Event on LAYOUT_INFLATER_SERVICE

```Kotlin
var layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
var mBinding = DataBindingUtil.inflate(layoutInflater, R.layout.layout_example, /* Use this */ mBinding.itemsContainedView /* Use this */, false)
```

## 1.2 View Email Intent

```Kotlin
val email = Intent(Intent.ACTION_SEND)
email.type = "plain/text"
email.putExtra(Intent.EXTRA_EMAIL, arrayOf("example@domain.com"))
email.putExtra(Intent.EXTRA_SUBJECT, "subject")
email.putExtra(Intent.EXTRA_TEXT, "content")
startActivity(email)
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
  getDrawable(
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
    
Glide
    .with(this)
    .asBitmap()
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

# 8. Extension functions

# 9. Inner Scope Function

```Kotlin
fun countThings(list: List): Int {
    fun _countThings(list: List, acc: Int): Int {
        // stuff
        _countThings(list, acc + 1)
    }
    return countThings(list, 0)
}
```
