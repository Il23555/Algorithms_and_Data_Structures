public class Main {
    public static void main(String[] args) {
        BoundedStack<Integer> stack = new BoundedStack<Integer>(Integer.class, 4);
        System.out.println(stack.size());

        System.out.println(stack.get_peek_status());
        System.out.println(stack.get_push_status());
        System.out.println(stack.get_pop_status());

        while (stack.get_push_status() != 2)
            stack.push(1);
        System.out.println(stack.size());

        while (stack.get_pop_status() != 2)
            stack.pop();
        System.out.println(stack.size());

        System.out.println(stack.peek());
        System.out.println(stack.get_peek_status());
    }
}

