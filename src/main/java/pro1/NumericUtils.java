package pro1;

public class NumericUtils
{
    public static long gcd(long a, long b)
    {
        long p = a;
        long q = b;
        while(q!=0) {
            long oldP = p;
            p = q;
            q = oldP % q;
        }
        return p;
    }
}
