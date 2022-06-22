class Pair{

    //num Pair class to wrap immutable primitive integers
    public int max, min;
    public Pair(int max, int min){
        this.max = max;
        this.min = min;
    }
}
public class Main {

    //Divide and conquer solution to find the minimum ana maximum number in an array
    public static void findMinAndMax(int[] num, int left, int right, Pair p) {

        //If the array contains only one elements
        if(left == right){ // common comparison
            if(p.max < num[left]){ // comparison 1
                p.max = num[left];
            }
            if (p.min > num[right]){ // comparison 2
                p.min = num[right];
            }
            return;
        }

        //If the array contains only two elements
        if (right - left ==  1){ // common comparison
            if (num[left] < num[right]){ // comparison 1
                if (p.min > num[left]){ // comparison 2
                    p.min = num[left];
                }
                if (p.max < num[right]){ //comparison 3
                    p.max = num[right];
                }
            }else {
                if (p.min > num[right]){ // comparison 2
                    p.min = num[right];
                }
                if (p.max < num[left]){ // comparison 3
                    p.max = num[left];
                }
            }
            return;
        }

        // find the middle element
        int mid = (left + right)/2;

        //recur for the left subarray
        findMinAndMax(num, left, mid, p);

        //recur for the right subarray
        findMinAndMax(num, mid + 1, right, p);

    }

    public static void main(String[] args) {
        int [] num = {7, 2, 9, 3, 1, 6, 7, 8, 4};
        Pair p = new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
        findMinAndMax(num, 0, num.length - 1, p);

        System.out.println("The minimum array is "+ p.min);
        System.out.println("The maximum array is "+ p.max);
    }
}
