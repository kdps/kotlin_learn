# android.support.v4.widget.NestedScrollView

## 1.1 Detect Scrolling

```
mBinding.scrollDetect.setOnScrollChangeListener { v: NestedScrollView, _: Int, scrollY: Int, _: Int, oldScrollY: Int ->
  if(v.getChildAt(v.getChildCount() - 1) != null) {
    if ((scrollY + gap >= (v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight())) && scrollY > oldScrollY) {
      // When scroll to bottom
    }
  }
}
```
