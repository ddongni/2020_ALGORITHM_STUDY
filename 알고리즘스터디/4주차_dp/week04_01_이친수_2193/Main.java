package week04_01_이친수_2193;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/**
		 * 1 -> 1 -> 1개 
		 * 2 -> 10 -> 1개
		 * 3 -> 100, 101 -> 2개
		 * 4 -> 1000,1010,1001 ->3개
		 * 5 -> 10000, 10100, 10010, 10001, 10101 -> 5개
		 * 6 -> 100000, 101000, 100100, 100010,
		 * 101010, 100001, 101001, 100101 -> 8개
		 */
		int n = sc.nextInt();
		long[] arr = new long[n];
		if(n<=2) {
			System.out.println(1);
			return;
		}
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2;i<n;i++) {
			arr[i] = arr[i-2] + arr[i-1];
		}
		System.out.println(arr[n-1]);
	}
}
