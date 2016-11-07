package ru.ematveev.arraydublicate;

public class ArrayDublicate{

	public String [] arrayDublicate(String [] array){

			int x = array.length;    
			
			for(int i = 0; i < x; i++){
					
				for(int j = 1; j < x; j++){
					if(array[i] != null){	
							
						if(array[i]==array[j+i]){
							array[j+1] = null;
							}				 				

						}
					
					}

							x--;
				}
					return array;
	}
}





