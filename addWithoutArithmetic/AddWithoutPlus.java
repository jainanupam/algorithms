package com.coddicted;

/**
 * @author Coddicted
 * Class to add two integers without 
 * using any arithmetic operator
 */
public class AddWithoutPlus {
	
	/**
	 * @param num	The number from which to get the bit value
	 * @param pos	The 0 based index position of which to get the bit value
	 * @return
	 * The 0/1 bit value at the specified index position <code>pos</code> of 
	 * number <code>num</code>
	 */
	public static int getBit(int num, int pos){
		return (num>>pos)&1;
	}
	
	/**
	 * @param num
	 * @param pos
	 * @param set
	 * @return
	 * Sets/Resets the bit at index <code>pos</code> of number <code>num</code>
	 *  based on whether <br> the boolean <code>set</code> flagis set to <code>true</code>
	 *  or is reset to <code>false</code>.<br>
	 *  Finally returns the new number after set/reset operation.
	 */
	public static int setBit(int num, int pos, boolean set){
		int b = (1<<pos);
		if(set){
			num |= b;
		} else {
			num &= (~b);
		}
		return num;
	}
	
	/**
	 * @param a
	 * @param b
	 * @return
	 * Result of adding a and b.
	 */
	public static int addWithoutArithmetic(int a, int b){
		// Initialize variables.
		// Assuming initial sum to be zero.
		int sum = 0, index = 0, carry = 0;
		int bita, bitb, bit;
		while(index < 32){
			// Get the individual bits at corresponding indexes 
			// from both the numbers.
			bita = getBit(a,index);
			bitb = getBit(b,index);
			
			//	Get the bit value for current bit position in sum
			bit = carry ^ (bita ^ bitb);
			
			//	Set the bit value in sum.
			if(bit>0)
				sum = setBit(sum, index, true);
			
			//	Calculate the carry value
			//	There will be a carry if any of the two bits are 1.
			if(((bita & bitb) == 1) ||
					((carry & bita)==1) ||
					((carry & bitb)==1)){
				carry = 1;
			} else {
				carry = 0;
			}
			
			//	Move to next index.
			index++;
				
		}
		return sum;
	}

	public static void main(String[] args) {
		int a = 105, b = 19;
		
		System.out.println("sum of " + a + " + " + b + " is: " + addWithoutArithmetic(a, b));
	}

}
