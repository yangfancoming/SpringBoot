
package com.goat.A.A03.example01;

/**  饿汉式
 *  1. 在类加载时就创建 因此，天然的线程安全
 *  2. 私有化 构造函数
 */
public class Emperor {

    /** 在类加载时就创建 不管以后是否使用 因此没有延时加载的优势*/
	private static final Emperor emperor = new Emperor();  //初始化一个皇帝

    // private 构造函数 保证了该类不能被其他类new出来
	private Emperor(){
		//世俗和道德约束你，目的就是不希望产生第二个皇帝
	}

	// 外部获取接口  因为该类是在类加载时就创建 因此天然的线程安全，所以在外部获取接口方法上 无需加 synchronized
	public static  Emperor getInstance(){
		return emperor;
	}
	
	//皇帝发话了
	public static void say(){
		System.out.println("我就是皇帝某某某....");		
	}
}
