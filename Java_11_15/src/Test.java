/**
 * @author: LenovoHZB
 * @create: 2024-11-15 下午5:40
 */
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt(), s = 0;
        n = (n / 10 + n % 10) % 5 + 1;
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < n; i++)
            s += a[i] * i;
        System.out.println("s=" + s);
    }
}
