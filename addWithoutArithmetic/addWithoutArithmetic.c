#include<stdio.h>
/*
 * Get the bit value (0/1) present at specified 
 * bit position.
*/
int getBit(int num, int pos)
{
	return (num>>pos)&1;
}

/*
 * Set/ Reset the bit at specified index position
 */
int setBit(int num, int pos, int set)
{
	int b = (1<<pos);
	if(set){
		num |= b;
	} else {
		num &= (~b);
	}
	return num;
}

int addWithoutArithmetic(int a, int b)
{
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
			sum = setBit(sum, index, 1);
		
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

int main()
{
	int a = -105, b = -19;
	printf("Sum of %d + %d is: %d", a, b, addWithoutArithmetic(a,b));
}