package Lesson003;

import java.io.FileWriter;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные в формате\n" +
                "Фамилия Имя Отчество Дата_рождения Номер_телефона Пол\n" +
                "Фамилия, Имя, Отчество - строчкой\n" +
                "Дата рождения - dd.mm.yyyy\n" +
                "Номер телефона - целое беззнаковое число\n" +
                "Пол символ - f или m"
        );
        boolean flag = true;
        String lastName = null;
        String firstName = null;
        String secondName = null;
        String birthDate = null;
        int telephoneNumber = 0;
        char gender = 'n';
        String input = sc.nextLine();
        while (flag) {
            try (FileWriter fw = new FileWriter(input.substring(0, input.indexOf(" ")), true)) {
                String[] arr = input.split(" ");
                if (arr.length != 6) {
                    throw new Exception("Введены не все данные");
                }
                lastName = arr[0];
                if (isStringLetter(lastName)) {
                    throw new Exception("Фамилия может содержать только буквы");
                }
                firstName = arr[1];
                if (isStringLetter(firstName)) {
                    throw new Exception("Имя может содержать только буквы");
                }
                secondName = arr[2];
                if (isStringLetter(secondName)) {
                    throw new Exception("Отчество может содержать только буквы");
                }
                birthDate = arr[3];
                if (checkBirthDate(birthDate)) {
                    throw new Exception("Неверный формат ввода даты рождения");
                }
                if (!isStringDigits(arr[4])) {
                    throw new Exception("Номер телефона может содержать только цифры");
                }
                telephoneNumber = Integer.parseInt(arr[4]);
                if (arr[5].length() > 1) {
                    throw new Exception("Пол должен состоять из одного символа");
                }
                if (!(arr[5].charAt(0) == 'f' || arr[5].charAt(0) == 'm')) {
                    throw new Exception("Символ пола может быть f или m");
                }
                gender = arr[5].charAt(0);
                fw.write(String.format("%s %s %s %s %d %c\n",
                        lastName,
                        firstName,
                        secondName,
                        birthDate,
                        telephoneNumber,
                        gender)
                );
                flag = false;
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Попробуйте ещё раз");
                sc.next();
            }
        }
    }

    private static boolean checkBirthDate(String birthDate) {
        boolean check1 = false;
        boolean check2 = false;
        check1 = birthDate.charAt(2) != '.'
                || birthDate.charAt(5) != '.'
                || birthDate.length() != 10;
        for (int i = 0; i < birthDate.length(); i++) {
            if (i == 2 || i == 5) {
                continue;
            }
            if (!Character.isDigit(birthDate.charAt(i))) {
                check2 = true;
                break;
            }
        }
        return check1 || check2;
    }

    private static boolean isStringLetter(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isStringDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
