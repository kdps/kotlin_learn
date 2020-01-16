
|---|:---:|:---:|---:|
|Android 8.0|Oreo|26|Build.VERSION_CODES.O|
|Android 7.1.1|Nougat|25|Build.VERSION_CODES.N_MR1|
|Android 7.0|Nougat|24|Build.VERSION_CODES.N|
|Android 6.0|Marshmallow|23|Build.VERSION_CODES.M|
|Android 5.1|Lollipop|22|Build.VERSION_CODES.LOLLIPOP_MR1|
|Android 5.0|Lollipop|21|Build.VERSION_CODES.LOLLIPOP|
|Android 4.4W|KitKat Wear|20|Build.VERSION_CODES.KITKAT_WATCH|

Android 4.4

KitKat

19

Build.VERSION_CODES.KITKAT

Android 4.3

Jelly Bean

18

Build.VERSION_CODES.JELLY_BEAN_MR2

Android 4.2, 4.2.2

Jelly Bean

17

Build.VERSION_CODES.JELLY_BEAN_MR1

Android 4.1, 4.1.1

Jelly Bean

16

Build.VERSION_CODES.JELLY_BEAN

Android 4.0.3, 4.0.4

IceCreamSandwich

15

Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1

Android 4.0, 4.0.1, 4.0.2

IceCreamSandwich

14

Build.VERSION_CODES.ICE_CREAM_SANDWICH 

Android 3.2

Honeycomb

 13 

Build.VERSION_CODES.HONEYCOMB_MR2

Android 3.1.x

Honeycomb

12

Build.VERSION_CODES.HONEYCOMB_MR1

Android 3.0.x

Honeycomb

11

Build.VERSION_CODES.HONEYCOMB

Android 2.3.4

Android 2.3.3

Gingerbread

10

Build.VERSION_CODES.GINGERBREAD_MR1

Android 2.3.2

Android 2.3.1

Android 2.3

Gingerbread

9

Build.VERSION_CODES.GINGERBREAD

Android 2.2.x

Froyo

8

Build.VERSION_CODES.FROYO

Android 2.1.x

Eclair

7

Build.VERSION_CODES.ECLAIR_MR1

Android 2.0.1

Eclair

6

Build.VERSION_CODES.ECLAIR_0_1

Android 2.0

Eclair

5

Build.VERSION_CODES.ECLAIR

Android 1.6

Donut

4

Build.VERSION_CODES.DONUT

Android 1.5

Cupcake

3

Build.VERSION_CODES.CUPCAKE

Android 1.1

Base

2

Build.VERSION_CODES.BASE_1_1

Android 1.0

Base

1

Build.VERSION_CODES.BASE



# 1. Check Marshmallow

```Kotlin
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

}
```

# 2. Check Oreo

```Kotlin
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

}
```
