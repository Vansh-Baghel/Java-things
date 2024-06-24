package Leetcode.Contest;

public class Number_of_Students_Unable_to_Eat_Lunch {
    public static void main(String[] args) {
        int[] a1 = {0,0,0,1,1,1,1,0,0,0}, a2 = {1,0,1,0,0,1,1,0,0,0};
        System.out.println(countStudents(a1, a2));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int n = students.length, i = 0, j = 0, marked = 0;

        while (marked != n){
            i = i % n;

            if (students[i] == sandwiches[j]){
                students[i] = -1;
                marked++;
            } else {
                int tmpCount = (i + 1) % n;

                while (true){
                    tmpCount %= n;

                    if (tmpCount == i) return n - marked;

                    if (students[tmpCount] == sandwiches[j]) {
                        marked++;
                        students[tmpCount] = -1;
                        i = tmpCount % n;
                        break;
                    }
                    tmpCount++;
                }
            }

            i++;
            j++;
        }

        return n - marked;
    }

    public int countStudents2(int[] students, int[] sandwiches) {
        int[] counts = new int[2];
        for (int student : students) counts[student]++;

        int remaining = sandwiches.length;
        for (int sandwich : sandwiches) {
            if (counts[sandwich] == 0) break;
            if (remaining-- == 0) break;
            counts[sandwich]--;
        }

        return remaining;
    }

}
