struct Node {
    Node* prev;
    Node* next;
    int key;
    int val;
    Node(int key1, int val1) : key(key1), val(val1) {}
};

class LRUCache {

private:

    int allowed;
    Node* left;
    Node* right;

    void remove(Node* toRemove) {
        Node* previous = toRemove->prev;
        Node* preceding = toRemove->next;
        previous->next = preceding;
        preceding->prev = previous;
    }

    void insert(Node* toAdd) {
        Node* previous = right->prev;
        previous->next = toAdd;
        toAdd->prev = previous;
        toAdd->next = right;
        right->prev = toAdd;
    }

//remove and insert methods for DLL

public:
    unordered_map<int, Node*> cache;
    LRUCache(int capacity) {
        left = new Node(0, 0);
        right = new Node(0, 0);
        left->next = right;
        right->prev = left;
        allowed = capacity;
        cache.clear();
    }
    
    int get(int key) {
        if (cache.find(key) != cache.end()) {
            Node* toGet = cache[key];
            remove(toGet);
            insert(toGet);
            return toGet->val;
        } else {
            return -1;
        }
    }
    
    void put(int key, int value) {
        if (cache.find(key) != cache.end()) {
            Node* toGet = cache[key];
            toGet->val = value;
            remove(toGet);
            insert(toGet);
        } else {
            if (cache.size() == allowed) {
                Node* lru = left->next;
                cache.erase(lru->key);
                remove(lru); //remove LRU
            }
            Node* toAdd = new Node(key, value);
            insert(toAdd);
            cache.insert({key, toAdd});
        }
    }
};


//map[], dll


//left sentinel (LRU), -> right sentinel (MRU)

//map<int, Node> cache;
//
//