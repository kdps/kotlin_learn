# Calendar

```Kotlin
var calendar:Calendar = Calendar.getInstance(Locale.KOREA);
var date:Long = calendar.timeInMillis // Milliseconds of Now Date, Use Instead of getTimeInMillis
var result:String = DataFormat.format("YYmmdd" Date(date)).toString();
```

```Kotlin
var date:Long = calendar.timeInMillis // Milliseconds of Now Date, Use Instead of getTimeInMillis
val pattern = "MM-dd-yyyy"
val simpleDateFormat = SimpleDateFormat(pattern)
val date = simpleDateFormat.format(Date(now))
'''
