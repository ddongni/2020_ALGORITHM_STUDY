package week02_04_좋은단어_3986;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long answer = 0;
		for (int i = 0; i < n; i++) {
			Stack<Character> st = new Stack<>();
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if(st.isEmpty()) {
					st.push(c);
				}else {
					char top = st.peek();
					if(c!=top) {
						st.push(c);
					}else {
						st.pop();
					}
				}
			}
			if(st.isEmpty()) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}