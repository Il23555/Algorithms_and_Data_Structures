public class Main {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.addInTail(new Node(3));
        list1.addInTail(new Node(5));
        list1.addInTail(new Node(7));
        list1.addInTail(new Node(9));

        for (int i = 0; i< 4;i++) list2.addInTail(new Node(1));

        LinkedList list = merger(list1,list2);
        list.printList();

    }


    public static LinkedList merger(LinkedList list1,LinkedList list2){
        LinkedList list = new LinkedList();

        if (list1.count() == list2.count()) {
            int size = list1.count();

            Node node1 = list1.head;
            Node node2 = list2.head;

            for (int i = 0; i < size; i++) {
                Node node = new Node(node1.value + node2.value);
                list.addInTail(node);
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        return list;
    }
}
