package pro1;
import  org.junit.jupiter.api.Assertions;

class FractionTest1
{
    @org.junit.jupiter.api.Test
    void test()
    {
        Assertions.assertEquals(
                "72 / 150",
                new Fraction(72,150).toString()
        );
    }
}