class Solution {
    static final long MOD = 1_000_000_007;

    // Fast exponentiation for modulo
    private long modPow(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    // Modular inverse using Fermat's Little Theorem
    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Build the powers array from binary representation
        java.util.List<Long> powers = new java.util.ArrayList<>();
        for (int bit = 0; bit < 31; bit++) {
            if ((n & (1 << bit)) != 0) {
                powers.add(1L << bit);
            }
        }

        // Step 2: Prefix product array (mod MOD)
        long[] prefix = new long[powers.size()];
        prefix[0] = powers.get(0) % MOD;
        for (int i = 1; i < powers.size(); i++) {
            prefix[i] = (prefix[i - 1] * powers.get(i)) % MOD;
        }

        // Step 3: Answer queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0], R = queries[i][1];
            if (L == 0) {
                ans[i] = (int) prefix[R];
            } else {
                long val = (prefix[R] * modInverse(prefix[L - 1])) % MOD;
                ans[i] = (int) val;
            }
        }
        return ans;
    }
}
