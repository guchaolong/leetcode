package leetcode.editor.cn;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 674 👎 0

import java.util.Stack;


//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    //不使用辅助栈
//    private Stack<Integer> _data;
//    /**
//     * initialize your data structure here.
//     */
//    public MinStack() {
//        this._data = new Stack<>();
//    }
//
//    public void push(int x) {
//        if (_data.isEmpty()) {
//            _data.push(x);
//            _data.push(x);
//        } else {
//            _data.push(x);
//            Integer temp = _data.peek();
//            if (temp > x) {
//                temp = x;
//            }
//            _data.push(temp);
//        }
//    }
//
//    public void pop() {
//        _data.pop();
//        _data.pop();
//    }
//
//    public int top() {
//        return _data.get(_data.size() - 2);
//    }
//
//    public int getMin() {
//        return _data.peek();
//    }

    private Stack<Integer> _data;
    private Stack<Integer> _min;

    public MinStack() {
        this._data = new Stack<>();
        this._min = new Stack<>();
    }

    public void push(int x) {
        _data.push(x);
        if (_min.isEmpty() || x <= _min.peek()) {
            _min.push(x);
        }
    }

    public void pop() {
        if (_data.pop().equals(_min.peek())) {
            _min.pop();
        }
    }

    public int top() {
        return _data.peek();
    }

    public int getMin() {
        return _min.peek();
    }


}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

