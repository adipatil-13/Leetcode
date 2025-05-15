class Node {
    int key;
    int val;
    Node next;

    Node (int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}
class MyHashMap {

    private Node[] map;

    public MyHashMap() {
        map = new Node[1000];
        for (int i = 0; i < 1000; i++) {
            map[i] = new Node(-1, -1);
        }
    }
    
    public void put(int key, int value) {
        int hash = key % 1000;
        Node curr = map[hash];

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new Node(key, value);
    }
    
    public int get(int key) {
        int hash = key % 1000;
        Node curr = map[hash].next;

        while (curr != null) {
            if (curr.key == key)
                return curr.val;
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = key % 1000;
        Node curr = map[hash];

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */