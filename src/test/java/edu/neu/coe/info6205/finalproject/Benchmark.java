package edu.neu.coe.info6205.finalproject;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Benchmark {

    private static double toMS(long nano) {
        return TimeUnit.MILLISECONDS.convert(nano, TimeUnit.NANOSECONDS);
    }

    final static String stdPreOutput = "Benchmark - Begin run: %s sort %d Chinese names with %d runs\n";

    final static String stdPostOutput = "Benchmark - Average time is %f ms\n";

    private static void MSDSortBenchmark(String[] cnNames) {
        System.out.printf(stdPreOutput, "MSDSort", cnNames.length, sortCnt);
        ArrayList<Long> time = new ArrayList<Long>();
        System.nanoTime();

        for (int i = 0; i < sortCnt; i++) {
            String[] arr = new String[cnNames.length];
            System.arraycopy(cnNames, 0, arr, 0, cnNames.length);

            Long start = System.nanoTime();
            MSDSort.sort(arr);

            Long end = System.nanoTime();
            Long t = (end - start);
            time.add(t);
        }

        long sum = 0;
        for (Long t : time) {
            sum += t;
        }

        long avg = sum / sortCnt;
        System.out.printf(stdPostOutput, toMS(avg));
    }

    private static void doMSDSortBenchmark(String[] cnNames) {
        String[] data1 = new String[250000];
        String[] data2 = new String[500000];
        String[] data3 = new String[1000000];
        String[] data4 = new String[2000000];
        String[] data5 = new String[4000000];
        System.arraycopy(cnNames, 0, data1, 0, 250000);
        MSDSortBenchmark(data1);
        System.arraycopy(cnNames, 0, data2, 0, 500000);
        MSDSortBenchmark(data2);
        System.arraycopy(cnNames, 0, data3, 0, 1000000);
        MSDSortBenchmark(data3);
        // 2000000
        System.arraycopy(cnNames, 0, data4, 0, 1000000);
        System.arraycopy(cnNames, 0, data4, 1000000, 1000000);
        MSDSortBenchmark(data4);
        // 4000000
        System.arraycopy(cnNames, 0, data5, 0, 1000000);
        System.arraycopy(cnNames, 0, data5, 1000000, 1000000);
        System.arraycopy(cnNames, 0, data5, 2000000, 1000000);
        System.arraycopy(cnNames, 0, data5, 3000000, 1000000);
        MSDSortBenchmark(data5);
    }

    private static void LSDSortBenchmark(String[] cnNames) {
        System.out.printf(stdPreOutput, "LSDSort", cnNames.length, sortCnt);
        ArrayList<Long> time = new ArrayList<Long>();
        System.nanoTime();

        for (int i = 0; i < sortCnt; i++) {
            String[] arr = new String[cnNames.length];
            System.arraycopy(cnNames, 0, arr, 0, cnNames.length);

            Long start = System.nanoTime();

            LSDSort.sortChinese(arr);

            Long end = System.nanoTime();
            Long t = (end - start);
            time.add(t);
        }

        long sum = 0;
        for (Long t : time) {
            sum += t;
        }

        long avg = sum / sortCnt;
        System.out.printf(stdPostOutput, toMS(avg));
    }

    private static void doLSDSortBenchmark(String[] cnNames) {
        String[] data1 = new String[250000];
        String[] data2 = new String[500000];
        String[] data3 = new String[1000000];
        String[] data4 = new String[2000000];
        String[] data5 = new String[4000000];
        System.arraycopy(cnNames, 0, data1, 0, 250000);
        LSDSortBenchmark(data1);
        System.arraycopy(cnNames, 0, data2, 0, 500000);
        LSDSortBenchmark(data2);
        System.arraycopy(cnNames, 0, data3, 0, 1000000);
        LSDSortBenchmark(data3);
        // 2000000
        System.arraycopy(cnNames, 0, data4, 0, 1000000);
        System.arraycopy(cnNames, 0, data4, 1000000, 1000000);
        LSDSortBenchmark(data4);
        // 4000000
        System.arraycopy(cnNames, 0, data5, 0, 1000000);
        System.arraycopy(cnNames, 0, data5, 1000000, 1000000);
        System.arraycopy(cnNames, 0, data5, 2000000, 1000000);
        System.arraycopy(cnNames, 0, data5, 3000000, 1000000);
        LSDSortBenchmark(data5);
    }

    private static void QuickSortBenchmark(String[] cnNames) {
        System.out.printf(stdPreOutput, "DualPivotQuickSort", cnNames.length, sortCnt);
        ArrayList<Long> time = new ArrayList<Long>();
        System.nanoTime();

        for (int i = 0; i < sortCnt; i++) {
            String[] arr = new String[cnNames.length];
            System.arraycopy(cnNames, 0, arr, 0, cnNames.length);
            Long start = System.nanoTime();

            QuickSortDualPivot.sort(arr, 0, arr.length - 1);

            Long end = System.nanoTime();
            Long t = (end - start);
            time.add(t);
        }

        long sum = 0;
        for (Long t : time) {
            sum += t;
        }

        long avg = sum / sortCnt;
        System.out.printf(stdPostOutput, toMS(avg));
    }

    private static void doQuickSortBenchmark(String[] cnNames) {
        String[] data1 = new String[250000];
        String[] data2 = new String[500000];
        String[] data3 = new String[1000000];
        String[] data4 = new String[2000000];
        String[] data5 = new String[4000000];
        System.arraycopy(cnNames, 0, data1, 0, 250000);
        QuickSortBenchmark(data1);
        System.arraycopy(cnNames, 0, data2, 0, 500000);
        QuickSortBenchmark(data2);
        System.arraycopy(cnNames, 0, data3, 0, 1000000);
        QuickSortBenchmark(data3);
        // 2000000
        System.arraycopy(cnNames, 0, data4, 0, 1000000);
        System.arraycopy(cnNames, 0, data4, 1000000, 1000000);
        QuickSortBenchmark(data4);
        // 4000000
        System.arraycopy(cnNames, 0, data5, 0, 1000000);
        System.arraycopy(cnNames, 0, data5, 1000000, 1000000);
        System.arraycopy(cnNames, 0, data5, 2000000, 1000000);
        System.arraycopy(cnNames, 0, data5, 3000000, 1000000);
        QuickSortBenchmark(data5);
    }

    private static void TimSortBenchmark(String[] cnNames) {
        System.out.printf(stdPreOutput, "TimSort", cnNames.length, sortCnt);
        ArrayList<Long> time = new ArrayList<Long>();
        System.nanoTime();

        for (int i = 0; i < sortCnt; i++) {
            String[] arr = new String[cnNames.length];
            System.arraycopy(cnNames, 0, arr, 0, cnNames.length);
            Long start = System.nanoTime();

            TimSort.timSort(arr, arr.length);

            Long end = System.nanoTime();
            Long t = (end - start);
            time.add(t);
        }

        long sum = 0;
        for (Long t : time) {
            sum += t;
        }

        long avg = sum / sortCnt;
        System.out.printf(stdPostOutput, toMS(avg));
    }

    private static void doTimSortBenchmark(String[] cnNames) {
        String[] data1 = new String[250000];
        String[] data2 = new String[500000];
        String[] data3 = new String[1000000];
        String[] data4 = new String[2000000];
        String[] data5 = new String[4000000];
        System.arraycopy(cnNames, 0, data1, 0, 250000);
        TimSortBenchmark(data1);
        System.arraycopy(cnNames, 0, data2, 0, 500000);
        TimSortBenchmark(data2);
        System.arraycopy(cnNames, 0, data3, 0, 1000000);
        TimSortBenchmark(data3);
        // 2000000
        System.arraycopy(cnNames, 0, data4, 0, 1000000);
        System.arraycopy(cnNames, 0, data4, 1000000, 1000000);
        TimSortBenchmark(data4);
        // 4000000
        System.arraycopy(cnNames, 0, data5, 0, 1000000);
        System.arraycopy(cnNames, 0, data5, 1000000, 1000000);
        System.arraycopy(cnNames, 0, data5, 2000000, 1000000);
        System.arraycopy(cnNames, 0, data5, 3000000, 1000000);
        TimSortBenchmark(data5);
    }

    private final static int sortCnt = 10;

    public static void countTime() {
        String[] cnNames = FileUtil.getAllNamesToArray();

        // MSD
        {
            doMSDSortBenchmark(cnNames);
        }

        // LSD
        {
            doLSDSortBenchmark(cnNames);
        }

        // QuickSort
        {
            doQuickSortBenchmark(cnNames);
        }

        // TimSort
        {
            doTimSortBenchmark(cnNames);
        }

        // HuskySort
        {
            // ...
        }
    }

    public static void main(String[] args) {
        countTime();
    }
}
