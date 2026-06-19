class RandomizedSet {
public:
    unordered_map<int, int> pos;
    vector<int> values;
    RandomizedSet() {
        
    }
    
    bool insert(int val) {
        if (pos.find(val) != pos.end()) {
            return false;
        } else {
            pos[val] = values.size();
            values.push_back(val);
            return true;
        }
    }
    
    bool remove(int val) {
        if (pos.find(val) == pos.end()) {
            return false;
        } else {
            //replace current element with last one
            int idx = pos[val];
            int last = values.back();
            values[idx] = last;
            pos[last] = idx;
            values.pop_back();
            pos.erase(val);
            return true;
        }
    }
    
    int getRandom() {
        int ind = (rand() % (values.size()));
        return values[ind];
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */