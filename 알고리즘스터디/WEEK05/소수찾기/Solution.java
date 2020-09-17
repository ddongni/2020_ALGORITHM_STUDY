package 소수찾기;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		int answer = 0;

		String numbers = "17";
		
		set = new HashSet<>();
		for (int i = 1; i <= numbers.length(); i++) {
			arr = new int[i];
			check = new boolean[numbers.length()];
			per(numbers, 0, i);
		}
		answer = set.size();
		System.out.println(answer);
	}

	static int[] arr;
	static boolean[] check;
	static Set<Integer> set;

	static void per(String numbers, int count,int r) {
		if (count == r) {
			String num = "";
			for (int i = 0; i < r; i++) {
				num += arr[i] + "";
			}
			System.out.println("num : " + num);
			int intnum = Integer.parseInt(num);
			if (intnum == 1)
				return;
			boolean check = true;
			for (int i = 2; i < intnum; i++) {
				if (intnum % i == 0) {
					check = false;
					break;
				}
			}
			if (check) {
				set.add(intnum);
			}
			return;
		}
		for (int i = 0; i < numbers.length(); i++) {
			if (check[i])
				continue;
			if(count==0 && numbers.charAt(i)=='0')
				continue;
			check[i] = true;
			arr[count] = numbers.charAt(i) - '0';
			per(numbers, count + 1, r);
			check[i] = false;
		}
	}
}
