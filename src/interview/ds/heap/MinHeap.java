package interview.ds.heap;

import java.util.Arrays;

public class MinHeap {

	private int[] nodeTable;
	private final int DEFAULT_SIZE = 5;
	private int lastIndex = -1;

	public MinHeap() {
		nodeTable = new int[DEFAULT_SIZE];
	}

	public MinHeap(int initialSize) {
		nodeTable = new int[initialSize];
	}

	public void insertElement(int ele) {
		lastIndex++;
		ensureCapacity();
		nodeTable[lastIndex] = ele;
		shiftUp();

	}

	public void printHeap() {
		int i = 0;
		while (nodeTable[i] != Integer.MIN_VALUE) {
			System.out.print(nodeTable[i] + " ");
			i++;
		}
		System.out.println();
	}

	private void shiftUp() {
		int currentIndex = lastIndex;
		int parentIndex = getParentAddress(lastIndex);
		while (nodeTable[parentIndex] > nodeTable[currentIndex]) {
			swap(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = getParentAddress(currentIndex);
		}
	}

	public int getminimum() {
		return nodeTable[0];
	}

	public int popMinimum() {
		int x = nodeTable[0];
		nodeTable[0] = nodeTable[lastIndex];
		nodeTable[lastIndex] = Integer.MIN_VALUE;
		lastIndex--;
		siftDown();
		//printHeap();
		return x;
	}

	private void siftDown() {

		int currentIndex = 0;
		while (true) {
			int leftIndex = getLeft(currentIndex);
			if (leftIndex >= lastIndex) {
				if (leftIndex > lastIndex) {
					return;
				}
				if ((nodeTable[currentIndex] > nodeTable[leftIndex])) {
					swap(leftIndex, currentIndex);
				}
				return;
			}
			int rightIndex = getRight(currentIndex);

			if (nodeTable[currentIndex] <= nodeTable[leftIndex] && nodeTable[currentIndex] <= nodeTable[rightIndex]) {
				return;
			}

			if (nodeTable[currentIndex] > nodeTable[leftIndex] && nodeTable[currentIndex] > nodeTable[rightIndex]) {
				int minIndex = nodeTable[leftIndex] < nodeTable[rightIndex] ? leftIndex : rightIndex;
				swap(minIndex, currentIndex);
				currentIndex = minIndex;
			} else if (nodeTable[currentIndex] > nodeTable[leftIndex]) {
				swap(leftIndex, currentIndex);
				currentIndex = leftIndex;
			} else {
				swap(rightIndex, currentIndex);
				currentIndex = rightIndex;
			}
		}
	}

	private void swap(int minIndex, int currentIndex) {
		int temp = nodeTable[minIndex];
		nodeTable[minIndex] = nodeTable[currentIndex];
		nodeTable[currentIndex] = temp;
	}

	private int getParentAddress(int index) {
		return (index - 1) / 2;
	}

	private int getLeft(int index) {
		return (2 * index + 1);
	}

	private int getRight(int index) {
		return (2 * index + 2);
	}

	private void ensureCapacity() {
		if (lastIndex == nodeTable.length) {
			int newLength = nodeTable.length << 1;
			nodeTable = Arrays.copyOf(nodeTable, newLength);

			for (int i = lastIndex; i < nodeTable.length; i++) {
				nodeTable[i] = Integer.MIN_VALUE;
			}
		}
	}

}
