class Main1
{
	// Function to calculate total number of ways to achieve given
	// sum with n throws of dice having k faces
	public static int count(int n, int k, int sum)
	{
		// if desired sum is reached with n dices
		if (n == 0) {
			return (sum == 0) ? 1: 0;
		}

		// desired sum can't be reached with current configuration
		if (sum < 0 || k * n < sum || n > sum) {
			return 0;
		}

		int res = 0;

		// recur for all possible solutions
		for (int i = 1; i <= k; i++) {
			res += count(n - 1, k, sum - i);
		}

		return res;
	}

	public static void main(String[] args)
	{
		int n = 4;	// n throws
		int k = 6;	// values 1 - 6

		int sum = 15;	// desired sum

		System.out.println("Total number of ways are " + count(n, k, sum));
	}
}