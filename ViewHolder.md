
## Add Cell EventListener

Cell Class

```Kotlin
class BaseCell(item: BaseInfo) : SimpleCell<BaseInfo, TalkCommentCell.ViewHolder> (item) {

  lateinit var mListener: View.OnClickListener

  override fun onBindViewHolder(holder: ViewHolder, position: Int, context: Context, payload: Any?) {
    holder.binding.run {
      element.setOnClickListener {
          mListener.onClick(it)
      }
    }
  }
    
}
```

BaseActivity

```Kotlin
class YourActivity : BaseActivity() {

  fun setCellEvent(cell: BaseCell) {
    cell.mListener = View.OnClickListener {
       var _it = it // Usable View Of Cell
    }
  }
  
}
```
