class RandomizedSet {
private:
    unordered_map<int, int> numMap;
    vector<int> nums;

public:
    RandomizedSet() {}

    bool insert(int val) {
        if (numMap.count(val)) return false;
        numMap[val] = nums.size();
        nums.push_back(val);
        return true;
    }

    bool remove(int val) {
        if (!numMap.count(val)) return false;
        int idx = numMap[val];
        int last = nums.back();
        nums[idx] = last;
        numMap[last] = idx;
        nums.pop_back();
        numMap.erase(val);
        return true;
    }

    int getRandom() {
        return nums[rand() % nums.size()];
    }
};