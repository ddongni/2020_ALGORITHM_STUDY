package week06_03_서울지하철2호선_16947;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int[][] arr;
	static int[] answer;
	static int n;
	static Set<Integer> save;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n]; // 연결된 지하철 저장
		answer = new int[n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			arr[x][y] = arr[y][x] = 1;
		}
		save = new HashSet<>();
		for (int i = 0; i < n; i++) {
			Set<Integer> set = new HashSet<>();
			find_circle(i, i, set);
			if(save.size()!=0)
				break;
		}
		System.out.println("==========>save");
		for (int x : save) {
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("===============");

		for (int i = 0; i < n; i++) {
			if (save.contains(i)) {
				continue;
			}
			dfs(i, i, 0);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	static void find_circle(int first, int start,Set<Integer> set) {
		set.add(start);
		for (int i = 0; i < n; i++) {
			if (i == start || arr[start][i] == 0)
				continue; // 자기자신 제외
			System.out.println(start+" "+i);
			if (set.contains(i)) {
				if (set.size() > 2 && first == i) {
					for (int x : set) {
						save.add(x);
					}
					System.out.println("yes end!!");
					return;
				}
				System.out.println("false");
				continue;
			}
			find_circle(first, i, set);
		}

	}

	static void dfs(int first, int start, int count) {
		if (count > n)
			return;
		for (int i = 0; i < n; i++) {
			if (i == start)
				continue; // 자기자신 제외
			if (arr[start][i] == 1) {
				if (save.contains(i)) {
					answer[first] = count + 1; // 순환선과 거리 입력
					return;
				}
				dfs(first, i, count + 1);
			}
		}
	}
}
