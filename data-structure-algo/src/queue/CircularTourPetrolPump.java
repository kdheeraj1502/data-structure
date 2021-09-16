package queue;

import java.util.ArrayDeque;

public class CircularTourPetrolPump {

	public static int circularTour(int num[][]) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int next = 0;
		int prev = 0;
		int count = 0;
		int petrol = 0;
		while (queue.size() != num.length) {
			while (petrol >= 0 && queue.size() != num.length) {
				queue.add(next);
				petrol += (num[next][0] - num[next][1]);
				next = (next + 1) % num.length;
			}
			while (petrol < 0 && queue.size() > 0) {
				prev = queue.remove();
				petrol -= (num[prev][0] - num[prev][1]);
			}
			count += 1;
			if (count == num.length) {
				return -1;
			}
		}
		if (petrol >= 0) {
			return queue.remove();
		} else
			return -1;
	}

	public static void main(String[] args) {
		int tour[][] = { { 8, 6 }, { 1, 4 }, { 7, 6 } };
		System.out.println(circularTour(tour));		
	}
}
