package week03_08_버블소트_1377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		info[] inf = new info[n];
		for (int i = 0; i < n; i++) {
			inf[i] = new info(Integer.parseInt(br.readLine()), i+1);
		}
		Arrays.sort(inf);
		int count = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			count=Math.max(count, inf[i].idx-i);
		}
		System.out.println(count);
	}
}

class info implements Comparable<info> {
	int num, idx;

	info(int num, int idx) {
		this.num = num;
		this.idx = idx;
	}

	public int compareTo(info o) {
		if (num - o.num == 0) {
			return idx - o.idx;
		} else {
			return num - o.num;
		}
	}
}
