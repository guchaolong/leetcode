```java
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()) {
                int j = stack.peek();
                if (T[j] < T[i]) {
                    ans[j] = i - j;
                    stack.pop();
                }
                else {
                    break;
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
```
