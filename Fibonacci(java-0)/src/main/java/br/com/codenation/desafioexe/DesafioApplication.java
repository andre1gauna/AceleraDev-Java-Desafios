package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci()
	{
		ArrayList<Integer> fibonacci;
		fibonacci = new ArrayList<>();
		int i = 1;
		fibonacci.add(0);
		fibonacci.add(1);

		while (fibonacci.get(i)< 350)
		{
			i++;
			fibonacci.add(fibonacci.get(i-1) + fibonacci.get(i-2));
		}

		return fibonacci;
	}

	public static Boolean isFibonacci(Integer a)
	{
		if (fibonacci().contains(a))
		{
			return true;
		}

		else return false;
	}

}