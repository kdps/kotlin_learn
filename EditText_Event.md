# 1. setOnClickListener

```Kotlin
content.setOnClickListener(View.OnClickListener {
  //content.selectionStart
  //content.selectionEnd
  //content.setSelection(position)
})
```

# 2. addTextChangedListener

```Kotlin
content.addTextChangedListener(object: TextWatcher {
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    
    }

    override fun afterTextChanged(s: Editable?) {

    }

})
```

# 3. removeTextChangedListener

```Kotlin
content.removeTextChangedListener(object: TextWatcher {
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        
    }

    override fun afterTextChanged(s: Editable?) {
        
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        
    }
})
```
