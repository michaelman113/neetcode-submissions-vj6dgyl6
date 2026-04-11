public class Solution {
    public int[][] merge(int[][] intervals) {
          // 1. Sort the intervals based on their start times.
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 2. Create a list to store the merged intervals.
        List<int[]> output = new ArrayList<>();
         // 3. Add the first interval to the output list as a starting point.
        output.add(intervals[0]);

        // 4. Iterate through the remaining intervals.
        for (int[] interval : intervals) {
            // 5. Get the start and end times of the current interval.
            int start = interval[0];
            int end = interval[1];
            // 6. Get the end time of the last merged interval in the output list.
            int lastEnd = output.get(output.size() - 1)[1];

            // 7. Check for overlap: If the current interval's start time is <= the last merged interval's end time, there's an overlap.
            if (start <= lastEnd) {
                // 8. Merge the intervals: Update the end time of the last merged interval to be the maximum of the current interval's end time and the previous end time.
                output.get(output.size() - 1)[1] = Math.max(lastEnd, end);
            } else {
                // 9. No overlap: Add the current interval as a new merged interval to the output list.
                output.add(new int[]{start, end});
            }
        }
        // 10. Convert the list of merged intervals to a 2D array and return it.
        return output.toArray(new int[output.size()][]);
    }
}
