public class BinarySearch {

    public static int BinarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid; 
            }
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7};
        int target = 4;
        int result = linearSearch(arr, target);

        System.out.println(result == -1 ? "Element not found" : "Element is at index: " + result);
    }
}