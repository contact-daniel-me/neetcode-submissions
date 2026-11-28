class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if (n == 0 || k <= 0 || k > n) {
            return new int[0];
        }

        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        int idx = 0;

        for (int i = 0; i < n; i++) {

            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Maintain decreasing order of values
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Record maximum once the window is complete
            if (i >= k - 1) {
                result[idx++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}