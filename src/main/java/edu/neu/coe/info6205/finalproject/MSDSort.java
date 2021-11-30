package edu.neu.coe.info6205.finalproject;

import java.util.Arrays;

public class MSDSort {
    private static final int R = 256;

    /**
     * Radix sort by pinyin
     * @param a string array of pinyin
     */
    private static void sort(String[] a, int[] map) {
        String[] aux = new String[a.length];
        int[] amap = new int[map.length];
        sort(a, aux,map,amap, 0, a.length - 1, 0);
    }

    /**
     * Radix sort by pinyin
     * @param a string array of pinyin
     * @param aux
     * @param lo
     * @param hi
     * @param d
     */
    private static void sort(String[] a, String[] aux,int[] map, int[] amap, int lo, int hi, int d) {
        if (hi <= lo) return;
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++)
            count[charAt(a[i], d) + 2]++;
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = lo; i <= hi; i++){
            aux[count[charAt(a[i], d) + 1]] = a[i];
            amap[count[charAt(a[i], d) + 1]] = map[i];
            count[charAt(a[i], d) + 1]++;
        }

        for (int i = lo; i <= hi; i++){
            a[i] = aux[i - lo];
            map[i] = amap[i-lo];
        }


        for (int r = 0; r < R; r++)
            sort(a, aux, map,amap,lo + count[r], lo + count[r + 1] - 1, d + 1);
    }


    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }


    private static void sortChinese(String[] zhongwen){
        String[] pinyin = preprocess(zhongwen);
        int[] map = new int[zhongwen.length];
        for (int i = 0; i < map.length; i++)
            map[i] = i;
        sort(pinyin,map);
        String[] rawA = new String[zhongwen.length];
        System.arraycopy(zhongwen,0,rawA,0,zhongwen.length);
        for(int i = 0; i < zhongwen.length;i++)
            zhongwen[i] = rawA[map[i]];
        for (int i = 0;i < zhongwen.length;i++)
            System.out.println(zhongwen[i]);




    }

    private static String[] preprocess(String[] zhongwen){
        String[] pinyin = new String[zhongwen.length];
        for (int i = 0; i < zhongwen.length; i++) {
            try {
                pinyin[i] = PinyinUtil.getPinYinByName(zhongwen[i]);
            } catch (Exception e) {
                System.out.println("error");
            }
        }
        return pinyin;
    }

    public static void main(String[] args) {
        String[] zhongwen = FileUtil.getAllNamesToArray();
        zhongwen = Arrays.copyOfRange(zhongwen,0,10);
        //String[] zhongwen = {"张三", "李四", "扎炸", "赵武"};
        sortChinese(zhongwen);
//        String[] pinyin = new String[3];
//        for (int i = 0; i < zhongwen.length; i++) {
//            try {
//                pinyin[i] = PinyinUtil.getPinYinByName(zhongwen[i]);
//            } catch (Exception e) {
//                System.out.println("error");
//            }
//        }

//        for (String s : pinyin) {
//            System.out.println(s);
//        }
//        System.out.println("-------------------------------------");

//        sort(pinyin);

//        for (String s : pinyin) {
//            System.out.println(s);
//        }
//        System.out.println("-------------------------------------");
    }
}
