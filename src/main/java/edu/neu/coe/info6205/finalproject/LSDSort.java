package edu.neu.coe.info6205.finalproject;

import java.util.*;

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

    /**
     * Sort Chinese by LSD Radix algorithm.
     * @param a string array of Chinese names.
     */
    public static void sortChinese(String[] a) {
        int[] map = new int[a.length];
        for (int i = 0; i < map.length; i++)
            map[i] = i;
        String[] paddedPinyins = preprocessData(a);
        sort(paddedPinyins, maxLenOfPinyin, map);
        String[] rawA = new String[a.length];
        System.arraycopy(a, 0, rawA, 0, a.length);
        for (int i = 0; i < a.length; i++)
            a[i] = rawA[map[i]];

    }

    /**
     * Radix sort by pinyin.
     * @param a string array of pinyin.
     * @param W maximum string length of @param a.
     * @param map map to raw pinyin.
     *            1 -> ["zhang1", "san1"]
     *            2 -> ["li3", "si4"]
     *            3 -> ["zhao4", "wu3"]
     */
    private static void sort(String[] a, int W, int[] map) {
        int R = 256;
        int N = a.length;
        int[] aux = new int[N];
//        System.out.println(W);
        for (int d = W-1; d >= 0; d--)
        {
//            System.out.println("-----------------------" + d);
//            for (int i = 0; i < a.length; i++)
//                System.out.println(a[map[i]]);
//            System.out.println("-----------------------");
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++)
                count[a[map[i]].charAt(d)+1]++;
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];
            for (int i = 0; i < N; i++)
                aux[count[a[map[i]].charAt(d)]++] = map[i];
            for (int i = 0; i < N; i++)
                map[i] = aux[i];
        }
    }

    private static int maxLen = 0; // max length of name

    private static final char paddingChar = '#'; // padding character (less than all alphabet and tones)

    private static final int maxLengthOfChar = 7; // maximum length of pinyin with tone (e.x. zhuang1)

    private static int maxLenOfPinyin = 0; // max length of pinyin of a name.

    /**
     * Get pinyin.
     * @param names string array of Chinese names.
     * @return a list of pinyin name.
     *         [
     *          ["zhang1", "san1"],
     *          ["li3", "si4"],
     *          ["zhao4", "wu3"],
     *         ]
     */
    private static List<String[]> getPinyin(String[] names) {
        maxLen=0;
        List<String[]> pinyins = new ArrayList<>(names.length);
        Arrays.stream(names).forEach(name -> {
            String[] pinyin = PinyinUtil.getPinyinWithVWithTone(name);
            if (maxLen < pinyin.length)
                maxLen = pinyin.length;
            pinyins.add(pinyin);
        });
        return pinyins;
    }

    /**
     * TODO: get max length in another way.
     * Get maximum length of pinyin.
     * @param names array of pinyin names.
     * @return int maximum length of pinyin.
     */
    private static int getMaxLengthOfPinyin(String[] names) {
        int maxLen=0;
        for (String name : names)
            if (maxLen < name.length())
                maxLen = name.length();

        return maxLen;
    }

    private static String[] preprocessData(String[] ChineseNames) {
        List<String[]> pinyins = getPinyin(ChineseNames);
        maxLenOfPinyin = maxLengthOfChar * maxLen;
        // padding
        return pad(pinyins);
    }

    /**
     * Pad all pinyin name with @param paddingChar.
     * @param pinyins list of pinyin.
     * @return string array of padded pinyin.
     */
    private static String[] pad(List<String[]> pinyins) {
        String[] padded = new String[pinyins.size()];
        for (int i = 0; i < pinyins.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < pinyins.get(i).length; j++) {
                String pinyinOfChar = pinyins.get(i)[j];
                sb.append(pinyinOfChar);
                for (int k = pinyinOfChar.length(); k < maxLengthOfChar; k++)
                    sb.append(paddingChar);
            }
            for (int j = sb.length(); j < maxLenOfPinyin; j++)
                sb.append(paddingChar);
            padded[i] = sb.toString();
        }

        return padded;
    }

    public static void main(String[] args) {
//        String[] zhongwen = FileUtil.getAllNamesToArray();
        String[] zhongwen = {"张三", "李四", "扎炸", "赵武", "瞿瞿"};
        String[] s = PinyinUtil.getPinyinWithVWithTone(zhongwen[4]);
        System.out.println(s[0]);
        sortChinese(zhongwen);
    }

}
