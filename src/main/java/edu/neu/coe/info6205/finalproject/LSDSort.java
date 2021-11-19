package edu.neu.coe.info6205.finalproject;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LSDSort {
    public static void sort(String[] a, int W)  {
        int R = 256;
        int N = a.length;
        String[] aux = new String[N];
        for (int d = W-1; d >= 0; d--)
        {
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
//    List<List<String>> pinyinNames = getPinyinNames(ChineseNames);

    // pad pinyin to same length
//    String[] name = PinyinUtil.getPinYinByName()
//
//    List<String> entirePinyinNames = new ArrayList<>(ChineseNames.length);
//        for (List<String> pinyinName : pinyinNames) {
//        StringBuilder sb = new StringBuilder();
//        for (String s : pinyinName) {
//            int diff = maxCharLength - s.length();
//            sb.append(s);
////                for (int k = 0; k < diff; k++)
////                    sb.append(padding);
////                sb.append(s);
//        }
//        maxChineseNameLength = Math.max(maxChineseNameLength, sb.length());
//        entirePinyinNames.add(sb.toString());
//    }
//        for (int i = 0; i < entirePinyinNames.size(); i++) {
//        StringBuilder sb = new StringBuilder();
//        int diff = maxChineseNameLength - entirePinyinNames.get(i).length();
////            sb.append(entirePinyinNames.get(i));
//        for (int k = 0; k < diff; k++)
//            sb.append(padding);
//        sb.append(entirePinyinNames.get(i));
//        entirePinyinNames.set(i, sb.toString());
//    }

    static int maxLen = 0;

    private static String[] getPaddingName(String[] names) {
        List<String> pinyinNames = new ArrayList<>();
        Arrays.stream(names).forEach(s-> {
            try {
                String str = PinyinUtil.getPinYinByName(s);
                maxLen = Math.max(maxLen, str.length());
                pinyinNames.add(PinyinUtil.getPinYinByName(s));
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        });

        return pinyinNames.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] zhongwen = {"张三", "李四", "赵武"};
        String[] name = getPaddingName(zhongwen);
        String[] padded = new String[zhongwen.length];
        for (int i = 0; i < name.length; i++) {
            StringBuilder sb = new StringBuilder();
            int diff = maxLen-name[i].length();
            sb.append(name[i]);
            for (int j = 0; j < diff; j++) {
                sb.append('`');
            }
            padded[i] = sb.toString();
        }
        sort(padded, maxLen);
        Arrays.stream(padded).forEach(System.out::println);
    }


}
