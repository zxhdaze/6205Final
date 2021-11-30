package edu.neu.coe.info6205.finalproject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {

    @Test
    public void testSort1() {
        String[] cnNames = {"张三", "李四", "扎炸", "赵武"};
        QuickSortDualPivot.sort(cnNames, 0, cnNames.length - 1);

        assertEquals("李四", cnNames[0]);
        assertEquals("扎炸", cnNames[1]);
        assertEquals("张三", cnNames[2]);
        assertEquals("赵武", cnNames[3]);
    }

    @Test
    public void testSort2() {
        String[] cnNames = {"刘持平", "洪文胜", "樊辉辉", "苏会敏", "高民政"};
        QuickSortDualPivot.sort(cnNames, 0, cnNames.length - 1);

        assertEquals("樊辉辉", cnNames[0]);
        assertEquals("高民政", cnNames[1]);
        assertEquals("洪文胜", cnNames[2]);
        assertEquals("刘持平", cnNames[3]);
        assertEquals("苏会敏", cnNames[4]);
    }

    @Test
    public void test3() {
        String[] cnNames = {"李维颖", "安文春", "蔡宗伯", "杜渝", "喻春芳", "舒乐乐", "黎江江"};
        QuickSortDualPivot.sort(cnNames, 0, cnNames.length - 1);

        assertEquals("安文春", cnNames[0]);
        assertEquals("蔡宗伯", cnNames[1]);
        assertEquals("杜渝", cnNames[2]);
        assertEquals("黎江江", cnNames[3]);
        assertEquals("李维颖", cnNames[4]);
        assertEquals("舒乐乐", cnNames[5]);
        assertEquals("喻春芳", cnNames[6]);
    }

}
