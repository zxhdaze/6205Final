package edu.neu.coe.info6205.finalproject;

import java.text.Collator;
import java.util.Locale;

public class QuickSortDualPivot {

    private static Collator collator = Collator.getInstance(Locale.CHINA);

    private static void sort(String[] a, int lo, int hi) {
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

//    private static boolean less(String a, String b) {
//        if (a.compareTo(b) < 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    private static boolean less(String s1, String s2) {
        if (collator.compare(s1, s2) < 0) {
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
        String[] cnNames = {"张三", "李四", "扎炸", "赵武"};

        /* Sort by chinese name  */
        for (String s : cnNames) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------");

        QuickSortDualPivot.sort(cnNames, 0, cnNames.length - 1);

        for (String s : cnNames) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------");

//        /* Sort by pinyin */
//        String[] pinyin = new String[3];
//        for (int i = 0; i < cnNames.length; i++) {
//            try {
//                pinyin[i] = PinyinUtil.getPinYinByName(cnNames[i]);
//                pinyin[i] = cnNames[i];
//            } catch (Exception e) {
//                System.out.println("error");
//            }
//        }
//
//        for (String s : pinyin) {
//            System.out.println(s);
//        }
//        System.out.println("-------------------------------------");
//
//        QuickSortDualPivot.sort(pinyin, 0, pinyin.length - 1);
//
//        for (String s : pinyin) {
//            System.out.println(s);
//        }
//        System.out.println("-------------------------------------");
    }
}
