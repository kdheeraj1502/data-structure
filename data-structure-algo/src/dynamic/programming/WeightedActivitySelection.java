package dynamic.programming;

import java.util.*;

// Sort based on end time
// Add default profit in 1 D dynamic array
// Add if block in inner loop with end time of j should be smaller or eauls to i
// Calculate profit by 2 pointer i and j always keep j lower than i

public class WeightedActivitySelection {

	private Job jobs[];

	WeightedActivitySelection(Job jobs[]) {
		this.jobs = jobs;
	}

	public int maxProfit() {
		/*
		 * Arrays.sort(jobs, new Comparator<Job>() {
		 * 
		 * @Override public int compare(Job o1, Job o2) { return o1.finish - o2.finish;
		 * } });
		 */
		Arrays.sort(jobs);
		int dp[] = new int[jobs.length];
		int i = 0;
		for (Job last : jobs) {
			dp[i++] = last.profit;
		}

		i = 1;
		int j = 0;
		for (i = 1; i < dp.length; i++) {
			j = 0;
			while (j < i) {
				if (jobs[j].finish <= jobs[i].start) {
					dp[i] = Math.max(jobs[i].profit + dp[j], dp[i]);
				}
				j++;
			}
		}

		int max = 0;
		i = 0;
		while (i < dp.length) {
			if (dp[i] > max) {
				max = dp[i];
			}
			i++;
		}

		return max;
	}

	public static void main(String[] args) {
		Job jobs[] = new Job[4];

		jobs[0] = new Job(3, 10, 20);
		jobs[1] = new Job(1, 2, 50);
		jobs[2] = new Job(6, 19, 100);
		jobs[3] = new Job(2, 100, 200);

		/*
		 * jobs[0] = new Job(6, 19, 2); jobs[1] = new Job(15, 18, 9); jobs[2] = new
		 * Job(7, 19, 1); jobs[3] = new Job(11, 16, 19); jobs[4] = new Job(1, 10, 5);
		 * jobs[5] = new Job(3, 8, 7); jobs[6] = new Job(16, 19, 3); jobs[7] = new
		 * Job(2, 8, 19);
		 */

		WeightedActivitySelection was = new WeightedActivitySelection(jobs);
		System.out.println(was.jobScheduling_LEET());
	}

	public int jobScheduling(int[] start, int[] end, int[] profit) {
		ArrayList<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < start.length; ++i) {
			list.add(new Pair(start[i], end[i], profit[i]));
		}

		Collections.sort(list);
		int[] arr = new int[list.get(list.size() - 1).end + 1];
		arr[0] = 0;
		int k = 0, i = 1;
		while (k < list.size()) {
			if (list.get(k).end == i) {
				arr[i] = Math.max(arr[i], Math.max(arr[i - 1], arr[list.get(k).start] + list.get(k).profit));
				++k;
			} else {
				arr[i] = Math.max(arr[i - 1], arr[i]);
				++i;
			}
		}
		return arr[arr.length - 1];
	}

	class Job1 implements Comparable<Job> {
		int start;
		int end;
		int profit;

		Job1(int start, int end, int profit) {
			this.start = start;
			this.end = end;
			this.profit = profit;
		}

		public int compareTo(Job otherJob) {
			return this.start - otherJob.start;
		}
	}

	public int jobScheduling_1(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		Job1[] jobs = new Job1[n];
		for (int i = 0; i < n; i++) {
			jobs[i] = new Job1(startTime[i], endTime[i], profit[i]);
		}
		Arrays.sort(jobs);
		int[] dp = new int[n];

		dp[n - 1] = jobs[n - 1].profit;

		for (int i = n - 2; i >= 0; i--) {
			dp[i] = Math.max(jobs[i].profit, dp[i + 1]);
			for (int j = i + 1; j < n; j++) {
				if (jobs[i].end <= jobs[j].start) {
					dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
					break;
				}
			}
		}
		return dp[0];
	}

	// LEETCODE 100% TIME

	// sort based on start time

	// add last profit at last index in 1 D dynamic array

	// Start for loop with i second last index.
	// In 1st for loop update second last index value in dp by
	// comparing between last dp value and second last profit

	// Run inner loop starting with j = i + 1 and run up to array length but break
	// if code enters if block
	// Inside if block we compare finish time of i loop with start time of j loop
	// finish time must be smaller of equals to start time

	// inside if block make compare of dp[] at i with profit of i plus dp[] of j
	// then break

	// return 1st index value from dp
	public int jobScheduling_LEET() {
		Arrays.sort(jobs);
		int n = jobs.length;
		int i = 0;
		int[] dp = new int[n];
		dp[n - 1] = jobs[n - 1].profit;
		for (i = n - 2; i >= 0; i--) {
			dp[i] = Math.max(jobs[i].profit, dp[i + 1]);
			for (int j = i + 1; j < n; j++) {
				if (jobs[i].finish <= jobs[j].start) {
					dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
					break;
				}
			}
		}
		return dp[0];
	}
}

class Job implements Comparable<Job> {
	int start, finish, profit;

	Job(int start, int finish, int profit) {
		this.start = start;
		this.finish = finish;
		this.profit = profit;
	}

	@Override
	public int compareTo(Job obj) {
		return this.finish - obj.finish;
	}
}

class Pair implements Comparable<Pair> {
	int start, end, profit;

	public Pair(int start, int end, int profit) {
		this.profit = profit;
		this.end = end;
		this.start = start;
	}

	public int compareTo(Pair p) {
		if (this.end == p.end)
			return this.start - p.start;
		return this.end - p.end;

	}
}
