package pro1;

public class Fraction
{
    private long n;
    private long d;

    public Fraction(long n, long d) {
        long gcd = NumericUtils.gcd(n,d);
        this.n = n / gcd;
        this.d = d / gcd;
    }

    public Fraction add(Fraction b){
        long sumN = n * b.d + b.n * d;
        long sumD = d * b.d;
        return new Fraction(
                sumN,
                sumD
        );
    }

    @Override
    public String toString() {
        return n + "/" + d;
    }

    public static Fraction parse(String s)
    {
        String[] split = s.split("\\+");
        Fraction sum = new Fraction(0,1);
        for(String part : split){
            Fraction f;
            if(part.contains("%")){
                String trimmed=part.replace("%","").trim();
                f = new Fraction(
                        Long.parseLong(trimmed),
                        100);
            } else{
                String[] split2 = part.split("/");
                f = new Fraction(
                        Long.parseLong(split2[0].trim()),
                        Long.parseLong(split2[1].trim())
                        );
            }
            sum = sum.add(f);
        }
        return sum;
    }
}
