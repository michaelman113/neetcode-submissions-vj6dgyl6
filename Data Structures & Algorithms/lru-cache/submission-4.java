class LRUCache {
    ArrayList<int[]> cache;
    int size;
    public LRUCache(int capacity) {
        cache = new ArrayList<>();
        size = capacity;
    }
    
    public int get(int key) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i)[0] == key) {
                int[] curr = cache.remove(i);
                cache.add(curr);
                return curr[1];
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i)[0] == key) {
                int[] curr = cache.remove(i);
                curr[1] = value;
                cache.add(curr);
                return;
            }
        }
        if (cache.size() == size) {
            cache.remove(0);
        }
        int[] newEntry = new int[]{key, value};
        cache.add(newEntry);
    }
}
