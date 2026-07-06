class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int m = grid.length; int n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '0') continue;

                cnt++;
                bfs(grid, i, j, m, n);
            }
        }

        return cnt;
    }

    private void bfs(char[][] grid, int i, int j, int m, int n) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(i, j));
        grid[i][j] = '0';

        while (!q.isEmpty()) {
            Node cur = q.poll();
            searchNeighbors(q, grid, cur.i - 1, cur.j, m , n);
            searchNeighbors(q, grid, cur.i, cur.j + 1, m , n);
            searchNeighbors(q, grid, cur.i + 1, cur.j, m , n);
            searchNeighbors(q, grid, cur.i, cur.j - 1, m , n);
        }
    }

    private boolean searchNeighbors(Queue<Node> q, char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) return false;
        if (grid[i][j] == '0') return false;

        q.offer(new Node(i, j));
        grid[i][j] = '0';
        return true;
    }

    private class Node {
        int i;
        int j;

        public Node (int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}