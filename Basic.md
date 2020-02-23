# Bit Operation
# 비트연산자

| Operator | Instead Function | Example |
|:---|:---|:---|
|&|and|1.and(1)|
|\||or|1.or(1)|
|^|xor|1.xor(1)|
|~|inv|1.inv(1)|

### Title is not centered when use setNavigationIcon
### setNavigationIcon를 사용할때 타이틀이 중앙으로 정렬이 안될경우

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

### Use inner print function by variable

```Kotlin
var x = 1
var y = 5
println("x AND y = ${x and y}")
```

### Detect application is first launched
### 최초 어플리케이션 시작 확인

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
# C Sprintf, 자바 Format 함수

```Kotlin
println(java.lang.String.format("%s, %s, %6f : %3f", "A", "B", 3.0, 4.0))
```

# 1. Activity

## 1.1 DataBinding (Activity)
## 1.1 엑티비티 데이터바인딩

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
## 1.2 LAYOUT_INFLATER_SERVICE에서 onClick 이벤트 사용

```Kotlin
var layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
var containedView =  /* Use this */ mBinding.itemsContainedView /* Use this */
var mExampleBinding = DataBindingUtil.inflate(layoutInflater, R.layout.layout_example, containedView, false)

mExampleBinding.tvView.setOnClickListener { v ->
    Toast.makeText(mActivity, "Hello World", Toast.LENGTH_SHORT).show()
}
```

## 1.2 View Email Intent
## 1.2 이메일 인텐트 뷰

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
## 2.2 엑티비티의 프레그먼트 Finish

```Kotlin
((activity as YourActivity).getFragment() as YourFragment).fragmentFinish()
```

# 3. Drawable

## 3.1 Set Image Drawable To Element
## 3.1 엘리먼트 요소에 이미지 적용하기

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
## 4.1 각진 이미지

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
## 4.2 둥근 이미지

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
## 6.1 네트워크가 접속되었는지 확인

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

# 10. Use FloatingActionButton

```XML
<android.support.design.widget.FloatingActionButton
    android:id="@+id/fab_up"
    android:layout_width="@dimen/px_120"
    android:layout_height="@dimen/px_120"
    android:layout_above="@+id/rv_list"
    android:layout_alignParentRight="true"
    android:layout_alignParentBottom="true"
    android:layout_gravity="right|bottom"
    android:layout_marginRight="@dimen/px_20"
    android:layout_marginBottom="@dimen/px_200"
    android:background="@android:color/transparent"
    android:backgroundTint="@android:color/transparent"
    android:clickable="true"
    android:onClick="@{(v) -> activity.onClick(v)}"
    android:scaleType="center"
    app:background="@android:color/transparent"
    app:borderWidth="0dp"
    app:elevation="0dp"
    app:fabSize="auto"
    app:srcCompat="@drawable/fab_image"
    />
```
