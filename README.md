# INFO6205 Final Project

## Requirements
+ Sort Chinese names by MSD and LSD radix sort, Merge sort, Tim sort.
+ Unit test for all sort methods.
+ Benchmark all sort methods to sort 250k, 500k, 1 million, 2 million, 4 million Chinese names.
+ Husky sort and related works are linked to another [repo](https://github.com/zxhdaze/HuskySort).

## Report and Paper
+ [Report](./6205%20Fall%20project%20report.pdf)
+ [Paper](./6205%20Fall%20project%20paper.pdf)

## File Description
Under `./main/...` directory:
|File|Description|
|----|-----------|
|[FileUtil.java](./src/main/java/edu/neu/coe/info6205/finalproject/FileUtil.java)|read files|
|[PinyinUtil.java](./src/main/java/edu/neu/coe/info6205/finalproject/PinyinUtil.java)|convert Chinese to Pinyin|
|[MSDSort.java](./src/main/java/edu/neu/coe/info6205/finalproject/MSDSort.java)|MSD radix sort|
|[LSDSort.java](./src/main/java/edu/neu/coe/info6205/finalproject/LSDSort.java)|LSD radix sort|
|[QuickSortDualPivot.java](./src/main/java/edu/neu/coe/info6205/finalproject/QuickSortDualPivot.java)|Dual pivot quick sort|
|[TimSort.java](./src/main/java/edu/neu/coe/info6205/finalproject/TimSort.java)|Tim sort|

Under `./test/...` directory:
|File|Description|
|----|-----------|
|[Benchmark.java](./src/test/java/edu/neu/coe/info6205/finalproject/Benchmark.java)|Benchmark 4 sorting algorithms|
|[MSDSortTest.java](./src/test/java/edu/neu/coe/info6205/finalproject/MSDSortTest.java)|MSD radix sort unit test|
|[LSDSortTest.java](./src/test/java/edu/neu/coe/info6205/finalproject/LSDSortTest.java)|LSD radix sort unit test|
|[QuickSortTest.java](./src/test/java/edu/neu/coe/info6205/finalproject/QuickSortTest.java)|Dual pivot quicksort unit test|
|[TimSortTest.java](./src/test/java/edu/neu/coe/info6205/finalproject/TimSortTest.java)|Tim sort unit test|
