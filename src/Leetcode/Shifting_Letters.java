package Leetcode;

public class Shifting_Letters {
    public static void main(String[] args) {
        String str = "bad";
        int[] a = {10,20,30};
        String ans = shiftingLetters(str, a);
        System.out.println(ans);
//        int asciiCode = 128-25;
//        char alphabetLetter = (char) asciiCode;
//        System.out.println(alphabetLetter);
    }
    static String shiftingLetters(String s, int[] shifts) {
        StringBuilder ans = new StringBuilder();
        char[] arr = s.toCharArray();

        int shiftSum = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            shiftSum = (shiftSum + shifts[i]) % 26;
            arr[i] = (char) (((arr[i] - 'a' + shiftSum) % 26) + 'a');
        }

        for (int i = 0; i < arr.length; i++) {
            ans.append(arr[i]);
        }

        return ans.toString();
    }

    private static char shift(char ch, int i) {
            int val = ch + i;
            if (val < 97) return ((char) (ch + i + 26));
            else if (val > 122) return ((char) (ch + i - 26 % 26));
            return ((char)(ch + i));
    }
}
