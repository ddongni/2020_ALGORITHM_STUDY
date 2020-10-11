package week08_05_트리의높이와너비_2250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] node, level;
	static int[][] tree, LR, map;
	static int level_r = Integer.MIN_VALUE;
	static PriorityQueue<int[]> FromLeapToRoot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		tree = new int[n][2];
		node = new int[n]; // 부모 찾기 위한 배열
		level = new int[n]; // 각 노드의 level 정의하기 위한 배열
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			node[num]++;
			tree[num][0] = Integer.parseInt(st.nextToken()) - 1;
			if (tree[num][0] >= 0)
				node[tree[num][0]]++;
			tree[num][1] = Integer.parseInt(st.nextToken()) - 1;
			if (tree[num][1] >= 0)
				node[tree[num][1]]++;
		}
		FromLeapToRoot = new PriorityQueue<>((int[] a, int[] b) -> {
			return b[1] - a[1];
		}); // level 높은 순으로 tree 저장
		int root = 0;
		for (int i = 0; i < n; i++) {
			if (node[i] == 1) {
				root = i;
				break;
			}
		}
		getLevel(root, 0);
		LR = new int[n][2]; // 노드들의 left, right 자식 노드 갯수 저장
		while (!FromLeapToRoot.isEmpty()) {
			int[] i = FromLeapToRoot.poll();
			int num = i[0];
			int L = 0, R = 0;
			if (tree[num][0] >= 0) { // 왼쪽 자식 노드 존재하면
				L = LR[tree[num][0]][0] + LR[tree[num][0]][1] + 1;
			}
			if (tree[num][1] >= 0) { // 오른쪽 자식 노드 존재하면
				R = LR[tree[num][1]][0] + LR[tree[num][1]][1] + 1;
			}
			LR[num][0] = L;
			LR[num][1] = R;
		}
		map = new int[level_r + 1][n];
		setMap(root, 0, LR[root][0]);
		setMap(root, 1, LR[root][0]);
		PriorityQueue<info> diff = new PriorityQueue<>();
		for (int i = 0; i < level_r + 1; i++) {
			int l = 0, r = n - 1;
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0) {
					l = j;
					break;
				}
			}
			for (int j = n - 1; j >= 0; j--) {
				if (map[i][j] != 0) {
					r = j;
					break;
				}
			}
			diff.add(new info(i + 1, r - l + 1));
		}
		System.out.println(diff.peek().lev + " " + diff.poll().dist);
	}

	static void getLevel(int num, int Lev) {
		level[num] = Lev;
		for (int x : tree[num]) {
			if (x == -2)
				continue;
			getLevel(x, Lev + 1);
		}
		level_r = Math.max(level_r, Lev);
		FromLeapToRoot.add(new int[] { num, Lev });
	}

	static void setMap(int num, int dir, int index) {
		// num : 현재 노드
		// dir : 부모 노드의 어느 방향(왼쪽 0, 오른쪽 1) 자식인지
		// index : map 배열에서 현재 노드의 열 저장
		map[level[num]][index] = num + 1;
		if (dir == 0 && tree[num][0] >= 0) {
			int left_child = tree[num][0];
			index = index - LR[left_child][1] - 1;
			setMap(left_child, 0, index);
			setMap(left_child, 1, index);
		} else if (dir == 1 && tree[num][1] >= 0) {
			int right_child = tree[num][1];
			index = index + LR[right_child][0] + 1;
			setMap(right_child, 0, index);
			setMap(right_child, 1, index);
		}
	}
}

class info implements Comparable<info> {
	int lev, dist;

	info(int lev, int dist) {
		this.lev = lev;
		this.dist = dist;
	}

	public int compareTo(info o) {
		if (o.dist - this.dist == 0) {
			return this.lev - o.lev;
		} else {
			return o.dist - this.dist;
		}
	}
}
