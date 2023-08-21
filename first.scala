class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private val gcdVal = gcd(n.abs, d.abs)
  val numer: Int = n / gcdVal
  val denom: Int = d / gcdVal

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def neg: Rational = new Rational(-numer, denom)

  override def toString: String = {
    if (denom == 1) numer.toString
    else s"$numer/$denom"
  }
}

// Usage
val x = new Rational(3, 4)
val neg_x = x.neg
println(x)      // Output: 3/4
println(neg_x)  // Output: -3/4
