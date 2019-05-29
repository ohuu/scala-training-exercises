package day_1

object MutableVector2D {
  def apply(x: Double = 0, y: Double = 0): MutableVector2D = new MutableVector2D(x, y)
  def apply(that: MutableVector2D): MutableVector2D = new MutableVector2D(that)
  def origin: MutableVector2D = MutableVector2D()
}
class MutableVector2D(var x: Double, var y: Double) {
  def this(that: MutableVector2D) {
    this(that.x, that.y)
  }

  def +=(scalar: Double): Unit = {
    x += scalar
    y += scalar
  }
  def -=(scalar: Double): Unit = this += -scalar
  def *=(scalar: Double): Unit = {
    x *= scalar
    y *= scalar
  }
  def /=(scalar: Double): Unit = this *= (1/scalar)

  def +=(that: MutableVector2D): Unit = {
    x += that.x
    y += that.y
  }
  def -=(that: MutableVector2D): Unit = this += MutableVector2D(-that.x, -that.y)
  def *=(other: MutableVector2D): Unit = {
    x *= other.x
    y *= other.y
  }
  def /=(that: MutableVector2D): Unit = this *= MutableVector2D(1/that.x, 1/that.y)

  def ==(other: MutableVector2D): Boolean = x == other.x && y == other.y
  def !=(other: MutableVector2D): Boolean = !(this == other)

  def negate(): Unit = MutableVector2D(-x, -y)
  def magnitude(): Double = math.sqrt(x*x + y*y)
  def normalise(): Unit = this /= magnitude

  def distance(other: MutableVector2D): Double = math.sqrt(math.pow(x - other.x, 2) + math.pow(y - other.y, 2))
}
