public class NaturalMergeSorter {
   public int getSortedRunLength(int[] array, int startIndex) {
      // TODO: Type your code here
	   if (startIndex >= array.length || startIndex < 0) {
		   return 0;
	   }
	   int count = 1;
	   while (startIndex <= array.length - 2 && array[startIndex + 1] >= array[startIndex]) {
		   count++;
		   startIndex++;
	   }
	   return count;
   }

   public void naturalMergeSort(int[] array) {
      // TODO: Type your code here
	   int i = 0;
	   while (true) {
		  int firstRunLength = getSortedRunLength(array, i);
		  if (firstRunLength == array.length) {
			 return; 
		  }
		  if (i + firstRunLength == array.length) {
			 i = 0; 
		  }
		  else {
			int secondRunLength = getSortedRunLength(array, i + firstRunLength);
			merge(array, i, i + firstRunLength -1, i + firstRunLength + secondRunLength -1);
			if (i + firstRunLength + secondRunLength == array.length) {
				i = 0;
			}
			else {
				i = i + firstRunLength + secondRunLength;
			}
		  }
	   }
   }
   
   public void merge(int[] numbers, int leftFirst, int leftLast,
      int rightLast) {
      int mergedSize = rightLast - leftFirst + 1;
      int[] mergedNumbers = new int[mergedSize];
      int mergePos = 0;
      int leftPos = leftFirst;
      int rightPos = leftLast + 1;
      
      // Add smallest element from left or right partition to merged numbers
      while (leftPos <= leftLast && rightPos <= rightLast) {
         if (numbers[leftPos] <= numbers[rightPos]) {
            mergedNumbers[mergePos] = numbers[leftPos];
            leftPos++;
         }
         else {
            mergedNumbers[mergePos] = numbers[rightPos];
            rightPos++;
         }
         mergePos++;
      }
      
      // If left partition isn't empty, add remaining elements to mergedNumbers
      while (leftPos <= leftLast) {
         mergedNumbers[mergePos] = numbers[leftPos];
         leftPos++;
         mergePos++;
      }
      
      // If right partition isn't empty, add remaining elements to mergedNumbers
      while (rightPos <= rightLast) {
         mergedNumbers[mergePos] = numbers[rightPos];
         rightPos++;
         mergePos++;
      }
      
      // Copy merged numbers back to numbers
      for (mergePos = 0; mergePos < mergedSize; mergePos++) {
         numbers[leftFirst + mergePos] = mergedNumbers[mergePos];
      }
      
      // Free temporary array
      mergedNumbers = null;
   }
}
