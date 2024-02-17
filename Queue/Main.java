package Queue;

public class Main {
 public static void main(String[] args) {
   var queue = new LinkedListQueue();
   queue.enqueue(10);
   queue.enqueue(20);
   queue.enqueue(30);
   queue.enqueue(40);
   queue.enqueue(50);

   System.out.println(queue.dequeue());


   System.out.println(queue);
 }
}
