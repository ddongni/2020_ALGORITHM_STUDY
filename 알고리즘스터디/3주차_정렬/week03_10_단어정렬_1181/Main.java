package week03_10_단어정렬_1181;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			if(set.add(str)) {
				set.add(str);
			}
		}
		info[] arr = new info[set.size()];
		int idx = 0;
		for(String s : set) {
			arr[idx] = new info(s);
			idx++;
		}
		Arrays.sort(arr);
		for (int i = 0; i < set.size(); i++) {
			System.out.println(arr[i].str);
		}
	}
}

class info implements Comparable<info> {
	String str;

	info(String str) {
		this.str = str;
	}

	public int compareTo(info o) {
		if (str.length() - o.str.length() == 0) {
			return str.compareTo(o.str);
		} else {
			return str.length() - o.str.length();
		}
	}
}
