package ru.ematveev.square;

public class Square{
	public int a;
	public int b;
	public int c;

	public Square(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double calculate(int x){
		return a * x * x + b * x + c;
	}

	public void show(int start, int finish, int step){
			for(int i = 0; i <= finish; i = i + step){
				System.out.println(calculate(start));
				start = start + step;
		}
	}
}

		