public class Rotation {
    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        int n = 8;
        rotation(queue,n);
        
        print(queue);
    }

    public static void print(Queue queue){
        while(queue.size() > 0){
            System.out.print((queue.dequeue()).toString() + " ");
            System.out.println();
        }
    }

    public static void rotation(Queue queue, int n){
        for(int i = 0; i < n; i++) {
            int a = (Integer) queue.dequeue();
            queue.enqueue(a);
        }
    }

}
