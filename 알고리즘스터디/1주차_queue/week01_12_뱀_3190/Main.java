package week01_12_뱀_3190;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] map = new int[n][n];
		for (int i = 0; i < k; i++) {
			map[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
		}
		int l = sc.nextInt();
		String[] dir = new String[10001];
		Queue<Integer> changed = new LinkedList<>();
		for (int i = 0; i < l; i++) {
			int x = sc.nextInt();
			String c = sc.next();
			changed.add(x);
			dir[x] = c;
		}
		Deque<int[]> snack = new LinkedList<>();
		snack.addLast(new int[]{ 0, 0 });
		map[0][0] = 9;
		int d = 3; // 초기 방향
		int time = 1;
		while (true) {
			int[] sn = snack.peekFirst();
			int nx = sn[0] + dr[d];
			int ny = sn[1] + dc[d];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == 9) {
				break;
			}
			if (map[nx][ny] == 0) {
				int[] tail = snack.pollLast();
				map[tail[0]][tail[1]] = 0;
			}
			snack.addFirst(new int[] { nx, ny });
			map[nx][ny] = 9;
			if (!changed.isEmpty() && time == changed.peek()) {
				d = changeDir(dir[changed.poll()], d);
			}
			time++;
		}
		System.out.println(time);
	}

	static int changeDir(String c, int dir) {
		int[] d = { 3, 2, 0, 1 }, l = { 2, 3, 1, 0 };
		return c.equals("D")?d[dir]:l[dir];
	}
}
