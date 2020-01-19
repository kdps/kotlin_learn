# 1. Integer

# 1.1. String to Integer

#### Do not use Integer.parseInt OR toInt, Cause it make exception

```Kotlin
var convertedInt = 0

val parsedInt = str!!.toIntOrNull()
if (parsedInt != null) {
    convertedInt = parsedInt
} else {
    convertedInt = 0
}
```
