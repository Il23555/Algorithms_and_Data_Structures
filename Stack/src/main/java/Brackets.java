/*Напишите функцию, которая получает на вход строку, состоящую из открывающих и закрывающих скобок, например, "(()((())()))"
и, используя только стек и оператор цикла, определите, сбалансированы ли скобки в этой строке.
Сбалансированной считается последовательность, в которой каждой открывающей обязательно соответствует закрывающая,
а каждой закрывающей -- открывающая скобки, то есть последовательности "())(" , "))((" или "((())" будут несбалансированы.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Brackets {
    public static void main(String[] args) throws IOException{
        Stack stack = readString();

        int close = 0, open = 0, err = 0;

        while ((stack.size() > 0) && (err == 0)){
            String s = (String) stack.pop();

            if (s.equals(")"))
                close++;

            if (s.equals("(")){
                if (open >= close)
                    err++;
                else
                    open++;
            }
        }

        if ((err == 0)&&(open == close))
            System.out.println("строка сбалансирована, кол-во скобок равно = " + open);
        else
            System.out.println("строка не сбалансирована");
    }

    public static Stack readString() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack();
        String str = reader.readLine();
        while(!str.equals("")){
            String c = str.substring(0,1);
            stack.push(c);
            str = str.substring(1);
        }
        return stack;
    }



}
