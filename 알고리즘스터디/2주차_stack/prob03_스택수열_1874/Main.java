package prob03_스택수열_1874;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int idx = 0;
		int num = 1;
		
		Stack<Integer> st = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			if (idx == n)
				break;
			if (num == n + 1) {
				break;
			}
			st.push(num);
			sb.append("+" + "\n");
			while (!st.isEmpty()) {
				if (st.peek() == arr[idx]) {
					st.pop();
					sb.append("-" + "\n");
					idx++;
				} else {
					break;
				}
			}
			num++;
		}
		if (!st.isEmpty()) {
			System.out.println("NO");
			return;
		}
		System.out.println(sb.toString());
	}
}
