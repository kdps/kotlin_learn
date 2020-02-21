1. How to set gravity with data binding

```XML
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    >
    
    <data>
        <import type="android.view.Gravity" />
        
        <variable ...
                  
    </data>
    
    
    <TextView
        android:id="@+id/android_suck"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="@{info.android == info.suck ? Gravity.CENTER_HORIZONTAL  : Gravity.END}"
        android:text="android is suck"
        />
    
</layout>
```
