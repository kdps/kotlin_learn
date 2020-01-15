

# 1. Size

# 2. Color

# 3. Appearance

## 3.1. Single

## 3.2. Multiple

### 3.2.1. TextView

! Do not apply style to TextView

```Kotlin
val tv = moreText
var number = "1234567890"
var text = " is Number"

var text:Spannable = SpannableString(number.toString());
text.setSpan( TextAppearanceSpan(getContext(), R.style.Text_20_A8A6A6_Bold), 0, number.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
text.setSpan( StyleSpan(Typeface.BOLD), 0, number.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
tv.setText(text, SPANNABLE);

text = SpannableString(text);
text.setSpan( TextAppearanceSpan(getContext(), R.style.Text_20_A8A6A6), 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
tv.append(text);
```
