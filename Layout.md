1. How to set gravity with data binding

```XML

    <data>
        <import type="android.view.Gravity" />
    </data>
    
    
    <TextView
        android:id="@+id/android_suck"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="@{info.android == info.suck ? Gravity.CENTER_HORIZONTAL  : Gravity.END}"
        android:text="android is suck"
        />

```
