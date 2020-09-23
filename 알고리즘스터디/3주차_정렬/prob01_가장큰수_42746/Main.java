package prob01_가장큰수_42746;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] numbers = { 3,30,34,5,9};
		sort(numbers);
	}

	static void sort(int[] numbers) {
		info[] arr = new info[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			arr[i] = new info(numbers[i]+"");
		}
		Arrays.sort(arr);
		if(arr[0].num.equals("0")) {
			System.out.println("0");
			return;
		}
		for (int i = 0; i < numbers.length ; i++) {
			System.out.print(arr[i].num);
		}
	}
}

class info implements Comparable<info> {
	String num;

	info(String num) {
		this.num = num;
	}
	public int compareTo(info o) { //o 기존에 있는 값
//			System.out.println("o.num is "+o.num+" num is "+num);
//			System.out.println(Integer.parseInt(num+o.num)-Integer.parseInt(o.num+num));
			return Integer.parseInt(o.num+num)-Integer.parseInt(num+o.num);
			
	}

}
