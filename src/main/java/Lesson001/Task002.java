package Lesson001;

import java.util.Arrays;

public class Task002 {
    public static double[] divElements(double[] arr1, double[] arr2) throws Exception {
        if (arr1.length != arr2.length) throw new Exception("Разные длины массивов");
        double[] res = new double[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) throw new Exception("Во втором массиве есть нулевые элементы");
            res[i] = arr1[i] / arr2[i];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        double[] arr1 = new double[] {1.0, 2.0, 3.0};
//        double[] arr1 = new double[] {1.0, 2.0, 3.0, 4.0};
//        double[] arr2 = new double[] {0.0, 9.0, 8.0, 7.0};
        double[] arr2 = new double[] {10.0, 5.0, 4.0, 2.0};
        System.out.println(Arrays.toString(divElements(arr1, arr2)));
    }
}
