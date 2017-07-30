import java.util.Scanner;

public class LengthSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Please enter a string: ");
        String s = in.next();
        System.out.printf("Please enter a second string: ");
        String s2 = in.next();
        System.out.printf("The first string has length %d.\n", s.length());
        System.out.printf("The second string has length %d.\n", s2.length());
        System.out.printf("The sum of the two lengths is %d.\n", s.length() + s2.length());
    }
    
}
