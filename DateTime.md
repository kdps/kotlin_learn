# 1. Calendar

## 1.1. Convert Milliseconds to Converted String by Datetime format, Use DataFormat Function

```Kotlin
var calendar:Calendar = Calendar.getInstance(Locale.KOREA);
var date:Long = calendar.timeInMillis // Milliseconds of Now Date, Use Instead of getTimeInMillis
var result:String = DataFormat.format("YYmmdd" Date(date)).toString();
```

## 1.2. Convert Milliseconds to Converted String by Datetime Pattern, Use SimpleDateFormat Function

```Kotlin
var calendar:Calendar = Calendar.getInstance(Locale.KOREA);
var date:Long = calendar.timeInMillis // Milliseconds of Now Date, Use Instead of getTimeInMillis
val pattern = "MM-dd-yyyy"
val simpleDateFormat = SimpleDateFormat(pattern)
val date = simpleDateFormat.format(Date(now))
```

## 1.3. Convert Formatted String to Formatted String, Use SimpleDateFormat Function

```Kotlin
var calendar:Calendar = Calendar.getInstance(Locale.KOREA);
var date:Long = calendar.timeInMillis // Milliseconds of Now Date, Use Instead of getTimeInMillis
val pattern = "MM-dd-yyyy"
val simpleDateFormat = SimpleDateFormat(pattern)
val date = simpleDateFormat.parse("12-01-2018")
```

# 2. TimeUnit

## 2.1. Convert millisecodns to Hours/Minutes/Seconds

```Kotlin
var milliseconds = 1000L
TimeUnit.MILLISECONDS.toHours(milliseconds)
TimeUnit.MILLISECONDS.toMinutes(milliseconds)
TimeUnit.MILLISECONDS.toSeconds(milliseconds)
```

# 3. SimpleDateFormat

## 3.1. String to Milliseconds

```Kotlin
var dateFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // Use Want DateTime Format

try {
    var mDate: Date = dateFormat.parse(date);
    var timeInMilliseconds:Long = mDate.getTime();
} catch (e: ParseException) {
    print(e.printStackTrace())
}
```
