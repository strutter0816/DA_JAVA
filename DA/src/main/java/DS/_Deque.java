package DS;

import java.util.Deque;
import java.util.LinkedList;

class BListNode{
    int val;
    BListNode next;
    BListNode prev;

    BListNode(int val){
        this.val = val;
        prev = next = null;
    }
}
class  LinkedListDeque{
    private BListNode front,rear;
    private  int queSize = 0;
    public LinkedListDeque(){
        front = rear = null;
    }
    public  int size(){
        return  queSize;
    }
    public  boolean isEmpty(){
        return  size() == 0;
    }

    private void push(int num , boolean isFront){
        BListNode node = new BListNode(num);
        if(isEmpty()){
            front = rear = node;
        }
        else  if ( isFront){
            front.prev = node ;
            node.next = front;
            front = node;
        }
        else {
            rear.next = node;
            node.prev = rear;
            rear = node;

        }
        queSize++;
    }
    public void  pushFirst( int num){
        push(num , true);
    }
    public  void  pushLast(int num){
        push( num , false);
    }
    private int pop(boolean isFront){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        int val;
        if(isFront){
            val = front.val;
            BListNode fNext = front.next;
            if(fNext != null){
                fNext.prev = null;
                front.next = null;
            }
            front = fNext;
        }else{
            val = rear.val;
            BListNode rPrev = rear.prev;
            if(rPrev!=null){
                rPrev.next = null;
                rear.prev = null;
            }
            rear = rPrev;
        }
        queSize --;
        return  val;
    }
    public  int popFirst(){
       return   pop(true);
    }
    public  int popLast(){
        return pop(false);
    }
    public  int peekFirst(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return  front.val;
    }
    public  int peekLast(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return rear.val;
    }
    public int[] toArray(){
        BListNode node = front;
        int[] res = new int[size()];
        for (int i = 0 ; i < res.length ;  i ++){
            res[i] = node.val;
            node = node.next;
        }
        return  res;
    }


}
public class _Deque {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(1);
        deque.offerLast(2);
        /* 访问元素 */
        int peekFirst = deque.peekFirst();  // 队首元素
        int peekLast = deque.peekLast();    // 队尾元素

        /* 元素出队 */
        int popFirst = deque.pollFirst();  // 队首元素出队
        int popLast = deque.pollLast();    // 队尾元素出队

        /* 获取双向队列的长度 */
        int size = deque.size();

        /* 判断双向队列是否为空 */
        boolean isEmpty = deque.isEmpty();

    }
}
