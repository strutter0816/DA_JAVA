package DS;

import javax.xml.bind.Binder;
import java.util.LinkedList;
import java.util.Queue;

// 使用LinkedList实现Queue
class  LinkedListQueue{
    private  ListNode front , rear ;
    private  int queSize = 0;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }
    public int size(){
        return  queSize;
    }
    public boolean isEmpty(){
        return  size() == 0;

    }
    public  void push( int num ){
        ListNode node = new ListNode(num);
        if(front == null){
            front = node;
            rear = node;
        }else {
            rear.next = node;
            rear  = node;
        }
        queSize++;
    }
    public  int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return front.val;
    }
    public  int  pop(){
        int num = peek();
        front = front.next;
        queSize--;
        return  num;
    }
    public  int[] toArray(){
        ListNode node = front;
        int[] res = new int[size()];
        for (int i = 0 ; i < res.length ; i ++){
            res[i] = node.val;
            node = node.next;
        }
        return  res;
    }
}

public class _queue {
    public static void main(String[] args) {
//        official implement
        Queue<Integer> queue = new LinkedList<>();
        /* 元素入队 */
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(5);
        queue.offer(4);

        /* 访问队首元素 */
        int peek = queue.peek();

        /* 元素出队 */
        int pop = queue.poll();

        /* 获取队列的长度 */
        int size = queue.size();

        /* 判断队列是否为空 */
        boolean isEmpty = queue.isEmpty();

    }
}
