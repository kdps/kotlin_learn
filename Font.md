

# 1. Size

# 2. Color

# 3. Appearance

## 3.1. Single

## 3.2. Multiple

```Kotlin
val tv = moreText
var cnt = commentCount.toString().length + "개 댓글 더보기".length

var text:Spannable = SpannableString(commentCount.toString());
text.setSpan( TextAppearanceSpan(getContext(), R.style.Text_20_A8A6A6_Bold), 0, commentCount.toString().length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
text.setSpan( StyleSpan(Typeface.BOLD), 0, commentCount.toString().length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
tv.setText(text, SPANNABLE);

text = SpannableString("개 댓글 더보기");
text.setSpan( TextAppearanceSpan(getContext(), R.style.Text_20_A8A6A6), 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
tv.append(text);
```
