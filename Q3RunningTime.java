package com.practice.sp.solutions;

import java.util.ArrayList;
import java.util.List;

public class Q3RunningTime {

	public static void main(String args[]) {


		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task("t1",1, "RUNNING"));
		tasks.add(new Task("t2",3, "RUNNING"));
		tasks.add(new Task("t3",4, "COMPLETED"));
		tasks.add(new Task("t4",6, "RUNNING"));
		tasks.add(new Task("t5",1, "COMPLETED"));
		tasks.add(new Task("t6",2, "RUNNING"));
		tasks.add(new Task("t7",5, "COMPLETED"));
		tasks.add(new Task("t8",1, "COMPLETED"));

		System.out.println(findLongRunningTask(tasks));
	}

	private static Result findLongRunningTask(List<Task> tasks) {

		String startTime = "";
		String endTime = "";


		int maxCount = 0;
		int currSum = 0;
		for (Task t: tasks) {

			if("RUNNING".equalsIgnoreCase(t.status)) {
				if(startTime.isEmpty()) startTime = t.tStamp;

				currSum += t.count;
			} else if("COMPLETED".equalsIgnoreCase(t.status)) {
				currSum -= t.count;

			}

			if(currSum > maxCount) {
				endTime = t.tStamp;
				maxCount = currSum;
			}

//			System.out.println("startTime: " + startTime);
//			System.out.println("endTime: " + endTime);
//			System.out.println(currSum);
			if(currSum == 0) {
				startTime = "";
				endTime = "";
			}

		}

		return  new Result(startTime, endTime);
	}


}

class Task {
	String tStamp;
	int count;
	String status;

	public Task(String t, int c, String s) {
		this.tStamp = t;
		this.count = c;
		this.status = s;
	}
}

class Result {
	String start;
	String end;

	public Result(String start, String end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{start: ").append(start);
		sb.append(", end: ").append(end);
		sb.append("}");

		return sb.toString();
	}
}
