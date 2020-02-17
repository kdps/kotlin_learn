

# 1. Size

# 2. Color

# 2.1. Single

# 2.2. Multiple

# 2.2.1. TextView

```Kotlin
val textView = textViewElement

val wordThree = SpannableString("3")
wordThree.setSpan(ForegroundColorSpan(Color.parseColor("#F0A819")), 0, wordThree.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
textView.setText(wordThree)

val wordTwo = SpannableString("2")
wordTwo.setSpan(ForegroundColorSpan(Color.parseColor("#F0A819")), 0, wordTwo.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
textView.setText(wordTwo)

val word = SpannableString("One")
word.setSpan(ForegroundColorSpan(Color.BLACK), 0, word.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
textView.append(word)
```

# 3. Appearance

## 3.1. Single

## 3.2. Multiple

### 3.2.1. TextView

! Do not apply style to TextView

```Kotlin
val tv = textViewElement
var number = "1234567890"
var text = " is Number"

var span:Spannable = SpannableString(number.toString());
span.setSpan( TextAppearanceSpan(getContext(), R.style.Text_20_A8A6A6_Bold), 0, number.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
span.setSpan( StyleSpan(Typeface.BOLD), 0, number.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
tv.setText(span, TextView.BufferType.SPANNABLE);

span = SpannableString(text);
span.setSpan( TextAppearanceSpan(getContext(), R.style.Text_20_A8A6A6), 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
tv.append(text);
```

### 3.2.2. Span Click Event

```Kotlin
var start = "Start"
var example = "Example"

text.setSpan(TextAppearanceSpan(mActivity, R.style.Text_20_Basic), 0, start.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
appendTarget.setText(text, TextView.BufferType.SPANNABLE)

var text: Spannable = SpannableString(example)
val clickableSpan1 = object : ClickableSpan() {
    override fun onClick(widget: View) {
        doEvent()
    }
}
text.setSpan(clickableSpan1, 0, example.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
text.setSpan(TextAppearanceSpan(mActivity, R.style.Text_20_Basic), 0, example.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
text.setSpan(StyleSpan(Typeface.BOLD), 0, example.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

appendTarget.append(text)
appendTarget.movementMethod = LinkMovementMethod.getInstance()
```
