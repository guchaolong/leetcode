### 解题思路
如果是左括号：压栈
如果是右括号：出栈判断。但是要出栈起码栈中原本得有东西，所以需要判断size；如果size是0，又来了右括号，直接return false。

当所有的括号处理完后，如果栈不空，说明左括号多余了，fasle；

### 代码

```java
class Solution {
    public boolean isValid(String s) {
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char c : str){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else {
                if(stack.size()>0){
                    char temp = stack.pop();
                    if(temp=='('&&c==')' || temp=='{'&&c=='}' || temp=='['&&c==']')
                        continue;
                    else 
                        return false;
                }else
                    return false;
            }
        }
        if(stack.empty())
            return true;
        return false;
        
    }
}
```