package pro1;
import static org.junit.jupiter.api.Assertions.assertEquals;
class FractionTest3
{
    @org.junit.jupiter.api.Test
    void test()
    {
        assertEquals(
                "1 / 5",
                new Fraction(1,10).add(new Fraction(1,10)).toString()
        );
        assertEquals(
                "1 / 2",
                new Fraction(1,3).add(new Fraction(1,6)).toString()
        );
        assertEquals(
                "1 / 3",
                new Fraction(1,2).add(new Fraction(-1,6)).toString()
        );
    }
}