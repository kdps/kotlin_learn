```Kotlin
class BaseInformation : Serializable, BaseObservable {
    var data = ""

    @get:Bindable
    var content = ""
    set(value) {
        field = value
    }
    
    constructor(data: BaseInformation) {
        data = data.data
    }
    
    constructor(data: JsonObject?) {
        data = CommonLib.getJsonString(data, "data")!!
    }
}
```
