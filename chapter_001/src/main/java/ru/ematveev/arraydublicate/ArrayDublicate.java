package ru.ematveev.arraydublicate;

public class ArrayDublicate{

	public String [] arrayDublicate(String [] array){


			int x = array.length;    
			
			for(int i = 0; i < x; i++){
					
				for(int j = 1; j < x; j++){
					
					if(array[i] == null) break;	
							
						if(array[i].equals(array[j+i])){
							array[i] = null;
							}				 				
					
					}

							x--;
				}
					return array;
	}
}





