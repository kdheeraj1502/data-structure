package dynamic.programming;

import java.util.*;

public class WeightedActivitySelection {

	private Job jobs[];

	WeightedActivitySelection(Job jobs[]) {
		this.jobs = jobs;
	}

	public int maxProfit() {
		Arrays.sort(jobs, new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				return o1.finish - o2.finish;
			}
		});
		int dp[] = new int[jobs.length];
		int i = 0;
		for (Job last : jobs) {
			dp[i++] = last.profit;
		}

		i = 1;
		int j = 0;
		for(i = 1; i < dp.length; i++) {
			j = 0;
			while(j < i) {
				if(jobs[j].finish <= jobs[i].start) {
					dp[i] = Math.max(jobs[i].profit + dp[j], dp[i]);
				}
				j++;
			}
		}
		
		int max = 0;
		i = 0;
		j = dp.length - 1;
		while(i < j) {
			if(dp[i] > max) {
				max = dp[i++];
			}
			if(dp[j] > max) {
				max = dp[j--];
			} else {
				i++;
				j--;
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		Job jobs[] = new Job[4];
		jobs[0] = new Job(3, 10, 20);
		jobs[1] = new Job(1, 2, 50);
		jobs[2] = new Job(6, 19, 100);
		jobs[3] = new Job(2, 100, 200);
		WeightedActivitySelection was = new WeightedActivitySelection(jobs);
		System.out.println(was.maxProfit());
	}
}

class Job {
	int start, finish, profit;

	Job(int start, int finish, int profit) {
		this.start = start;
		this.finish = finish;
		this.profit = profit;
	}
}
