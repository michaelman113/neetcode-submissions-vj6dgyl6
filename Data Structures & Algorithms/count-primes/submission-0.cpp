class Solution {
public:
    int countPrimes(int n) {
        if (n < 3) return 0;

        vector<bool> isPrime(n, false);
        int count = n / 2;

        for (int i = 3; i * i < n; i += 2) {
            if (!isPrime[i]) {
                for (int j = i * i; j < n; j += 2 * i) {
                    if (!isPrime[j]) {
                        isPrime[j] = true;
                        count--;
                    }
                }
            }
        }

        return count;
    }
};