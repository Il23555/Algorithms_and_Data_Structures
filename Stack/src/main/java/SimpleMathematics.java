/*  Функцию, которая с помощью двух стеков реализует вычисление постфиксных выражений.
Постфиксная запись выражения -- это запись, в которой порядок вычислений определяется не скобками и приоритетами, а только позицией элемента в выражении.
Например, в выражениях разрешено использовать целые числа и операции + и * .Тогда выражение (1 + 2) * 3   запишется как   1 2 + 3 *
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleMathematics {
    public static void main(String[] args) throws IOException {
        Stack problem = readString();
        Stack result = new Stack();

        while(problem.size() > 0){
            String s = (String) problem.pop();
            if (checkString(s))
                result.push(Integer.parseInt(s));
            else {
                if (!s.equals("=") && (!s.equals(" "))) {
                    int a = (Integer) result.pop();
                    int b = (Integer) result.pop();
                    int c = res(a, b, s);
                    result.push(c);
                }
            }
        }

        System.out.println("Ответ : " + result.pop());
    }

    public static boolean checkString(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static int res(int a, int b, String s){
        if (s.equals("+"))
            return a+b;
        if (s.equals("*"))
            return a*b;
        return 0;
    }

    public static Stack readString() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        Stack stack = new Stack();

        while (!str.equals("")) {
            String c = str.substring(str.length() - 1);
            stack.push(c);
            str = str.substring(0,str.length()-1);
        }

        return stack;
    }
}
