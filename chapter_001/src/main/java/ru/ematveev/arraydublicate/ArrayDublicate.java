package ru.ematveev.arraydublicate;

public class ArrayDublicate{

	public String [] arrayDublicate(String [] array){

		int x = array.length;
		int p = array.length;
		int a = 0;

		for(int i = 0; i < x; i++){

			for(int j = 1; j < x; j++){

				if(array[i] == null) break;

				if(array[i].equals(array[j+i])){
					array[i] = null;
				}
			}
			x--;
		}
		for(int k = 0; k < p; k++){
			if(array[k] != null){
				array[a] = array[k];
				array[k] = null;
				a++;
			}
		}

		return array;
	}
}

	

							