public int solution(int N) {
	int sum = 0;
	int[] coins = {500, 100, 50, 10};
	int index = 0;
	
	while (N > 0) {
		sum += N / coins[i];
		N %= coins[i];
		i++;
	}

	return sum;
}