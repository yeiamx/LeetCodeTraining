import java.util.Arrays;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks); Arrays.sort(workers);
        int l = 0; int r = Math.min(workers.length, tasks.length);
        int ans = 0;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            // Check if can finish m tasks.
            if (mTaskAssign(tasks, 0, m-1, workers, workers.length - m, workers.length - 1, pills, strength)) {// Using strongest m workers to finish m weakest tasks.
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    // Check if workers[wl..wr] able to finish tasks[tl..tr] using pills.
    private boolean mTaskAssign(int [] tasks, int tl, int tr, int[] workers, int wl, int wr, int pills, int strength) {
        int pillUsed = 0;
        int[] deque = new int[tr - tl + 1];
        int h = 0; int t = 0;
        // 定位第一个未搜索任务
        int p = tl;
        for (int i = wl; i <= wr; i++) {// Check if workers[i] able to finish job.
            // Add able task without pill.
            while (p <= tr && tasks[p] <= workers[i]) deque[t++] = p++;
            if (h < t && tasks[deque[h]] <= workers[i]) {
                h++;
                continue;
            }
            // Add pill for worker i.
            pillUsed++;
            int addedWorker = workers[i] + strength;
            // Add able task with pill.
            while (p <= tr && tasks[p] <= addedWorker) deque[t++] = p++;
            if (h == t) { // Cannot find a single task for worker i
                return false;
            }
            // Assign biggest task for worker i used a pill.
            t--;
        }
        return pillUsed <= pills;
    }
}
