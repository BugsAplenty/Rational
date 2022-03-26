public class Rational {
    private final int denominator;
    private final int numerator;

    public Rational(int numerator, int denominator) {
        if (denominator < 0) {
            throw new IllegalArgumentException("Denominator must be positive.");
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }
    public boolean greaterThan(Rational other) {
        return this.getNumerator() * other.getDenominator() > other.getNumerator() * this.getDenominator();
    }
    public boolean equals(Rational other) {
        return this.getNumerator() * other.getDenominator() == other.getNumerator() * this.getDenominator();
    }
    public Rational plus(Rational other) {
        int numeratorSum = this.getNumerator() * other.getDenominator() + this.getDenominator() * other.getNumerator();
        int denominatorSum = this.getDenominator() * other.getDenominator();
        return new Rational(numeratorSum, denominatorSum);
    }
    public Rational minus(Rational other) {
        int numeratorDiff = this.getNumerator() * other.getDenominator() - this.getDenominator() * other.getNumerator();
        int denominatorDiff = this.getDenominator() * other.getDenominator();
        return new Rational(numeratorDiff, denominatorDiff);
    }
    public Rational multiply(Rational other) {
        int numeratorProd = this.getNumerator() * other.getNumerator();
        int denominatorProd = this.getDenominator() * other.getDenominator();
        return new Rational(numeratorProd, denominatorProd);
    }
    public Rational divide(Rational other) {
        Rational otherInverse = new Rational(other.getDenominator(), other.getNumerator());
        return this.multiply(otherInverse);
    }
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    @Override
    public String toString() {
        return this.getNumerator() + "/" + this.getDenominator();
    }
    public Rational reduce() {
        int gcd = gcd(this.getNumerator(), this.getDenominator());
        return new Rational(this.getNumerator() / gcd, this.getDenominator() / gcd);
    }

    private static int gcd(int a, int b) {
        while (b!=0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
