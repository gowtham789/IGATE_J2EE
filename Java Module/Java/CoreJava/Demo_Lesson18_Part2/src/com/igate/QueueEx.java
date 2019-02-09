package com.igate;

import java.util.PriorityQueue;

public class QueueEx {

	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("a");
		pq.add("b");
		pq.add("c");
		System.out.println(pq);

		System.out
				.println("Poll returns the first element and removes it from the queue");
		// Poll returns the first element and removes it from the queue
		System.out.println("poll on Queue :"+pq.poll());
		System.out.println("Queue after Poll is :"+pq);

		System.out.println("______________________");
		System.out.println("Queue is :");

		PriorityQueue<String> pq2 = new PriorityQueue<String>();
		pq2.add("a");
		pq2.add("b");
		pq2.add("c");
		System.out.println(pq2);

		System.out.println("Peek returns the first element and does not remove it from the queue");
		// Peek returns the first element and does not remove it from the queue
		System.out.println("Peek on queue : "+pq2.peek());
		System.out.println("Queue after peek  :"+pq2);

	}

}
