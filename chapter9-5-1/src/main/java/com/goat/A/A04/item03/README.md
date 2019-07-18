# 第二种方式
    通过静态内部类方式实现零件无序装配话构造：案例：Android中的AlertDialog
    这种方式使用更加灵活，更符合定义。内部有复杂对象的默认实现，使用时可以根据用户需求自由定义更改内容，并且无需改变具体的构造方式。就可以生产出不同复杂产品
    
    （1）主要有三个角色：抽象建造者、具体建造者、产品
    比第一种方式少了指挥者，主要是因为第二种方式把指挥者交给用户来操作，使得产品的创建更加简单灵活。
    （2）举个例子
    比如麦当劳的套餐，服务员（具体建造者）可以随意搭配任意几种产品（零件）组成一款套餐（产品），然后出售给客户。
    （3）具体步骤
    
    1、创建建造者定义麦当劳的产品
    2、创建服务员实现具体产品
    3、服务员随意搭配套餐出售给客户