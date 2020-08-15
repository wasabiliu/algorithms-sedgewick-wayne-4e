/**
 * 1.2.16
 * Implement an immutable data type Rational for rational numbers that supports 
 * addition, subtraction, multiplication, and division.
 * You do not have to worry about testing for overflow, but use as instance variables
 * two long values that represent the numerator and denominator to limit the 
 * possibility of overflow. Use Euclid's algorithm to ensure that the numerator 
 * and denominator never have any common factors. Include a client that exercises 
 * all of your methods.
 */
public class Exercise16_RationalNumbers {
    static class Rational {
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
            long n = this.numerator * b.denominator + this.denominator * b.numerator;
            long d = this.denominator * b.denominator;
            return new Rational((int) n, (int) d);
        }

        public Rational minus(Rational b) {
            long n = this.numerator * b.denominator - this.denominator * b.numerator;
            long d = this.denominator * b.denominator;
            return new Rational((int) n, (int) d);
        }

        public Rational times(Rational b) {
            long n = this.numerator * b.numerator;
            long d = this.denominator * b.denominator;
            return new Rational((int) n, (int) d);
        }

        public Rational divides(Rational b) {
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
        Rational a = new Rational(12, 36);
        Rational b = new Rational(6, -10);
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        // plus
        System.out.println("a + b:" + a.plus(b));

        // minus
        System.out.println("a - b: " + a.minus(b));

        // times
        System.out.println("a * b: " + a.times(b));

        // divides
        System.out.println("a / b: " + a.divides(b));

        // equals
        System.out.println("a equals b? " + a.equals(b));
    }
}
