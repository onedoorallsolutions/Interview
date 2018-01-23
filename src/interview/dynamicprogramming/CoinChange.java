package interview.dynamicprogramming;

public class CoinChange {

	public static void main(String[] args) {
		int[] coins = { 2, 5, 30, 25, 10 };

		int value = 115;

		System.out.println(findMinimumCoins(coins, coins.length, value));
	}

	private static int findMinimumCoins(int[] coins, int length, int value) {
		int[] minArray = new int[value + 1];

		for (int i = 1; i <= value; i++) {
			int min = Integer.MAX_VALUE;
			boolean isValid = false;
			for (int j = 0; j < length; j++) {
				if (i - coins[j] >= 0) {
					isValid = true;
					min = Math.min(min, minArray[i - coins[j]] + 1);
				}
			}
			if (isValid) {
				minArray[i] = min;
			}
		}

		return minArray[value];
	}

}
