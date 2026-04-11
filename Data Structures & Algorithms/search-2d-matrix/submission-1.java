class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (target > matrix[i][matrix[i].length - 1]) {
                continue;
            } else {
                int start = 0;
                int end = matrix[i].length - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (target > matrix[i][mid]) {
                        start = mid + 1;
                    } else if (target < matrix[i][mid]) {
                        end = mid - 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
