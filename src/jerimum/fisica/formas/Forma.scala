package jerimum.fisica.formas

import org.jbox2d.collision.shapes.Shape

abstract class Forma {
  val _raw = createRaw()

  def createRaw(): Shape

  def raw = _raw
}