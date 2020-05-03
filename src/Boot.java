import java.util.Random;

public class Boot {
    public static void main(String[] args) {
        int[][] arrayGerado = Boot.geraArrays(10);
        for (int i : arrayGerado[0]) {
            System.out.println(i);
        }
        System.out.println("-------------------");
        heapSort(arrayGerado[0]);
        for (int i : arrayGerado[0]) {
            System.out.println(i);
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arrayDesorganizado) {
        for (int i = 0; i < arrayDesorganizado.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arrayDesorganizado.length; j++) {
                if (arrayDesorganizado[j] < arrayDesorganizado[index]) {
                    index = j;
                }
            }
            int smallerNumber = arrayDesorganizado[index];
            arrayDesorganizado[index] = arrayDesorganizado[i];
            arrayDesorganizado[i] = smallerNumber;
        }
    }

    public static void bubbleSort(int[] arr) {
        int aux = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
    }

    public static int[][] geraArrays(int quantidadeDeElementos) {
        int[][] arraysGerados = new int[50][quantidadeDeElementos];

        for (int j = 0; j < 50; j++) {
            for (int i = 0; i < quantidadeDeElementos; i++) {
                Random random = new Random();
                arraysGerados[j][i] = random.nextInt(300);
            }
        }
        return arraysGerados;
    }


    public static void heapSort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

}
