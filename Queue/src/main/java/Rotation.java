public class Rotation {
    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        int n = 0;
        while(n < 20){
            int a = (Integer) queue.dequeue();
            System.out.print(a + " ");
            queue.enqueue(a);
            n++;
        }
    }
}
