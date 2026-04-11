class RandomizedSet {
private:
    unordered_map<int, int> nums1;
    vector<int> nums2;
public:
    RandomizedSet() {
        
    }
    
    bool insert(int val) {
        if (nums1.find(val) != nums1.end()) {
            return false;
        }
        nums2.push_back(val);
        nums1.insert({val, nums2.size() - 1});
        return true;
    }
    
    bool remove(int val) {
        if (nums1.find(val) == nums1.end()) {
            return false;
        }
        int index = nums1[val];
        int lastInd = nums2.size() - 1;
        int lastVal = nums2[lastInd];
        //swap
        int temp = nums2[index];
        nums2[index] = lastVal;
        nums2[lastInd] = temp;
        nums1[lastVal] = index;
        nums2.pop_back();
        nums1.erase(val);
        return true;
    }
    
    int getRandom() {
        //nums2.size() = 2
        //0 % 2 = 0
        //1 % 2 = 1
        //2 % 2 = 0
        int index = rand() % (nums2.size());
        return nums2[index];
        //rand() 
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */