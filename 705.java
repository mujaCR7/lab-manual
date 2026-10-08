#include <vector>
#include <list>
#include <algorithm>

class MyHashSet {
private:
    static const int numBuckets = 769; // A prime number to reduce collisions
    std::vector<std::list<int>> buckets;

    int hash(int key) {
        return key % numBuckets;
    }

public:
    MyHashSet() : buckets(numBuckets) {}

    void add(int key) {
        int index = hash(key);
        auto& bucket = buckets[index];
        if (std::find(bucket.begin(), bucket.end(), key) == bucket.end()) {
            bucket.push_back(key);
        }
    }

    void remove(int key) {
        int index = hash(key);
        auto& bucket = buckets[index];
        bucket.remove(key);
    }

    bool contains(int key) {
        int index = hash(key);
        const auto& bucket = buckets[index];
        return std::find(bucket.begin(), bucket.end(), key) != bucket.end();
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
