package week02_05_압축_1662;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Stack<String> st;
	static StringBuilder sb = new StringBuilder();
	static int index = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		st = new Stack<>();
		String str = sc.nextLine();

		System.out.println(dfs(str, 1).pop().length());
	}

	static Stack<String> dfs(String str, int k) {
		Stack<String> stack = new Stack<>();
		while (true) {
			if (index == str.length()) {
				break;
			}
			String c = str.charAt(index) + "";
			if (c.equals("(")) {
				StringBuilder sb = new StringBuilder();
				index++;
				Stack<String> stack1 = dfs(str, Integer.parseInt(stack.pop()));
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				while (!stack1.isEmpty()) {
					sb.append(stack1.pop());
				}
				stack.push(sb.toString());

			} else if (c.equals(")")) {
				StringBuilder sb = new StringBuilder();
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				while (k-- > 0) {
					stack.push(sb.toString());
				}
				return stack;
			} else {
				stack.push(c);
			}
			index++;
		}
		return stack;
	}
}
