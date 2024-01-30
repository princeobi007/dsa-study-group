package com.search;

import static java.lang.Math.min;

public class FibMonaccianSearch {

    // driver code
    public static void main(String[] args)
    {
        int arr[] = { 10, 22, 35, 40, 45, 50,
                80, 82, 85, 90, 100,235};
        int arrayLength = 12;
        int target = 235;
        int index = fibMonaccianSearch(arr, target, arrayLength);
        if(index>=0)
            System.out.print("Found at index: "
                    +index);
        else
            System.out.print(target+" isn't present in the array");
    }

    private static int fibMonaccianSearch(int[] arr, int target, int arrayLength) {
        /* Initialize fibonacci numbers */
        int fibMMm2 = 0; // (m-2)'th Fibonacci No.
        int fibMMm1 = 1; // (m-1)'th Fibonacci No.
        int fibM = fibMMm2 + fibMMm1; // m'th Fibonac



        //calculate the fibonacci numbers that fall within the array length's range
        while (fibM < arrayLength){
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        // Marks the eliminated range from front
        int offset = -1;

        /* while there are elements to be inspected.
        Note that we compare arr[fibMm2] with x.
        When fibM becomes 1, fibMm2 becomes 0 */
        while (fibM > 1) {
            // Check if fibMm2 is a valid location
            int i = min(offset + fibMMm2, arrayLength - 1);

            /* If x is greater than the value at
            index fibMm2, cut the subarray array
            from offset to i */
            if (arr[i] < target) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            }

            /* If x is less than the value at index
            fibMm2, cut the subarray after i+1 */
            else if (arr[i] > target) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            }

            /* element found. return index */
            else
                return i;
        }

        /* comparing the last element with x */
        if (fibMMm1 == 1 && arr[arrayLength-1] == target)
            return arrayLength-1;

        /*element not found. return -1 */
        return -1;


    }
}
