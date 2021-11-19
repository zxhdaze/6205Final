package edu.neu.coe.info6205.finalproject;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinUtil {

//    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
//
////        String str = PinyinUtil.getPinYinHeadChar("小超人");
////        System.out.println(str);
//
////        String[] strs = PinyinUtil.getPinYinWithToneMark("小");
////        for (String str : strs) {
////            System.out.println(str);
////        }
//        getPinYinByName("的发射点");
//    }

    /**
     * 传入中文获取首字母 （小写）
     * 如：小超人 -> xcr
     *
     * @param str 需要转化的中文字符串
     * @return
     */
    public static String getPinYinHeadChar(String str) {
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }


//    /**
//     * 获取中文字的拼音（多音字，拼音后的数字代表第几声）
//     * 如：空 -> kong1 kong4
//     *
//     * @param word
//     * @return
//     */
//    public static String[] getPinYin(char word) {
//        return PinyinHelper.toHanyuPinyinStringArray(word);
//    }

    /**
     * 获取中文字的拼音（多音字，拼音上的符号代表第几声）
     * 如：空 -> kōng kòng
     *
     * @param word
     * @return
     */

    public static String[] getPinYinWithToneMark(char word) throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
        return PinyinHelper.toHanyuPinyinStringArray(word, format);
    }

    public static String getPinYinByName(String name) throws BadHanyuPinyinOutputFormatCombination {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            sb.append(getPinYinWithToneMark(name.charAt(i))[0]);
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

}
