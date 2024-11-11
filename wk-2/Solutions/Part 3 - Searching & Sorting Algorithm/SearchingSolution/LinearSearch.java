public class LinearSearch{

    public static int linearSearch(int[] arrr, int target){
        for(int i=0; i<arrr.length; i++){
            if(arrr[i] == target){
                return i;
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
