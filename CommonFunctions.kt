package co.extentions.commonfunctions


fun AppCompatActivity.getDeepChildOffset(mainParent: ViewGroup, parent: ViewParent, child: View, accumulatedOffset: Point) {
    val parentGroup = parent as ViewGroup
    accumulatedOffset.x += child.left
    accumulatedOffset.y += child.top
    if (parentGroup == mainParent) {
        return
    }
    getDeepChildOffset(mainParent, parentGroup.parent, parentGroup, accumulatedOffset)
}

fun AppCompatActivity.scrollToView(scrollViewParent: ScrollView, view: View) {
    // Get deepChild Offset
    val childOffset = Point()
    getDeepChildOffset(scrollViewParent, view.parent, view, childOffset)
    // Scroll to child.
    scrollViewParent.smoothScrollTo(0, childOffset.y)
}

fun launchApp(package:String) {
    val app = package
    
    try {
        startActivity(packageManager.getLaunchIntentForPackage(app))
    } catch (e: Exception) {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + app)))
        } catch (e: Exception) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + app)))
        }
    }
}

fun AppCompatActivity.runInstagram() {
    launchApp("com.instagram.android")
}

fun AppCompatActivity.getDisplayWidth(): Int {
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    var widthPixel = displayMetrics.widthPixels

    var displayWidth = widthPixel
    return displayWidth
}

fun AppCompatActivity.hideSoftKeyboard(activity: Activity) {
    try {
        val inputMethodManager = activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager!!.hideSoftInputFromWindow(
                activity.currentFocus!!.windowToken, 0)
    } catch (e: Exception) {
        print(e.printStackTrace())
    }
}

fun AppCompatActivity.setupUI(view:View, activity: AppCompatActivity) {
    if (view !is EditText) {
        view.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                hideSoftKeyboard(activity)
                return false
            }
        })
    }

    //If a layout container, iterate over children and seed recursion.
    if (view is ViewGroup) {
        for (i in 0 until (view as ViewGroup).getChildCount()) {
            val innerView = (view as ViewGroup).getChildAt(i)
            setupUI(innerView, activity)
        }
    }
}

fun View.hidden () {
    this.visibility = View.GONE
}

fun View.shown () {
    this.visibility = View.VISIBLE
}

fun ClearEditText.disableEdit () {
    this.isEnabled = false
    this.isFocusable = false
    this.isCursorVisible = false
    this.keyListener = null
}

fun TextView.disableEdit () {
    this.isEnabled = false
    this.isFocusable = false
    this.isCursorVisible = false
    this.keyListener = null
}

fun View.setBackgroundResourceWithoutDiscard(drawable:Int) {
    var bottom: Int = this.paddingBottom
    var top = this.paddingTop
    var right = this.paddingRight
    var left = this.paddingLeft

    this.setBackgroundResource(drawable)
    this.setPadding(left, top, right, bottom)
}

fun View.setMargin(left: Int = -1, top: Int = -1, right: Int = -1, bottom: Int = -1) {
    val params = layoutParams as ViewGroup.MarginLayoutParams
    params.setMargins(if (left != -1) left else params.leftMargin, if (top != -1) top else params.topMargin, if (right != -1) right else params.rightMargin, if (bottom != -1) bottom else params.bottomMargin)
    layoutParams = params
}

fun Context.DateToMilliseconds(date: String): Long {
    var sdf: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")

    try {
        var mDate: Date = sdf.parse(date)
        var timeInMilliseconds: Long = mDate.time

        return timeInMilliseconds
    } catch (e: ParseException) {
        print(e.printStackTrace())
    }

    return 0
}

fun AppCompatActivity.DateToMilliseconds(date: String): Long {
    var sdf: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")

    try {
        var mDate: Date = sdf.parse(date)
        var timeInMilliseconds: Long = mDate.time

        return timeInMilliseconds
    } catch (e: ParseException) {
        print(e.printStackTrace())
    }

    return 0
}

fun DateToMilliseconds(date: String): Long {
    var sdf: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")

    try {
        var mDate: Date = sdf.parse(date)
        var timeInMilliseconds: Long = mDate.time

        return timeInMilliseconds
    } catch (e: ParseException) {
        print(e.printStackTrace())
    }

    return 0
}

fun Context.drawCircleCrop(v: ImageView, url: String) {
    Glide.with(this)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(v)
}

fun AppCompatActivity.drawCircleCrop(v: ImageView, u: Drawable?) {
    Glide.with(this)
            .load(u)
            .apply(RequestOptions.circleCropTransform())
            .into(v)
}

fun AppCompatActivity.drawCircleCrop(v: ImageView, url: String) {
    Glide.with(this)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(v)
}

fun AppCompatActivity.isVisible(view: View): Boolean {
    if (view == null) {
        return false
    }
    if (!view.isShown) {
        return false
    }

    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)

    var width = displayMetrics.widthPixels
    var height = displayMetrics.heightPixels

    var actualPosition: Rect = Rect()

    view.getGlobalVisibleRect(actualPosition)
    var screen: Rect = Rect(0, 0, width, height)

    return actualPosition.intersect(screen)
}

fun AppCompatActivity.isViewFullyVisible(view: View): Boolean {
    if (view == null || !view.isShown)
        return false

    //windowRect - will hold available area where content remain visible to users
    //Takes into account screen decorations (e.g. statusbar)
    var windowRect: Rect = Rect()
    view.getWindowVisibleDisplayFrame(windowRect)

    //if there is toolBar, get his height
    var actionBarHeight: Int = 0
    var context: Context = view.context
    if (context is AppCompatActivity && context.supportActionBar != null)
        actionBarHeight = context.supportActionBar!!.height
    else if (context is Activity && context.actionBar != null)
        actionBarHeight = context.actionBar.height

    //windowAvailableRect - takes into account toolbar height and statusbar height
    var windowAvailableRect: Rect = Rect(windowRect.left, windowRect.top + actionBarHeight, windowRect.right, windowRect.bottom)

    //viewRect - holds position of the view in window
    //(methods as getGlobalVisibleRect, getHitRect, getDrawingRect can return different result,
    // when partialy visible)
    var viewRect: Rect

    var viewsLocationInWindow = IntArray(2)
    view.getLocationInWindow(viewsLocationInWindow)
    var viewLeft = viewsLocationInWindow[0]
    var viewTop = viewsLocationInWindow[1]
    var viewRight = viewLeft + view.width
    var viewBottom = viewTop + view.height
    viewRect = Rect(viewLeft, viewTop, viewRight, viewBottom)

    //return true, only if the WHOLE view is visible in window
    return windowAvailableRect.contains(viewRect)
}

fun View.setLayoutWidthHeight(width: Int, height: Int) {
    if (this is LinearLayout) {
        val params = LinearLayout.LayoutParams(width, height)
        this.layoutParams = params
    } else if (this is FrameLayout) {
        val params = FrameLayout.LayoutParams(width, height)
        this.layoutParams = params
    } else {
        this.layoutParams = ViewGroup.LayoutParams(width, height)
    }
}

fun AppCompatActivity.getDimenPixelSize(@DimenRes dimen:Int): Int {
    return resources.getDimensionPixelSize(dimen)
}
