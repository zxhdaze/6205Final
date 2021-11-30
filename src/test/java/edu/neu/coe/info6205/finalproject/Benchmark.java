package edu.neu.coe.info6205.finalproject;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Benchmark {

    private static double toMS(long nano) {
        return TimeUnit.MILLISECONDS.convert(nano, TimeUnit.NANOSECONDS);
    }

    public static void countTime() {
        int sortCnt = 10;

        // MSD
        {
            ArrayList<Long> time = new ArrayList<Long>();
            System.nanoTime();

            for (int i = 0; i < sortCnt; i++) {
                Long start = System.nanoTime();

                String[] cnNames = FileUtil.getAllNamesToArray();
                MSDSort.sort(cnNames);

                Long end = System.nanoTime();
                Long t = (end - start);
                time.add(t);
            }

            long sum = 0;
            for (Long t : time) {
                sum += t;
            }

            long avg = sum / sortCnt;
            System.out.println("MSD Average Time in ms: " + toMS(avg));
        }

        // LSD
        {
            ArrayList<Long> time = new ArrayList<Long>();
            System.nanoTime();

            for (int i = 0; i < sortCnt; i++) {
                Long start = System.nanoTime();

                String[] cnNames = FileUtil.getAllNamesToArray();
                LSDSort.sortChinese(cnNames);

                Long end = System.nanoTime();
                Long t = (end - start);
                time.add(t);
            }

            long sum = 0;
            for (Long t : time) {
                sum += t;
            }

            long avg = sum / sortCnt;
            System.out.println("LSD Average Time in ms: " + toMS(avg));
        }

        // QuickSort
        {
            ArrayList<Long> time = new ArrayList<Long>();
            System.nanoTime();

            for (int i = 0; i < sortCnt; i++) {
                Long start = System.nanoTime();

                String[] cnNames = FileUtil.getAllNamesToArray();
                QuickSortDualPivot.sort(cnNames, 0, cnNames.length - 1);

                Long end = System.nanoTime();
                Long t = (end - start);
                time.add(t);
            }

            long sum = 0;
            for (Long t : time) {
                sum += t;
            }

            long avg = sum / sortCnt;
            System.out.println("QSort Average Time in ms: " + toMS(avg));
        }

        // TimSort
        {
            ArrayList<Long> time = new ArrayList<Long>();
            System.nanoTime();

            for (int i = 0; i < sortCnt; i++) {
                Long start = System.nanoTime();

                String[] cnNames = FileUtil.getAllNamesToArray();
                TimSort.timSort(cnNames, cnNames.length);

                Long end = System.nanoTime();
                Long t = (end - start);
                time.add(t);
            }

            long sum = 0;
            for (Long t : time) {
                sum += t;
            }

            long avg = sum / sortCnt;
            System.out.println("TimSort Average Time in ms: " + toMS(avg));
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
