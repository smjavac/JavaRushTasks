package алгоритмы;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 100;
        long [] mem = new long[n+1];
        Arrays.fill(mem, -1);
        System.out.println(fibNativ(n, mem));

    }

    public static long fibNativ(int n, long[] mem){
        if (mem[n] != -1)return mem[n];  //мемонизация
        if (n <= 1)return n;
        long result = fibNativ(n -1, mem) + fibNativ(n - 2, mem);
        mem[n] = result;
        return result;
    }

    public static long fibEffective(int n){
        long[] arr = new long[n];
        arr[0]= 0;
        arr[1]= 1;
        for (int i = 2; i <= n; i++)
            arr[i] = arr[i - 1] + arr[i - 2];
        return arr[n];
    }
}
