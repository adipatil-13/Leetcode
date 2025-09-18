class TaskManager {
    private Map<Integer, Integer> taskPriority;
    private Map<Integer, Integer> taskOwner;
    private PriorityQueue<int[]> pq;
    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {if (b[0] != a[0]) return b[0] - a[0]; return b[1] - a[1];});
        taskPriority = new HashMap<>();
        taskOwner = new HashMap<>();
        for (List<Integer> list : tasks) add(list.get(0), list.get(1), list.get(2));
    }
    
    public void add(int userId, int taskId, int priority) {
        pq.add(new int[]{priority, taskId});
        taskPriority.put(taskId, priority);
        taskOwner.put(taskId, userId);
    }
    
    public void edit(int taskId, int newPriority) {
        pq.add(new int[]{newPriority, taskId});
        taskPriority.put(taskId, newPriority);
    }
    
    public void rmv(int taskId) {
        taskPriority.put(taskId, -1);
    }
    
    public int execTop() {
        while (!pq.isEmpty()) {
            int[] it = pq.poll();
            int p = it[0], id = it[1];
            if (taskPriority.getOrDefault(id, -2) == p) {
                taskPriority.put(id, -1);
                return taskOwner.getOrDefault(id, -1);
            }
        }
        return -1;
    }
}
