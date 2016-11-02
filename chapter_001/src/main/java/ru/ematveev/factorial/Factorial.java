package ru.ematveev.factorial;

public class Factorial{
	
	public int n;

	public Factorial(int n){
		this.n = n;
	}

	public int factorial(){
				int f = 1;
					if(n > 1){
						for (int i = 1; i < n; i++){
				f = f * (i + 1);
			}
		}

return f;

	}
}