package interview.ds.heap;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HeapProblems {

	public static void main(String[] args) {
		// MinHeap minHeap = new MinHeap();

		PriorityQueue<StreamElement> minHeap = new PriorityQueue<>();

		NumberGenerator[] numberGenerators = new NumberGenerator[10];
		Thread[] tt = new Thread[10];
		for (int i = 0; i < 10; i++) {
			numberGenerators[i] = new NumberGenerator(i, 0, new ArrayBlockingQueue<>(10));
			tt[i] = new Thread(numberGenerators[i]);
		}

		for (int i = 0; i < 10; i++) {
			tt[i].start();
		}

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				BlockingQueue<StreamElement>[] blockingQueues = new BlockingQueue[10];
				for (int i = 0; i < 10; i++) {
					blockingQueues[i] = numberGenerators[i].getQueue();
				}

				for (int i = 0; i < 10; i++) {
					try {
						minHeap.add(blockingQueues[i].take());

					} catch (InterruptedException e) {
					}
				}

				while (true) {
					StreamElement x = minHeap.poll();
					System.out.println(x);

					try {
						StreamElement ele = blockingQueues[x.streamId].take();
						minHeap.add(ele);
					} catch (InterruptedException e) {
					}
				}
			}
		});

		t.start();

		try {
			t.join();
		} catch (InterruptedException e) {
		}

	}

}

class NumberGenerator implements Runnable {
	private BlockingQueue<StreamElement> queue;
	private int currentvalue = 0;
	Random r = new Random();
	private final int streamId;

	NumberGenerator(int streamId, int currentvalue, BlockingQueue<StreamElement> queue) {
		this.currentvalue = currentvalue;
		this.queue = queue;
		this.streamId = streamId;
	}

	@Override
	public void run() {
		while (true) {
			currentvalue = currentvalue + r.nextInt(10);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			try {
				// System.out.println("Adding value to Queue:" + currentvalue);
				queue.put(new StreamElement(streamId, currentvalue));
			} catch (InterruptedException e) {
			}
		}
	}

	public BlockingQueue<StreamElement> getQueue() {
		return queue;
	}

}

class StreamElement implements Comparable<StreamElement> {

	int streamId;
	int ele;

	StreamElement(int streamId, int ele) {
		this.streamId = streamId;
		this.ele = ele;
	}

	@Override
	public int compareTo(StreamElement o) {
		if (this.ele > o.ele) {
			return 1;
		} else if (this.ele < o.ele) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "StreamElement [streamId=" + streamId + ", ele=" + ele + "]";
	}

}
