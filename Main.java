public class Main {
    public static void main(String[] args) {
        int[] array = { 124, 14, 5, 674, 3, 14, 636, 876, 9 };
        System.out.print("Массив до сортировки: ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println("");
        array = sort(array);
        System.out.print("Массив после сортировки: ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    public static int[] sort(int arr[]) {
        if (arr.length == 1)
            return arr;
        else {
            int half = (int) Math.floor(arr.length / 2);
            int firstHalf[] = new int[half];
            int secondHalf[] = new int[arr.length - half];
            for (int i = 0; i < arr.length; i++) {
                if (i < half)
                    firstHalf[i] = arr[i];
                else
                    secondHalf[i - half] = arr[i];
            }
            firstHalf = sort(firstHalf);
            secondHalf = sort(secondHalf);
            arr = sortNext(firstHalf, secondHalf);
            return arr;
        }
    }

    public static int[] sortNext(int arr1[], int arr2[]) {
        int sortedArray[] = new int[arr1.length + arr2.length];
        int a = 0, b = 0;
        for (int i = 0; i < arr1.length + arr2.length; i++) {
            if (a == arr1.length) {
                sortedArray[i] = arr2[b];
                b++;
            } else if (b == arr2.length) {
                sortedArray[i] = arr1[a];
                a++;
            } else if (arr1[a] > arr2[b]) {
                sortedArray[i] = arr2[b];
                b++;
            } else {
                sortedArray[i] = arr1[a];
                a++;
            }
        }
        return sortedArray;
    }
}
