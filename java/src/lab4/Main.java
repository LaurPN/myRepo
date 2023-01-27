package lab4;

import java.util.Arrays;

public class Main {
    public static <T extends Comparable<T>> void sort(T[] arr){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            T key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position arr[j] > key */
            while ((j >= 0) && (arr[j].compareTo(key) > 0)) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args){
        Integer[] arrInt = {1, 3,5636 ,6 ,78, 24};
        sort(arrInt);
        System.out.println("ex2 : ");
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.add(3);
        bt.add(1);
        bt.add(2);
        bt.add(6);
        bt.add(4);
        bt.add(5);
        bt.inorder();
    }
}
