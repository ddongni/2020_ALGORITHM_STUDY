package week02_06_제로_10773;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			if (x == 0) {
				if (!st.isEmpty()) {
					st.pop();
				}
			} else {
				st.push(x);
			}
		}
		int answer = 0;
		while(!st.isEmpty()) {
			answer+=st.pop();
		}
		System.out.println(answer);
	}
}
