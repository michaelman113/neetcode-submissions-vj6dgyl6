class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = piles[piles.length - 1];
        int res = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (test(piles, h, mid) == 1) {
                res = Math.min(res, mid);
                System.out.println(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private int test(int[] piles, int h, int rate) {
        for (int i = 0; i < piles.length; i++) {
            h -= Math.ceil((double)piles[i] / rate);
        }
        return (h >= 0 ? 1 : 0);
    }
}
