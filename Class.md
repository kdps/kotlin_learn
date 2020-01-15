# 1. Inner Class

```Kotlin
class Base {
  inner class Data {
    fun add {
      print("Heelo")
    }
  }
}
```

Usage

```Kotlin
var data = Data()
data.add()
```

OR

```Kotlin
var data = Data().add()
```
