class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length; int l = 0;
        while (l < n) {
            if (gas[l] - cost[l] < 0) {
                l++;
                continue;
            }
            int steps = 0; int curEnergy = 0;
            // Try if can walk n steps from l.
            while (steps < n) {
                // Try if can walk with current energy & energy[r].
                int r = l + steps;
                if ((curEnergy + gas[r % n] - cost[r % n]) >= 0) {
                    curEnergy += (gas[r % n] - cost[r % n]);
                } else {
                    break;
                }
                steps++;
                if (steps == n) {
                    return l;
                }
            }
            // Stops at energy[r].Possible l start from r + 1.
            l = l + steps + 1;
        }
        return -1;
    }
}
