package week05_03_차이를최대로_10819;

import java.util.Scanner;

public class Main {
	static int answer = Integer.MIN_VALUE;
	static int[] arr, new_arr;
	static int n;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		check = new boolean[n];
		new_arr = new int[n];
		per(0);
		System.out.println(answer);
	}

	static void per(int count) {
		if (count == n) {
			int sum = 0;
			for (int i = 0; i < n - 1; i++) {
				sum += Math.abs(new_arr[i] - new_arr[i + 1]);
			}
			answer = Math.max(answer, sum);
		
			return;
		}

		for (int i = 0; i < n; i++) {
			if (check[i])
				continue;
			check[i] = true;
			new_arr[count] = arr[i];
			per(count + 1);
			check[i] = false;
		}
	}
}