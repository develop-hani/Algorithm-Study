class Solution {
    public int minimumEffort(int[][] tasks) {
        int energy = 0;
        int leftover = 0;
        Queue<Task> queue = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getMinimum() - b.getActual(), a.getMinimum() - a.getActual())
        );

        for (int i = 0; i < tasks.length; ++i) {
            queue.add(new Task(tasks[i][0], tasks[i][1]));
        }

        while(!queue.isEmpty()) {
            Task task = queue.poll();
            if (leftover < task.getMinimum()) {
                energy += (task.getMinimum() - leftover);
            }
            leftover = Math.max(task.getMinimum(), leftover) - task.getActual();
        }

        return energy;
    }

    private class Task {

        public Task (int actual, int minimum) {
            this.actual = actual;
            this.minimum = minimum;
        }

        private int actual;
        private int minimum;

        public int getActual() { return this.actual; }
        public int getMinimum() { return this.minimum; }
    }
}