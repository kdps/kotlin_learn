# Calaendar

```Kotlin
var calendar:Calendar = Calendar.getInstance(Locale.KOREA);
var date:Long = calendar.timeInMillis // Instead of getTimeInMillis
DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
var result:String = DataFormat.format("YYmmdd" Date(date)).toString();
```
