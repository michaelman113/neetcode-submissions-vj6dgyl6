class Solution {
    public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets to the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            }
            // For closing brackets, check if they match the top of the stack
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        // Stack should be empty if all brackets were matched
        return stack.isEmpty();
    }
}
