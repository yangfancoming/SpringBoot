/**
 立即执行函数就是：声明一个匿名函数，马上调用这个匿名函数

*/


(function(){console.log('我是匿名函数1')} ()); // 用括号把整个表达式包起来
(function(){console.log('我是匿名函数2')}) () ;//用括号把函数包起来
/**
 上面是一个典型的立即执行函数。
 首先声明一个匿名函数 function(){alert('我是匿名函数')}。
 然后在匿名函数后面接一对括号 ()，调用这个匿名函数。
*/

/**
 2. 立即执行函数有什么用？
 只有一个作用：创建一个独立的作用域。
 这个作用域里面的变量，外面访问不到（即避免「变量污染」）。
*/

/**
 为什么 alert 的总是 6 呢，因为 i 是贯穿整个作用域的，而不是给每个 li 分配了一个 i，如下：
 那么怎么解决这个问题呢？用立即执行函数给每个 li 创造一个独立作用域即可（当然还有其他办法）：
*/
// let liList = ul.getElementsByTagName('li')
// for(let i=0; i<6; i++){
//     liList[i].onclick = function(){
//         console.log(i,111111111) // 为什么 alert 出来的总是 6，而不是 0、1、2、3、4、5
//     }
// }

/**
 在立即执行函数执行的时候，i 的值被赋值给 ii，此后 ii 的值一直不变。
 i 的值从 0 变化到 5，对应 6 个立即执行函数，这 6 个立即执行函数里面的 ii 「分别」是 0、1、2、3、4、5。
 以上，就是立即执行函数的基本概念。
*/
// let liList = ul.getElementsByTagName('li')
// for(let i=0; i<6; i++){
//     !function(ii){
//         liList[ii].onclick = function(){
//             alert(ii) // 0、1、2、3、4、5
//         }
//     }(i)
// }


((a)=> {
    console.log(a);  //使用()运算符，打印出 11
})(11);

(function(a) {
    console.log(a);  //使用()运算符，打印出 22
}(22));


/**
 立即执行函数的返回值 像其它任何函数一样，一个立即执行函数也能返回值并且可以复制给其它变量
*/

let result = (function () {
    return 2 + 2;
})();

console.log(result,"我是返回值")




