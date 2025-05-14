class MyHashSet {

    private boolean[] data;

    public MyHashSet() {
        data = new boolean[1000001];
    }
    
    public void add(int key) {
        data[key] = true;
    }
    
    public void remove(int key) {
        data[key] = false;
    }
    
    public boolean contains(int key) {
        return data[key];
    }
}
/*
class MyHashSet {
    List<Integer>[] arr;
    int n = 10000;

    public MyHashSet() {
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
    }
    public void add(int key) {
        int idx = key % n;
        if (!arr[idx].contains(key)) {
            arr[idx].add(key);
        }
    }
    public void remove(int key) {
        int idx = key % n;
        arr[idx].remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int idx = key % n;
        return arr[idx].contains(key);
    }
}
*/