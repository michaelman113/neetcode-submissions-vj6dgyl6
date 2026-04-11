class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            boolean alive = true;

            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop(); // smaller right-moving asteroid destroyed
                } else if (stack.peek() == -asteroid) {
                    stack.pop(); // both destroyed
                    alive = false;
                    break;
                } else {
                    // incoming asteroid destroyed
                    alive = false;
                    break;
                }
            }

            if (alive) {
                stack.push(asteroid);
            }
        }

        // Convert to array
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
