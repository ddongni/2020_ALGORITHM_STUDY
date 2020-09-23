package prob01_01_다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> delay = new LinkedList<>();
		for (int truck : truck_weights) {
			delay.offer(truck);
		}
		Queue<info> bridge = new LinkedList<>();
		int first = delay.poll();
		bridge.offer(new info(first, 1, bridge_length - 1));
		int now_weight = first;
		while (!bridge.isEmpty()) {
			info truck = bridge.poll();
			int time = truck.time;
			System.out.println("truck : " + truck.num + " time : " + truck.time + " loc : " + truck.loc
					+ " bridge size : " + bridge.size());
			int last_truck = bridge_length - 1;
			if (truck.loc < 0) {
				now_weight -= truck.num;
			} else {
				time = truck.time+1;
				bridge.offer(new info(truck.num, time, truck.loc - 1));
			}
			last_truck -= bridge.size()-1;
			System.out.println("last_truck :"+last_truck);
			if(!delay.isEmpty()) {
				if ((now_weight + delay.peek()) <= weight) {
					now_weight += delay.peek();
					System.out.println(delay.peek());
					bridge.offer(new info(delay.poll(),time, last_truck));
					last_truck++;
				}
			}
			answer = truck.time;
		}
		return answer;
	}

	static class info {
		int num;
		int time;
		int loc;

		public info(int num, int time, int loc) {
			this.num = num;
			this.time = time;
			this.loc = loc;
		}

	}
}
