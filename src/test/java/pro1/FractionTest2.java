

package pro1;
import static org.junit.jupiter.api.Assertions.assertEquals;
class FractionTest2
{
    @org.junit.jupiter.api.Test
    void test()
    {
        assertEquals(
                "2 / 5",
                new Fraction(400,1000).toString()
        );
    }
}

