package Lesson002;

import java.util.Scanner;

public class Task001 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Введите дробное число ");
        boolean flag = true;
        float number = 0;
        while (flag) {
            try {
                number = sc.nextFloat();
                flag = false;
            } catch (Exception e) {
                sc.next();
                System.out.printf("Что-то пошло не так попробуйте ещё раз ввести дробное число ");
            }
        }
        System.out.println(String.format("Введенное число %f", number));
    }
}
