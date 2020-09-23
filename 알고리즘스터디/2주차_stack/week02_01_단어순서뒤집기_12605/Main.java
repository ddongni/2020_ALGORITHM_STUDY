package week02_01_단어순서뒤집기_12605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<String> st = new Stack<>();
		for (int i = 1; i <= n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			while(str.hasMoreTokens()) {
				st.push(str.nextToken());
			}
			sb.append("Case #"+i+": ");
			while(!st.isEmpty()) {
				sb.append(st.pop()+" ");
			}
			System.out.println(sb.toString());
		}
	}
}
