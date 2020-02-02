# 1. HashMap

# 2. ArrayList

# 3. Multidimensional

## 3.1. HashMap And ArrayList

### 3.1.1. Set Data

```Kotlin
var mMultidimensionalData = HashMap<Int, HashMap<BaseDTOData, ArrayList<ExtendDTOData>>>()
var mExtendDTOData = ArrayList<ExtendDTOData>()
```

```Kotlin
var lExtendDTOData = ExtendDTOData()
lExtendDTOData.data1 = "Example Data1"
mExtendDTOData.add(lExtendDTOData)

var idx = -1

var baseDTOData = BaseDTOData()
baseDTOData.data1 = "Example Data1"
baseDTOData.data2 = "Example Data2"

var pushData = HashMap<BaseDTOData, ArrayList<ExtendDTOData>>()
pushData.put(baseDTOData, mExtendDTOData)

mMultidimensionalData.put(++idx, pushData)
```

### 3.1.2. Get Data

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
}
```
