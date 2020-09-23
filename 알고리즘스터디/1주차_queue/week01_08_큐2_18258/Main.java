package week01_08_큐2_18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			String str = br.readLine();
			if (str.startsWith("push")) {
				String[] sp = str.split(" ");
				q.add(Integer.parseInt(sp[1]));
			} else if (str.equals("pop")) {
				sb.append((q.isEmpty() ? -1 : q.pollFirst())+"\n");
			} else if (str.equals("size")) {
				sb.append(q.size()+"\n");
			} else if (str.equals("empty")) {
				sb.append((q.isEmpty() ? 1 : 0)+"\n");
			} else if (str.equals("front")) {
				sb.append((q.isEmpty() ? -1 : q.peekFirst())+"\n");
			} else if (str.equals("back")) {
				sb.append((q.isEmpty()?-1:q.peekLast())+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}
