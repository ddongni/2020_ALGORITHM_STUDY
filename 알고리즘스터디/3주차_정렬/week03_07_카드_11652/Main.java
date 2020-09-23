package week03_07_카드_11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Long, Integer> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			Long key = Long.parseLong(br.readLine());
			m.put(key, m.getOrDefault(key, 0) + 1);
		}
		info[] arr = new info[m.size()];
		int idx = 0;
		for(long key : m.keySet()) {
			arr[idx] = new info(key,m.get(key));
			idx++;
		}
		Arrays.sort(arr);
		System.out.println(arr[0].num);

	}
}

class info implements Comparable<info> {
	long num;
	int count;

	info(long num, int count) {
		this.num = num;
		this.count = count;
	}

	public int compareTo(info o) {
		if (o.count == count) {
			if(num<o.num) {
				return -1;
			}else if(num==o.num){
				return 0;
			}else {
				return 1;
			}
		} else {
			return o.count - count;
		}
	}
}
