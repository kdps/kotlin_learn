package co.extentions.settouchwithduraration

var pressStartTime: Long = 0
var pressedX: Float = 0.toFloat()
var pressedY: Float = 0.toFloat()

fun FragmentActivity.distance(x1: Float, y1: Float, x2: Float, y2: Float): Float {
    val dx = x1 - x2
    val dy = y1 - y2
    val distanceInPx = Math.sqrt((dx * dx + dy * dy).toDouble()).toFloat()
    return pxToDp(distanceInPx)
}

fun FragmentActivity.pxToDp(px: Float): Float {
    return px / resources.displayMetrics.density
}

fun FragmentActivity.onTouchEvent(e: MotionEvent, ClickDuraration: Int, ClickDistance: Int, onPressedEvent: (result: Boolean?) -> Unit) {
     when (e.action) {
         MotionEvent.ACTION_DOWN -> {
            pressStartTime = System.currentTimeMillis();
            pressedX = e.x;
            pressedY = e.y;
        }
         MotionEvent.ACTION_UP -> {
            var pressDuration = System.currentTimeMillis() - pressStartTime;
            if (pressDuration < ClickDuraration && distance(pressedX, pressedY, e.x, e.y) < ClickDistance) {
                onPressedEvent(true)
            } else {
                onPressedEvent(false)
            }
        }
    }
}

fun FragmentActivity.setOnTouchWithDuraration(view:FrameLayout, ClickDuraration: Int, ClickDistance: Int, onPressedEvent: (result: Boolean?) -> Unit) {
    view.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
        onTouchEvent(motionEvent, ClickDuraration, ClickDistance, onPressedEvent)

        return@OnTouchListener true
    })
}
