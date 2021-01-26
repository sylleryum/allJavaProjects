package firstLast6;

public class Main {

	public static void main(String[] args) {
		// Given an array of ints, return true if 6 appears as either the first
		// or last element in the array. The array will be length 1 or more.
		int[] num = new int[]{1,2,3,4,5,6};
		System.out.println(checkArray(num));
		
	}
	
	public static boolean checkArray (int[] nums){
		
		
		if (nums[0]==6 || nums[nums.length-1]==6){
			return true;
		}
		
		
		return false;
	}
	
	
}
