import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        if (proverka(str))
            System.out.println("строка является палиндромом");
        else
            System.out.println("строка не является палиндромом");

    }

    public static boolean proverka(String s){
        Deque<String> deque = new Deque<String>();

        int n = s.length();

        for (int i = 0;i < n;i++){
            deque.addTail(s.substring(0,1));
            s = s.substring(1);
        }

        for (int i = 0; i < n / 2; i++){
            if (!deque.removeFront().equals(deque.removeTail()))
                return false;
        }

        return true;
    }
}
