# 1. HashMap

# 2. ArrayList

# 3. Multidimensional

## 3.1. HashMap And ArrayList

```Kotlin
var multidimensionalData: HashMap<Int, HashMap<BaseDTOData, ArrayList<ExtendDTOData>>>
```

```Kotlin
for(i in 0 until multidimensionalData.count()) {
  var item = multidimensionalData.get(i) as HashMap<BaseDTOData, ArrayList<ExtendDTOData>>
  for (key in item.keys) {
      var baseDTOData = key // BaseDTOData
      
      val value = item.get(key) // ArrayList<ExtendDTOData>>
      value!!.forEach {
        var extendDTOData = it // ExtendDTOData
        
      }
  }
```
