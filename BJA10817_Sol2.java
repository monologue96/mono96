package Baekjoon_Algorithm;
import java.util.Arrays;
import java.util.Scanner;

public class BJA10817_Sol2 {
 
    public static void main(String[] args) {
        int[] nums = new int[3];
        int errorcount = 0;
        
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 1 || nums[i] > 100)
                errorcount++;
        }

        if (errorcount < 1){ 
            Arrays.sort(nums);
            System.out.println(nums[1]);
        }
    }
}