package com.coddicted.sort;

public class MergeSort {

	/**
	 * Recursively implementing merge sort
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void mergeSort(int[] arr, int low, int high){
		if(low < high){
			int mid = low + ((high - low) >> 1);
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}
	
	/**
	 * function to merge two sub-arrays back to the original one
	 * @param arr
	 * @param low
	 * @param mid
	 * @param high
	 */
	private static void merge(int[] arr, int low, int mid, int high) {
		
		// get the lengths of the two sub-arrays
		int len1 = mid - low + 1;
		int len2 = high - mid;
		
		// create two temporary sub-arrays
		int[] arr1 = new int[len1];
		int[] arr2 = new int[len2];
		
		// make these arrays as copy of our sub-arrays
		for(int i=0; i < len1; i++)
			arr1[i] = arr[low + i];
		
		for(int i=0; i < len2; i++)
			arr2[i] = arr[mid + i + 1];
		
		// time to merge these two sub-arrays back into arr
		int low1 = 0, low2 = 0;
		
		while(low1 < len1 && low2 < len2){
			if(arr1[low1] <= arr2[low2])
				arr[low] = arr1[low1++];
			else
				arr[low] = arr2[low2++];
			low++;
		}
		
		// now copy the remaining elements from either array
		while(low1 < len1)
			arr[low++] = arr1[low1++];
		
		while(low2 < len2)
			arr[low++] = arr2[low2++];
		
	}

	public static void main(String[] args) {
		int[] arr = {2, 4, 3, 6, 1, 19, 10};
		//arr = new int[]{6, 5, 4, 3, 2, 1, 1};
		mergeSort(arr, 0, arr.length-1);
		for(int a : arr)
			System.out.print(a + " ");
	}

}
