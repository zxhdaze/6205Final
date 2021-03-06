package edu.neu.coe.info6205.finalproject;
import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;
public class TimSort {
    static int MIN_MERGE = 32;
    private static Collator collator = Collator.getInstance(Locale.CHINA);

    public static int minRunLength(int n)
    {
        assert n >= 0;

        // Becomes 1 if any 1 bits are shifted off
        int r = 0;
        while (n >= MIN_MERGE)
        {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    // This function sorts array from left index to
    // to right index which is of size atmost RUN
    public static void insertionSort(String[] arr, int left,
                                     int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            String temp = arr[i];
            int j = i - 1;
            //while (j >= left && arr[j].compareTo(temp)>0)
            while (j >= left && collator.compare(arr[j],temp)>0)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // Merge function merges the sorted runs
    public static void merge(String[] arr, int l,
                             int m, int r)
    {
        // Original array is broken in two parts
        // left and right array
        int len1 = m - l + 1, len2 = r - m;
        String[] left = new String[len1];
        String[] right = new String[len2];
        for (int x = 0; x < len1; x++)
        {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++)
        {
            right[x] = arr[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        // After comparing, we merge those two array
        // in larger sub array
        while (i < len1 && j < len2)
        {
            //if (left[i].compareTo(right[j])<=0)
            if (collator.compare(left[i],right[j]) <= 0)
            {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        // of left, if any
        while (i < len1)
        {
            arr[k] = left[i];
            k++;
            i++;
        }

        // Copy remaining element
        // of right, if any
        while (j < len2)
        {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    // Iterative Timsort function to sort the
    // array[0...n-1] (similar to merge sort)
    public static void timSort(String[] arr, int n)
    {
        int minRun = minRunLength(MIN_MERGE);

        // Sort individual subarrays of size RUN
        for (int i = 0; i < n; i += minRun)
        {
            insertionSort(arr, i,
                    Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        // Start merging from size
        // RUN (or 32). It will
        // merge to form size 64,
        // then 128, 256 and so on
        // ....
        for (int size = minRun; size < n; size = 2 * size)
        {

            // Pick starting point
            // of left sub array. We
            // are going to merge
            // arr[left..left+size-1]
            // and arr[left+size, left+2*size-1]
            // After every merge, we
            // increase left by 2*size
            for (int left = 0; left < n;
                 left += 2 * size)
            {

                // Find ending point of left sub array
                // mid+1 is starting point of right sub
                // array
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1),
                        (n - 1));

                // Merge sub array arr[left.....mid] &
                // arr[mid+1....right]
                if(mid < right)
                    merge(arr, left, mid, right);
            }
        }
    }

    // Utility function to print the Array
    public static void printArray(String[] arr, int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    // Driver code
    public static void main(String[] args)
    {
        //String[] zhongwen = {"??????", "??????", "??????", "??????"};
        String[] zhongwen = FileUtil.getAllNamesToArray();
        // zhongwen = Arrays.copyOfRange(zhongwen,0,100);

//        String[] pinyin = new String[3];
//        for (int i = 0; i < zhongwen.length; i++) {
//            try {
//                pinyin[i] = PinyinUtil.getPinYinByName(zhongwen[i]);
//            } catch (Exception e) {
//                System.out.println("error");
//            }
//        }

        // for (String s : zhongwen) {
        //     System.out.println(s);
        // }
        System.out.println("-------------------------------------");

        timSort(zhongwen, zhongwen.length);

        // for (String s : zhongwen) {
        //     System.out.println(s);
        // }
        for (int i = 0; i < 100; i++) System.out.println(zhongwen[i]);
        System.out.println("-------------------------------------");
    }
}
