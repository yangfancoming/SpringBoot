package com.goat.test;


import com.goat.MyArrayTool;
import org.junit.Test;


/**
 * Created by 64274 on 2018/7/27.
 *
 */
public class MyArrayTest {

    int[] arrs = {2, 1, 14, 22, 18, 3, 27, 20};

    MyArrayTool myArrayTool = MyArrayTool.getInstance();

    @Test
    public void test(){
        int temp = MyArrayTool.getMin(arrs);
        System.out.println(temp);
    }

    @Test
    public void test1(){
        int temp = MyArrayTool.getMax(arrs);
        System.out.println(temp);
    }

    @Test
    public void test2(){
        Integer[] temp ={2, 1, 14, 22, 18, 3, 27, 20};
        String lolo = myArrayTool.strPrint(temp);
        System.out.println(lolo);
    }

    @Test
    public void test3(){
        Integer[] temp ={2, 1, 14, 22, 18, 3, 27, 20};
        Integer[] lolo = myArrayTool.selectSort(temp);
        String gaga = myArrayTool.strPrint(lolo);
        System.out.println(gaga);
    }


    @Test
    public void test4(){
        int hoho1 = MyArrayTool.halfSearch(arrs,14);
        System.out.println(hoho1);
    }




}
