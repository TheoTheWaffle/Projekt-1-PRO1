package pro1;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
class ParsingTest1
{
    @org.junit.jupiter.api.Test
    void test()
    {
        assertEquals(
                "2 / 5",
                Fraction.parse("2/5").toString()
        );
        assertEquals(
                "2 / 5",
                Fraction.parse("2 / 5").toString()
        );
        assertEquals(
                "2 / 5",
                Fraction.parse("40%").toString()
        );
        assertEquals(
                "2 / 5",
                Fraction.parse("1/5+1/5").toString()
        );
        assertEquals(
                "2 / 5",
                Fraction.parse("1/5+20%").toString()
        );
        assertEquals(
                "2 / 5",
                Fraction.parse("10%+10%+10%+10%").toString()
        );
        assertEquals(
                "0 / 1",
                Fraction.parse("0%").toString()
        );
        assertEquals(
                "0 / 1",
                Fraction.parse("0/15").toString()
        );
    }
}