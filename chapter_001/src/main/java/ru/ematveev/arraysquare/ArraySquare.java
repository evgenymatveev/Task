package ru.ematveev.arraysquare;

public class ArraySquare{

	public int [][] arraySquare(int [][] array){
			int [][] arr2 = new int[array.length][array.length];

		for (int i = 0; i < array.length;){
			for (int j = 0; j < array.length; j++){
			 arr2[j][array.length - (i+1)] = array[i][j];
		}
			i++;	
	}
				array = arr2;
				return array;

}

}

