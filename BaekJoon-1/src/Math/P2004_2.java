package Math;

import java.util.Scanner;

//백준 풀이
//for문을 사용해서 2와 5의 거듭제곱을 수의 범위에 맞게 하고 있음.
public class P2004_2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long two = 0, five = 0;
        for (long i=2; i<=n; i*=2) {//분모 n의 2갯수 구하기. i를 제곱해주면서 two에 누적.
            two += n/i;
        }
        for (long i=2; i<=n-m; i*=2) {//분모 n의 2갯수에서 바로바로 빼줌.
            two -= (n-m)/i;
        }
        for (long i=2; i<=m; i*=2) {
            two -= m/i;
        }
        for (long i=5; i<=n; i*=5) {
            five += n/i;
        }
        for (long i=5; i<=n-m; i*=5) {
            five -= (n-m)/i;
        }
        for (long i=5; i<=m; i*=5) {
            five -= m/i;
        }
        System.out.println(Math.min(two,five));
    }
}
