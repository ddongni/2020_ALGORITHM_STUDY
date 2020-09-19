package week04_03_피보나치수5;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibo(n));
	}
	static int fibo(int n) {
		if(n<=1) {
			return n;
		}else {
			return fibo(n-2)+fibo(n-1);
		}
	}
}
