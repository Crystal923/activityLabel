## 项目开发说明  

目前市场上的电商类APP层出不穷，风格也是各式各样，前些天做的一个电商类APP中有这样一个需求：在商品名称的前面显示一个活动标签，并且活动标签的数量不确定，商品名称可能是一行或者多行，如下图所示：  

![image](https://github.com/KN923/activityLable/raw/master/img/a.png)  
刚看到这个需求，第一个想法就是用spannablestring对字符串进行设置，可是后来发现只能对文字的前景色背景色进行设置，并不支持给某个文字设置背景图片。怎么办呢？开始向朋友们请教，但他们说法各异有说自定义view的，有说自己画的....最后受到一个朋友启发，用ReplacementSpan试试，可是这是个啥呢，以前从未见过，根据名字猜测还是要用spannablestring来实现，于是开始各种查询，发现这是一个抽象类，开发者需要去继承这个类，在类中自己去实现自己的需求。大致看了一下，就开始动手写了....详情请见代码，欢迎下载 [活动标签的实现](https://github.com/KN923/activityLable.git) 。  

实现效果是这样子的哦！  
![image](https://github.com/KN923/activityLable/raw/master/img/b.png=54*96)

