package interview.dynamicprogramming;

public class CuttingRod {

	public static void main(String[] args) {
		int[] arr = {3,5,8,9,10,20,22,25};
		int x = findMaximumProfit(arr, arr.length);

		System.out.println("Maximum Profit :" + x);
	}

	private static int findMaximumProfit(int[] arr, int length) {

		int[] profit = new int[length + 1];

		for (int i = 0; i < arr.length; i++) {

			int maxProfit = Integer.MIN_VALUE;

			for (int j = i; j >= 0; j--) {
				maxProfit = Math.max(maxProfit, arr[j] + profit[i - j]);
			}
			profit[i + 1] = maxProfit;
		}

		return profit[length];
	}

}
