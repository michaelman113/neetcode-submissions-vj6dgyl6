class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        heapSort(nums);
        return nums;
    }
private:
    void heapify(vector<int>& arr, int n, int i) {
        int l = (i << 1) + 1;
        int r = (i << 1) + 2;
        int largestNode = i;

        if (l < n && arr[l] > arr[largestNode]) {
            largestNode = l;
        }

        if (r < n && arr[r] > arr[largestNode]) {
            largestNode = r;
        }

        if (largestNode != i) {
            swap(arr[i], arr[largestNode]);
            heapify(arr, n, largestNode);
        }
    }

    void heapSort(vector<int>& arr) {
        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr[0], arr[i]);
            heapify(arr, i, 0);
        }
    }
};