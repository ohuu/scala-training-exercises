package day_1

object ImmutableVector2D {
  def apply(x: Double = 0, y: Double = 0): ImmutableVector2D = new ImmutableVector2D(x, y)
  def apply(that: ImmutableVector2D): ImmutableVector2D = ImmutableVector2D(that.x, that.y)
  def origin: ImmutableVector2D = ImmutableVector2D()
}

class ImmutableVector2D(val x: Double, val y: Double) {
  def this(that: ImmutableVector2D) {
    this(that.x, that.y)
  }

  def +(scalar: Double): ImmutableVector2D = ImmutableVector2D(x + scalar, y + scalar)
  def -(scalar: Double): ImmutableVector2D = this + -scalar
  def *(scalar: Double): ImmutableVector2D = ImmutableVector2D(x * scalar, y * scalar)
  def /(scalar: Double): ImmutableVector2D = this * (1 / scalar)

  def +(that: ImmutableVector2D): ImmutableVector2D = ImmutableVector2D(x + that.x, y + that.y)
  def -(that: ImmutableVector2D): ImmutableVector2D = this + -that
  def *(that: ImmutableVector2D): ImmutableVector2D = ImmutableVector2D(x * that.x, y * that.y)
  def /(that: ImmutableVector2D): ImmutableVector2D = ImmutableVector2D(x / that.x, y / that.y)

  def ==(that: ImmutableVector2D): Boolean = x == that.x && y == that.y
  def !=(that: ImmutableVector2D): Boolean = !(this == that)

  def unary_-(): ImmutableVector2D = ImmutableVector2D(-x, -y)

  def magnitude(): Double = math.sqrt(x * x + y * y)
  def normal(): ImmutableVector2D = this / magnitude
  def distance(that: ImmutableVector2D): Double = (this - that).magnitude
  def rotate(theta: Double): ImmutableVector2D = ImmutableVector2D(math.cos(theta), math.sin(theta))
}
