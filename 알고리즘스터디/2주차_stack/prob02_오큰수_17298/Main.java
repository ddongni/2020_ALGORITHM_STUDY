package prob02_오큰수_17298;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<int[]> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			while (!st.isEmpty()) {
				int[] y = st.pop();
				if (x > y[0]) {
					answer[y[1]] = x;
				} else {
					st.push(y);
					break;
				}
			}
			st.push(new int[] { x, i });// x의 인덱스 까지 넣어줌
		}
		while (!st.isEmpty()) { // 스택에 남은 수들 처리
			int[] rest = st.pop();
			answer[rest[1]] = -1;
		}
		for (int x : answer) {
			sb.append(x + " ");
		}
		System.out.println(sb.toString());
	}
}
