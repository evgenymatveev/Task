package ru.ematveev.point;

public class MaxValue{

	public double ab;
	public double bc;
	public double ca;

	public MaxValue(double ab, double bc, double ca){

		this.ab = ab;
		this.bc = bc;
		this.ca = ca;
	}

	public double max(){

		double max = ab;

		if(bc > max && bc > ca)

			max = bc;

		else max = ca;

		return max;

	}

}