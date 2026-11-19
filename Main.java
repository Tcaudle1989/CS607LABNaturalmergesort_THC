import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
   public static void main(String[] args) {
      // Test case array: A completely sorted array
      int[] arr1 = { 15, 23, 23, 23, 31, 64, 77, 87, 88, 91 };
      
      // Test case array: Sorted run of 3 followed by sorted run of 6
      int[] arr2 = { 64, 88, 91, 12, 21, 34, 43, 56, 65 };
      
      // Test case array: 5 elements in descending order, so 5 runs of length 1
      int[] arr3 = { -10, -20, -30, -40, -50 };
      
      // Test case array: 8 equal elements, so 1 run of 8
      int[] arr4 = { -99, -99, -99, -99, -99, -99, -99, -99 };
      
      // Test cases:
      RunLengthTestCase[] testCases = {
         // First test case uses an out-of-bounds starting index. Remaining test
         // cases do not.
         new RunLengthTestCase(arr1, arr1.length, 0),
         new RunLengthTestCase(arr1, 0, arr1.length),
         new RunLengthTestCase(arr1, 3, arr1.length - 3),
         new RunLengthTestCase(arr2, 0, 3),
         new RunLengthTestCase(arr2, 2, 1),
         new RunLengthTestCase(arr2, 3, 6),
         new RunLengthTestCase(arr3, 0, 1),
         new RunLengthTestCase(arr3, 3, 1),
         new RunLengthTestCase(arr4, 0, arr4.length),
         new RunLengthTestCase(arr4, 4, arr4.length - 4),
         new RunLengthTestCase(arr4, 5, arr4.length - 5)
      };
      
      // Execute each test case
      PrintWriter testFeedback = new PrintWriter(System.out);
      int testCasesLength = testCases.length;
      for (int i = 0; i < testCasesLength; i++) {
         RunLengthTestCase testCase = testCases[i];
         
         // Execute the test case, using System.out to write messages
         testCase.execute(testFeedback);
      }
      testFeedback.flush();
      
      // Test case array for sorting
      int[] arr5 = { 92, 71, 18, 26, 54, 73, 89, 10, 39, 99, 64, 22 };
      int[] arr5Copy = new int[arr5.length];
      for (int i = 0; i < arr5.length; i++) {
         arr5Copy[i] = arr5[i];
      }

      NaturalMergeSorter sorter = new NaturalMergeSorter();
      sorter.naturalMergeSort(arr5Copy);
      System.out.println();
      System.out.print(isSorted(arr5Copy) ? "PASS" : "FAIL");
      System.out.print(": naturalMergeSort()");
      System.out.println();
      System.out.print("   Array before calling naturalMergeSort(): " +
         Arrays.toString(arr5));
      System.out.println();
      System.out.print("   Array after calling naturalMergeSort():  " +
         Arrays.toString(arr5Copy));
      System.out.println();
   }
   
   public static boolean isSorted(int[] arr) {
      for (int i = 1; i < arr.length; i++) {
         if (arr[i] < arr[i - 1]) {
            return false;
         }
      }
      return true;
   }
}
