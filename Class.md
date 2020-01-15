# 1. Inner Class

Inner Class Can Use Variable of Class Variable

```Kotlin
class Base {
  inner class Data {
    fun add() {
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

# 2. Object Class

Object Class Can't Use Variable of Class Variable

```Kotlin
class Base {
  object Data {
    fun add() {
      print("Heelo")
    }
  }
}
```

Usage

```Kotlin
data.add()
```

# 3. Companion Object
