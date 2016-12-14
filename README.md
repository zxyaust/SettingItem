# 自定义组合控件SettingItem
设置条目以及类似的条目,拜托写多天设置条目的麻烦,写代码更高效

![此处输入图片的描述][1]
#1.用法及原理
gradle引用
```
compile 'com.z:SettingItem:1.0.0'
```
    内部的各个组件:左边的text,imageview,右边的textview,imageview以及tag都是public的,在代码中可以找到随便用随便设置,增加了使用的灵活性,但如果不是不得已,不建议这样使用,因为自定义属性完全可以控制所有的布局显示.
#2.属性和方法
##1.属性
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <declare-styleable name="SettingItem">
        <!--左边image-->
        <attr name="left_image" format="reference"></attr>//drawableId
        <attr name="left_image_width" format="dimension"></attr>
        <attr name="left_image_height" format="dimension"></attr>
        <attr name="left_image_marginRight" format="dimension"></attr>
        <!--左边text-->
        <attr name="left_text" format="string"></attr>
        <attr name="left_text_size" format="dimension"></attr>
        <attr name="left_text_color" format="color"></attr>
        <!--tag-->
        <attr name="show_dot" format="boolean"></attr>
        <attr name="tag_text_visible" format="boolean"></attr>
        <attr name="tag_text" format="string"></attr>
        <attr name="tag_text_size" format="dimension"></attr>
        <attr name="tag_text_color" format="color"></attr>
        <attr name="tag_text_bg_color" format="color"></attr>
        <attr name="tag_text_marginRight" format="dimension"></attr>
        <!--右边text-->
        <attr name="right_text" format="string"></attr>
        <attr name="right_text_size" format="dimension"></attr>
        <attr name="right_text_color" format="color"></attr>
        <!--右边image-->
        <attr name="right_image" format="reference"></attr>
        <attr name="right_image_width" format="dimension"></attr>
        <attr name="right_image_height" format="dimension"></attr>
        <attr name="right_image_marginLeft" format="dimension"></attr>
    </declare-styleable>
</resources>
```
##2.方法
setTagBg(int color)//设置tag的背景颜色

setTagText(String s)//设置tag的文字,会自动让tag显示出来

void showDot()//显示dot

void removeTagAndDot()//去掉tag和dot

#3.注意
    dot和tag本质是同一个textview,showdot属性为true时,tag的文本会自动消失,同样tagVisible属性为false的时候showdot为true也没有用的
#4.自定义控件中get到的技能
        1.textview的settextSize方法中用的是sp值,但通过array.getDimension方法获取的值是px值,所以需要转换才能使用
        2.getDimensionPixelOffset和getDimensionPixelOffset相同,但第一个返回int值,第二个返回float值,返回值都是px值,即使你设置的是dp值或者sp值,他都会转换成px值,平时用这两个方法就好了,另一个方法不好用,不说了
        3.int color = Color.argb(255,100,200,100);textview.setTextColor方法参数是int,可以使用这个方法把color值转换成int值,而且资源文件中获取到的color引用最后也都是转换成int值的.
        4.shape的颜色可以动态通过代码改变,方法如下
    GradientDrawable background = (GradientDrawable)tag.getBackground();
    background.setColor(color);
    tag.setBackgroundDrawable(background);


  [1]: https://github.com/zxyaust/SettingItem/blob/master/demo.png?raw=true
