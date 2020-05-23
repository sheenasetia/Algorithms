class Main2
{
	private static final int N = 10;
	private static final int SUM = 100;

	// create a lookup table to store solutions of sub-problems
	// lookup[i][j] stores number of ways to achieve sum j
	// with j throws of given dice.
	private static int[][] lookup = new int[N][SUM];

	// Function to calculate total number of ways to achieve given
	// sum with n throws of dice having k faces
	public static int count(int n, int k, int sum)
	{
		// if desired sum is reached with n dices
		if (n == 0) {
			return (sum == 0) ? 1 : 0;
		}

		// desired sum can't be reached with current configuration
		if (sum < 0 || k * n < sum || n > sum){
			return 0;
		}

		// if sub-problem is seen for the first time, solve it and
		// store its result in an array or map
		if (lookup[n][sum] == 0) {
			// recur for all possible solutions
			for (int i = 1; i <= k; i++) {
				lookup[n][sum] += count(n - 1, k, sum - i);
			}
		}

		// return solution to current sub-problem
		return lookup[n][sum];
	}

	public static void main(String[] args)
	{
		int n = 4;	// n throws
		int k = 6;	// values 1 - 6

		int sum = 15;	// desired sum

		System.out.println("Total number of ways are " + count(n, k, sum));
	}
}