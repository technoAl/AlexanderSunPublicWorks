import java.util.*;
import java.io.*;
public class G6Testing {
	public static void main(String[] args) {
		boolean[] GoodNumbers = findGoodNumbers(1000000);
		int lessThenHundred = 0;
		int lessThenThousand = 0;
		int lessThenTenThousand = 0;
		int lessThenHundredThousand = 0;
		int lessThenMillion = 0;
		for(int i = 0; i < GoodNumbers.length; i++) {
			System.out.println(i + " " + GoodNumbers[i]);
			if(GoodNumbers[i] && i < 100) {
				lessThenHundred++;
			}else if(GoodNumbers[i] && i < 1000){
				lessThenThousand++;
			}else if(GoodNumbers[i] && i < 10000){
				lessThenTenThousand++;
			}else if(GoodNumbers[i] && i < 100000){
				lessThenHundredThousand++;
			}else if(GoodNumbers[i] && i < 1000000){
				lessThenMillion++;
			}
		}
		
		for(int i =1; i < GoodNumbers.length;i++) {
			if(GoodNumbers[i] && GoodNumbers[i-1]) {
				System.out.println("Pair Located" + " " + (i-1) + " " + i);
			}
		}
		System.out.println("frequencies");
		System.out.println(lessThenHundred);
		System.out.println(lessThenThousand);
		System.out.println(lessThenTenThousand);
		System.out.println(lessThenHundredThousand);
		System.out.println(lessThenMillion);
	}
	
	static boolean[] findGoodNumbers(int max) {
		boolean[] areGoodNumbers = new boolean[max];
		boolean prev = false;
		for(int i = 1; i < max; i++) {
			if(isGood(i)) {
				areGoodNumbers[i] = true;
			}
		}
		return areGoodNumbers;
	}
	
	static boolean isGood(int num) {
		Map<Integer, Integer> factors = primeFactors(num);
		boolean isGood = true;
		int factorCount = 0;
		for(int factor:factors.keySet()) {
			if(factors.get(factor) < 2) {
				isGood = false;
			}
			factorCount += factors.get(factor);
		}
		return isGood & factorCount >= 4;
	}


	static HashMap<Integer, Integer> primeFactors(int n) { 
		HashMap<Integer, Integer> factors = new HashMap<>();
		// Print the number of 2s that divide n 
		int count = 0;
		while (n%2==0) 
		{ 
			count++;
			n /= 2; 
		} 
		if(count > 0) factors.put(2, count);

		// n must be odd at this point.  So we can 
		// skip one element (Note i = i +2) 
		for (int i = 3; i <= Math.sqrt(n); i+= 2) 
		{ 
			// While i divides n, print i and divide n 
			int index = 0;
			while (n%i == 0) 
			{ 
				index++;
				n /= i; 
			} 
			if(index > 0) factors.put(i, index);
		} 

		// This condition is to handle the case when 
		// n is a prime number greater than 2 
		if (n > 2) 
			factors.put(n,1); 
		return factors;
	} 
	
}
