# com.jaychang.srv.SimpleRecyclerView

## Update Cell Item

1.You Call Function -> mBinding.rvList.updateCell(index, payload)

2.System Call Method -> onBindViewHolder(holder: ViewHolder, position: Int, context: Context, payload: Any?)

### Example

####Fragment

```
val map = java.util.HashMap<String, Boolean>()
map.put("hasLike", "true")
mBinding.rvList.updateCell(position, map)
```

####Cell

```
override fun onBindViewHolder(holder: ViewHolder, position: Int, context: Context, payload: Any?) {
    holder.binding.run {
        if (payload is HashMap<*, *>) {
            if(payload.get("hasLike") is Boolean) {
                item.hasLike = payload.get("hasLike") as Boolean
            }
        }
    }
}
```
