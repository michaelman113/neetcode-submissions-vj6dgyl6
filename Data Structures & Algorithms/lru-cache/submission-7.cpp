// The Node class is fine as-is. It's just a data container.
class Node {
public:
    int key;
    int val;
    Node* prev;
    Node* next;

    Node(int k, int v) : key(k), val(v), prev(nullptr), next(nullptr) {}
};

class LRUCache {
private:
    int cap;
    // Stores key -> pointer to Node in the doubly linked list
    unordered_map<int, Node*> cache; 
    
    // Sentinel nodes: 'left' is LRU side, 'right' is MRU side
    Node* left;
    Node* right;

    // Helper: Removes a node from its current position in the list
    void remove(Node* node) {
        Node* prev = node->prev;
        Node* nxt = node->next;
        prev->next = nxt;
        nxt->prev = prev;
    }

    // Helper: Inserts a node just before the 'right' (MRU) sentinel
    void insert(Node* node) {
        Node* prev = right->prev;
        prev->next = node;
        node->prev = prev;
        node->next = right;
        right->prev = node;
    }

public:
    LRUCache(int capacity) {
        cap = capacity;
        cache.clear();
        
        // Allocate sentinel nodes
        left = new Node(0, 0);  // LRU marker
        right = new Node(0, 0); // MRU marker
        
        // Link them together
        left->next = right;
        right->prev = left;
    }

    // *** ADDED DESTRUCTOR ***
    ~LRUCache() {
        // We must delete ALL nodes we allocated with 'new'.
        // This includes all nodes in the cache and the two sentinels.
        // A simple way is to iterate through the list from one sentinel
        // to the other, deleting as we go.
        Node* curr = left;
        while (curr) {
            Node* nextNode = curr->next;
            delete curr;
            curr = nextNode;
        }
        
        // After the loop, all nodes (left, right, and all cache nodes)
        // have been deleted. No need to delete left/right separately.
        // The map 'cache' will clean itself up, as it just holds
        // pointers that now point to freed memory.
    }

    int get(int key) {
        if (cache.find(key) != cache.end()) {
            Node* node = cache[key];
            // Move to most recently used
            remove(node);
            insert(node);
            return node->val;
        }
        return -1;
    }

    // *** CORRECTED 'put' METHOD ***
    void put(int key, int value) {
        // Case 1: Key already exists.
        if (cache.find(key) != cache.end()) {
            Node* node = cache[key];
            
            // 1. Update the value (no new node needed!)
            node->val = value; 
            
            // 2. Move it to the MRU position
            remove(node);
            insert(node);
            
            // This fixes the memory leak by reusing the existing node.
            return; 
        }

        // Case 2: Key is new.
        // We must check capacity *before* inserting.
        if (cache.size() == cap) {
            // Evict the LRU node
            Node* lru = left->next;
            remove(lru);
            cache.erase(lru->key); // Remove from map
            delete lru;            // Free the memory
        }

        // Now, create and insert the new node
        Node* newNode = new Node(key, value);
        cache[key] = newNode;
        insert(newNode);
    }
};