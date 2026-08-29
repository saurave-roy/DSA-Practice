Brute Force Approach:

private boolean possible(int[] bloomDay, int day, int m, int k) {

    int count = 0;
    int bouquets = 0;

    for (int i = 0; i < bloomDay.length; i++) {

        if (bloomDay[i] <= day) {
            count++;
        } else {
            bouquets += count / k;
            count = 0;
        }
    }

    bouquets += count / k;

    return bouquets >= m;
}

public int minDays(int[] bloomDay, int m, int k) {

    int n = bloomDay.length;

    if ((long)m * k > n) {
        return -1;
    }

    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE;

    for (int x : bloomDay) {
        low = Math.min(low, x);
        high = Math.max(high, x);
    }

    while (low <= high) {

        int mid = low + (high - low) / 2;

        if (possible(bloomDay, mid, m, k)) {
            high = mid - 1;   // try smaller day
        } else {
            low = mid + 1;    // need more days
        }
    }

    return low;
}




OPTIMAL SOLUTION:

class Solution {

    private boolean possible(int[] bloomDay, int day, int m, int k) {

        int count = 0;
        int bouquets = 0;

        for (int flower : bloomDay) {

            if (flower <= day) {
                count++;
            } else {
                bouquets += count / k;
                count = 0;
            }
        }

        bouquets += count / k;

        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        if ((long) m * k > n) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (possible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
