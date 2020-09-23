package week02_02_MountMarathon_16533;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		while (n-- > 0) {
			st.push(sc.nextInt());
		}
		Stack<Integer> st2 = new Stack<>();
		while (!st.isEmpty()) {
			int p = st.pop();
			if (!st2.isEmpty()) {
				int q = st2.pop();
				if (p < q) {
					st2.push(q);
				}
			}
			st2.push(p);
		}
		System.out.println(st2.size());
	}
}