package edu.neu.coe.info6205.finalproject;

public class MSDSort {
    private static final int R = 26;

    public static void sort(String[] a) {
        String[] aux = new String[a.length];
        sort(a, aux, 0, a.length - 1, 0);
    }

    private static void sort(String[] a, String[] aux, int lo, int hi, int d) {
        if (hi <= lo) return;
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++)
            count[charAt(a[i], d) + 2]++;
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = lo; i <= hi; i++)
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];
        for (int r = 0; r < R; r++)
            sort(a, aux, lo + count[r], lo + count[r + 1] - 1, d + 1);
    }

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d) - 97;
        else return -1;
    }


    public static void main(String[] args) {
        String[] zhongwen = {"张三", "李四", "赵武"};
        String[] pinyin = new String[3];
        for (int i = 0; i < zhongwen.length; i++) {
            try {
                pinyin[i] = PinyinUtil.getPinYinByName(zhongwen[i]);
            } catch (Exception e) {
                System.out.println("error");
            }
        }

        for (String s : pinyin) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------");

        sort(pinyin);

        for (String s : pinyin) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------");
    }
}
