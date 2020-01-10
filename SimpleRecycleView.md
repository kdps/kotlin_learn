# com.jaychang.srv.SimpleRecyclerView

## Define the cell (ViewHolder)

```
class YourCell(item: YourInfo) : SimpleCell<YourInfo, YourCell.ViewHolder>(item) {
    override fun getLayoutRes(): Int {
        return R.layout.your_activity
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        //LayoutInflater.from(parent.context).inflate(getLayoutRes(), parent, false).let { return ViewHolder(it) }
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(getLayoutRes(), parent, false)
        
        return ViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int, context: Context, payload: Any?) {
         holder.binding.run {
         }
    }
    
    class ViewHolder : SimpleViewHolder {
        var binding: YourActivityBinding

        constructor(itemView: View) : super(itemView) {
            binding = DataBindingUtil.bind(itemView)!!
        }
    }
}
```

## Update Cell Item

1.Call Function -> mBinding.rvList.updateCell(index, payload)

2.Callback -> onBindViewHolder(holder: ViewHolder, position: Int, context: Context, payload: Any?)

### Example

Fragment

```
val map = java.util.HashMap<String, Boolean>()
map.put("hasLike", true)
mBinding.rvList.updateCell(position, map)
```

Cell

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
