# com.jaychang.srv.SimpleRecyclerView

# Define the cell (ViewHolder)

```Kotlin
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

# addOnScrollListener
```Kotlin
srList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
    }
})
```

Scroll Find by Item Position

```Kotlin
var firstVisibleInListview: Int = -1

mBinding.rvList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        val currentFirstVisible = mLayoutManager.findFirstVisibleItemPosition()

        if (currentFirstVisible > firstVisibleInListview) {
            // UP
        } else {
            // DOWN
        }
        
        firstVisibleInListview = currentFirstVisible
    }
}
```

Toggle when up/down

```Kotlin
var beforeY = -1
var marginHeight = -1
var typeScroll = ""

mBinding.rvList.run {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            if (marginHeight == -1) {
                if (dy > 0 && mBinding.llBar.visibility == View.VISIBLE) { // DOWN
                    mBinding.llBar.visibility = View.GONE
                    typeScroll = "down"
                } else if (dy < 0 && mBinding.llBar.visibility != View.VISIBLE) { // UP
                    mBinding.llBar.visibility = View.VISIBLE
                    typeScroll = "up"
                }

                if (dy != 0) {
                    marginHeight = mBinding.llBar.height
                    beforeY = dy
                }
            } else { // Stop event when changed status of visible
                if (typeScroll == "up") {
                    if (dy < beforeY && mBinding.llBar.visibility == View.VISIBLE) {
                        mBinding.llBar.visibility = View.GONE
                        marginHeight = -1
                    } else { // Otherwise
                        typeScroll = "bool"
                    }
                } else if (typeScroll == "down") {
                    print("down" + dy.toString() + "//" + marginHeight.toString() + "\n")
                    if (dy > beforeY && mBinding.llBar.visibility != View.VISIBLE) {
                        mBinding.llBar.visibility = View.VISIBLE
                        marginHeight = -1
                    } else { // Otherwise
                        typeScroll = "bool"
                    }
                } else if (typeScroll == "bool") { // Otherwise
                    marginHeight = -1
                }
            }
        }
    }
}
```

# Smooth Scroll is Not Enabled

### Maybe SimpleRecyclerView is Contained by NestedScrollView, Just use this code

```Kotlin
mBinding.srList.setNestedScrollingEnabled(false)
```

# Insert Cell To Top

```Kotlin
mBinding.srList.addCell(0, cell)
```

# Update Cell Item

1.Call Function -> mBinding.rvList.updateCell(index, payload)

2.Callback -> onBindViewHolder(holder: ViewHolder, position: Int, context: Context, payload: Any?)

### Example

Fragment

```Kotlin
val map = java.util.HashMap<String, Boolean>()
map.put("hasLike", true)
mBinding.srList.updateCell(position, map)
```

Cell

```Kotlin
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
