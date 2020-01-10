# com.jaychang.srv.SimpleRecyclerView

# Update Cell Item

1.You Call Function -> mBinding.rvList.updateCell(index, payload)
2.System Call Method -> onBindViewHolder(holder: ViewHolder, position: Int, context: Context, payload: Any?)

# Example

 -> Fragment

val map = java.util.HashMap<String, Boolean>()
map.put("hasLike", "true")

var payLoad = ArrayList<HashMap<String, Boolean>>()
payLoad.add(map)
mBinding.rvList.updateCell((currentItem.tag as TalkOurInfo).index, payLoad)

 -> Cell
 
 
