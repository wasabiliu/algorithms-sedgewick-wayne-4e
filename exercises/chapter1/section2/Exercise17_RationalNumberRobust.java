/**
 * 1.2.17
 * Use assertions to develop an implementation of Rational that is immune to overflow.
 * Set -ea flag to enable assertion.
 */
public class Exercise17_RationalNumbersRobust {
    static class Rational {
        private final static String ASSERT_AVOIDING_OVERFLOW = "FATAL: Operation would cass OVERFLOW";

        private long numerator;
        private long denominator;

        public Rational(int numerator, int denominator) {
            if (denominator == 0) throw new IllegalArgumentException("Denominator can't be 0");
            int gcd = Math.abs(gcd(numerator, denominator));

            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;

            if (denominator < 0) {
                this.numerator *= -1;
                this.denominator *= -1;
            }
        }

        public Rational plus(Rational b) {
            assert this.numerator * b.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW;
            assert this.numerator * b.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW;
            assert this.denominator * b.numerator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW;
            assert this.denominator * b.numerator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW;

            long n = this.numerator * b.denominator + this.denominator * b.numerator;
            long d = this.denominator * b.denominator;
            return new Rational((int) n, (int) d);
        }

        public Rational minus(Rational b) {
            assert this.numerator * b.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW;
            assert this.numerator * b.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW;
            assert this.denominator * b.numerator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW;
            assert this.denominator * b.numerator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW;

            long n = this.numerator * b.denominator - this.denominator * b.numerator;
            long d = this.denominator * b.denominator;
            return new Rational((int) n, (int) d);
        }

        public Rational times(Rational b) {
            assert this.numerator * b.numerator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW;
            assert this.numerator * b.numerator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW;
            assert this.denominator * b.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW;
            assert this.denominator * b.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW;

            long n = this.numerator * b.numerator;
            long d = this.denominator * b.denominator;
            return new Rational((int) n, (int) d);
        }

        public Rational divides(Rational b) {
            assert this.numerator * b.denominator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW;
            assert this.numerator * b.denominator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW;
            assert this.denominator * b.numerator <= Integer.MAX_VALUE : ASSERT_AVOIDING_OVERFLOW;
            assert this.denominator * b.numerator >= Integer.MIN_VALUE : ASSERT_AVOIDING_OVERFLOW;

            long n = this.numerator * b.denominator;
            long d = this.denominator * b.numerator;
            return new Rational((int) n, (int) d);
        }

        public boolean equals(Object x) {
            if (this == x) return true;
            if (x == null) return false;
            if (this.getClass() != x.getClass()) return false;
            Rational that = (Rational) x;
            if (this.numerator != that.numerator) return false;
            if (this.denominator != that.denominator) return false;
            return true;
        }

        public String toString() {
            return numerator + "/" + denominator;
        }

        private int gcd(int p, int q) {
            if (q == 0) return p;
            return gcd(q, p % q);
        }
    }

    public static void main(String[] args) {
        Rational a = new Rational(Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1);
        Rational b = new Rational(Integer.MAX_VALUE - 4, Integer.MAX_VALUE - 3);
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        // minus
        System.out.println(a.minus(b));
    }
}
