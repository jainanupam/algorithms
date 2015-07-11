public class BinarySearch {

	public static int binarySearch(int[] inputArr, int val){
		
		// initialize the low and high indexes
		int low = 0, high = inputArr.length - 1;
		
		// get the mid index of the input array.
		int mid = high >> 1;
		
		// default index if the element 'val' is not found
		int result = -1;
		
		while(low <= high){
			// check if the value is present at the mid index
			if(val == inputArr[mid]){
				result = mid;
				break;
			}
			
			// value not found on current mid index
			// if val is less than that at the mid then,
			// it can be present only in the lower half
			// of the array.
			if(val < inputArr[mid]){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
			
			// this could as well be implemented as (low + high)/2
			// but we chose this method, instead... for a reason.
			// you may wanna google java binary search implementation glitch.
			mid = low + ((high - low) >> 1);
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] testArr = {2, 3, 5, 10, 12};
		System.out.println(binarySearch(testArr, 6));
	}

}
