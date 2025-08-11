class Solution {
    int mod = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
        List<Long> powervec = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                powervec.add(1L << i);
            }
        }
        int[] ans = new int[queries.length];
        for (int idx = 0; idx < queries.length; idx++) {
            int left = queries[idx][0];
            int right = queries[idx][1];
            long product = 1;
            for (int j = left; j <= right; j++) {
                product = (product * powervec.get(j)) % mod;
            }
            ans[idx] = (int) product;
        }
        return ans;
    }
}