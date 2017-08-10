package jerimum.fisica.formas

import org.jbox2d.collision.shapes.{PolygonShape, Shape}

class Poligono extends Forma {
  def createRaw(): Shape = new PolygonShape()
}