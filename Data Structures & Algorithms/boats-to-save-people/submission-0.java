public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // Sort weights to try pairing lightest and heaviest
        int res = 0, l = 0, r = people.length - 1;
        while (l <= r) {
            int remain = limit - people[r--]; // Always place heaviest person on a boat
            res++; // One boat used
            if (l <= r && remain >= people[l]) {
                l++; // Pair with lightest person if they fit
            }
        }
        return res; // Total boats used
    }
}
