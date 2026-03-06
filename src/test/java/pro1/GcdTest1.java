package pro1;
import org.junit.jupiter.api.Assertions;

class GcdTest1
{
    @org.junit.jupiter.api.Test
    void test()
    {
        Assertions.assertEquals(
                10,
                NumericUtils.gcd(20,50)
        );

        Assertions.assertEquals(
                1,
                NumericUtils.gcd(1,1)
        );

        Assertions.assertEquals(
                10_000_000_000L,
                NumericUtils.gcd(20_000_000_000L,50_000_000_000L)
        );

        Assertions.assertEquals(
                1,
                NumericUtils.gcd(7919,7907)
        );

        Assertions.assertEquals(
                1,
                NumericUtils.gcd(7907,7919)
        );
    }
}