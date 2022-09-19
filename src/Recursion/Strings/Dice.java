package Recursion.Strings;

public class Dice {
    public static void main(String[] args) {
        dice ("" , 4);
    }

    static void dice(String p, int target) {
        if (target == 0){
            System.out.println(p);
            return;
        }

//        i here is basically the numbers on dice. So as the target the value changes from the recursive call , the value of i also changes accordingly. Like if the p = 12 , i = 2 , target = 1 then i will become 1 to satisfy the condition of for loop and then p + 1 ie 121 will happen.
        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }
}
