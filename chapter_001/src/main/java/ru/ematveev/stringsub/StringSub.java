package ru.ematveev.stringsub;

public class StringSub{

	public boolean contains(String origin, String sub){

		char[] o = origin.toCharArray();
		char[] s = sub.toCharArray();
		boolean count = false;

		for(int i = 0; i < o.length; i++){
			if(s[0] == o[i]){
				for(int j = 1; j < s.length; j++){
					if(s[j] == o[i+j]){
						count = true;
					}
					else {
						count = false;
					}
				}
			}

		}
		return count;
	}
} 




 