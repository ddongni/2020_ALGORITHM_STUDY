package prob01_에디터_1406;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Deque<String> left = new LinkedList<>();
		Deque<String> right = new LinkedList<>();

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		for (int i = 0; i < str.length(); i++) {
			left.addLast(str.charAt(i) + "");
		}

		int m = sc.nextInt();
		while (m-- > 0) {
			String a = sc.next();
			switch (a) {

			case "L": // 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
				if (!left.isEmpty()) {
					right.addFirst(left.pollLast());
				}
				break;

			case "D": // 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
				if (!right.isEmpty()) {
					left.addLast(right.pollFirst());
				}
				break;

			case "B": // 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
						// 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
				if (!left.isEmpty()) {
					left.pollLast();
				}
				break;

			case "P": // $라는 문자를 커서 왼쪽에 추가함
				String b = sc.next();
				left.addLast(b);
				break;

			default:
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!left.isEmpty()) {
			sb.append(left.pollFirst());
		}
		while (!right.isEmpty()) {
			sb.append(right.pollFirst());
		}
		System.out.println(sb.toString());
	}
}
