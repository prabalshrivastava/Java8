package interview.tiaa;

public class LogExample {
    public static void main(String[] args) {
        double number = 100;

        double result = Math.log10(number);

        System.out.println("The base-10 logarithm of " + number + " is: " + result);
        System.out.println(findNumbers(new int[]{12, 345, 2, 6, 7896}));
    }
    public static int findNumbers(int[] nums) {
        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (((int) Math.log10(nums[i])) % 2 == 0)
//                count++;
//        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Math.log10(nums[i]) : " + nums[i] + " - " + ((int) Math.log10(nums[i])));
            count += ((int) Math.log10(nums[i])) % 2;
        }
        return count;
    }
}
