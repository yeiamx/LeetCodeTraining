class Solution {
    public int[] spiralArray(int[][] array) {
        if (array.length == 0) return new int[]{};
        // 右 下 左 上
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = array.length;
        int n = array[0].length;
        int[] res = new int[m * n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                visited[i][j] = false;
        int x = 0; int y = 0; int curDirectionIndex = 0; int numIndex = 0;
        while (numIndex < m * n) {
            res[numIndex++] = array[x][y];
            visited[x][y] = true;
            int nextX = x + direction[curDirectionIndex][0];
            int nextY = y + direction[curDirectionIndex][1];
            while (numIndex < m * n && illegalPos(m, n, nextX, nextY, visited)) {
                curDirectionIndex = (curDirectionIndex + 1) % 4;
                nextX = x + direction[curDirectionIndex][0];
                nextY = y + direction[curDirectionIndex][1];
            }
            x = nextX;
            y = nextY;
        }
        return res;
    }
    private boolean illegalPos(int m, int n, int x, int y, boolean[][] visited) {
        return x < 0 || x >=m || y < 0 || y >= n || visited[x][y];
    }
}