public class StringChar {
    public static void main(String[] args) {
        String name = "Vansh";
        char target = 'a';
        boolean ans = searchLetter(name, target);
        System.out.println(ans);
    }
        static boolean searchLetter(String name , char target){
            for (char ch : name.toCharArray()) {
                if (ch == target) {
                    return true;
                }
        }
            return false;
        }
}
