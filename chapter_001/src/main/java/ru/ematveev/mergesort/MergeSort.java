package ru.ematveev.mergesort;

public class MergeSort{

	public int[] mergeSort(int[] a, int[] b){

		int[] c = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		int k = 0;

		while(i < a.length && j < b.length){
			if (a[i] < b[j]){
				c[k++] = a[i++];
			}

			else {
				c[k++] = b[j++];
			}
		}
		for(;i < a.length;){
			c[k++] = a[i++];
		}
		for(;j < b.length;){
			c[k++] = b[j++];
		}
		return c;
	}
}



