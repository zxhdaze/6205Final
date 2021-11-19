package edu.neu.coe.info6205.finalproject;

public class QuickSortDualPivot {

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;

        // make sure a[lo] <= a[hi]
        if (less(a[hi], a[lo])) exch(a, lo, hi);

        int lt = lo + 1, gt = hi - 1;
        int i = lo + 1;
        while (i <= gt) {
            if (less(a[i], a[lo])) exch(a, lt++, i++);
            else if (less(a[hi], a[i])) exch(a, i, gt--);
            else i++;
        }
        exch(a, lo, --lt);
        exch(a, hi, ++gt);

        sort(a, lo, lt - 1);
        if (less(a[lt], a[gt])) sort(a, lt + 1, gt - 1);
        sort(a, gt + 1, hi);
    }

    private static boolean less(Comparable a, Comparable b) {
        if (a.compareTo(b) < 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // Read strings from standard input, sort them, and print.
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

        QuickSortDualPivot.sort(pinyin, 0, pinyin.length - 1);

        for (String s : pinyin) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------");
    }
}
