package DS;

import java.util.ArrayList;
import java.util.Stack;

// myStack


public class _stack {


    public static void main(String[] args) {
//        official implement
        Stack<Integer> stack = new Stack<>();
        /* 元素入栈 */
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        /* 访问栈顶元素 */
        int peek = stack.peek();

        /* 元素出栈 */
        int pop = stack.pop();

        /* 获取栈的长度 */
        int size = stack.size();

        /* 判断是否为空 */
        boolean isEmpty = stack.isEmpty();

    }
}
// 使用LinkedList来构建Stack

class LinkedListStack {
    private ListNode stackPeek;
    private int stkSize = 0;

    public LinkedListStack() {
        stackPeek = null;
    }

    public int size() {
        return stkSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return stackPeek.val;
    }

    public void push(int num) {
//        用于做新StackPeek的新Node
        ListNode node = new ListNode(num);
//        将最新的Node的next指向原来的peek
        node.next = stackPeek;
//        成为最新的StackPeek
        stackPeek = node;
        stkSize++;

    }

    public int pop() {
        int num = peek();
        stackPeek = stackPeek.next;
        stkSize--;
        return num;
    }

    //   List convert to Array
    public int[] toArray() {
        ListNode node = stackPeek;
        int[] res = new int[size()];
        for (int i = res.length - 1; i >= 0; i++) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }


}
//使用数组实现Stack
class  ArrayStack{
    private ArrayList<Integer> stack ;
    public ArrayStack(){
        stack = new ArrayList<>();
    }
    public int size(){
        return  stack.size();
    }
    public boolean isEmpty(){
        return  size() ==0;
    }
    public  void  push(int num){
        stack.add(num);
    }
    public  int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return  stack.get(size()-1);
    }
    public int pop(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return stack.remove(size() - 1);
    }
    public Object[] toArray(){
        return stack.toArray();
    }
}
