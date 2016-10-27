package ru.ematveev.point;

public class MaxValuePoligon{
				

	public double maxPoligon(double ... nums){

				double max = nums[0];

				for(int i = 1; i < nums.length; i++){

				if(nums[i] > max){

					max = nums[i];

				}

			}
 
		return max;

	}

}