class LRUCache {

    public ArrayList<int[]> cache;
    public int capacity;

    public LRUCache(int capacity) {
        cache = new ArrayList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i)[0] == key) {
                int[] nex = cache.remove(i);
                int val = nex[1];
                cache.add(nex);
                return val;
            }
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i)[0] == key) {
                int[] nex = cache.remove(i);
                int val = value;
                cache.add(new int[]{key, val});
                return;
            }
        }
        if (cache.size() == capacity) {
            cache.remove(0);
        }
        cache.add(new int[]{key, value});
        for (int[] entry : cache) {
            System.out.print(entry[0]);
            System.out.println(entry[1]);
        }
    }
}
