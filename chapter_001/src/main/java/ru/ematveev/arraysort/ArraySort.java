package ru.ematveev.arraysort;

public class ArraySort{

	public int [] arraySort(int[] array){
		for(int i = 0; i < array.length; i++){
			int min = array[i];
			int index = i;

			for(int j = i+1; j < array.length; j++){
				if(array[j] < min){
					min = array[j];
					index = j;
				}
			}
			if(i != index){
				int tmp = array[i];
				array[i] = array[index];
				array[index] = tmp;
			}

		}

		return array;

	}

}