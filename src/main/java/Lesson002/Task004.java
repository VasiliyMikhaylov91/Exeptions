package Lesson002;

import java.util.Scanner;

public class Task004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = null;
        boolean flag = true;
        System.out.println("Введите строку ");
        while (flag) {
            try {
                str = sc.nextLine();
                if ("".equals(str)) { throw new Exception("Пустые строки вводить нельзя"); }
                flag = false;
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Попробуйте ещё раз");
            }
        }
        System.out.println(String.format("Вы ввели %s", str));
    }
}
