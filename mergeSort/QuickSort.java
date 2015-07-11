package com.coddicted.sort;

public class QuickSort {

	public static void main(String[] args) {

		int[] arr = {2, 4, 3, 6, 1, 19, 10};
		//arr = new int[]{6, 5, 4, 3, 2, 1, 1};
		quickSort(arr, 0, arr.length-1);
		for(int a : arr)
			System.out.print(a + " ");
	}

	public static void quickSort(int[] arr, int low, int high) {
		if(low < high){
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int x = arr[high];	// pivot element
		int p = low - 1;	// index of last smaller element
		int temp;
		
		for(int i = low; i < high; i++){
			if(arr[i] <= x){
				p++;
				temp = arr[p];
				arr[p] = arr[i];
				arr[i] = temp;
			}
		}
		
		p++;
		arr[high] = arr[p];
		arr[p] = x;
		
		return p;
	}

}
