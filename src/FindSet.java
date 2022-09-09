public class FindSet {

    public static void main(String[] args) {
        int n = 13;
        int i = 2;
        int ans = SettingIndex(n , i);
        System.out.print(ans);
    }

    static int SettingIndex(int n, int i) {
//        Any number OR with 1 will turn it to 1 .
     int newN = (n | (1 << (i - 1)));
     return newN;
    }
}
