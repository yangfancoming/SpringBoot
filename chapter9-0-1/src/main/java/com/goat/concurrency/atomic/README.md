# AtomicInteger ---> CAS ---> Unfafe 类 ---> CAS底层思想  ---> ABA ---> 原子引用更新 ---> 如何规避ABA问题

    ABA ： 狸猫换太子
    即：线程A和B 同时从主存读取3到自己的工作内存  由于B线程执行效率高 经过多次更改3到5 3到9。。。最后又将9改到3，那么再线程A 看来期望值与真实值相同
        则 认为 主存中的没有被人改动后，实际上 已经被狸猫换太子多次了。。。 
        
     ABA问题的两种态度：
     1.不关心过程 只关心结果：整型 AtomicInteger  借钱问题，被借了1000元钱 不管你们拿这1000元去做了什么 做了几次，只要最终还给我1000元就行，其他我不管。
     2.关心过程：对象类型  女友问题，女友被借走了，最终还我了 还不行，我还必须关心 女友和你在一起的过程中   都做了什么。。。  