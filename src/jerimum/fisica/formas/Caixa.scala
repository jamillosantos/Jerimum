package jerimum.fisica.formas

import org.jbox2d.collision.shapes.{PolygonShape, Shape}

object Caixa {
}

case class Caixa(private var _altura: Float, private var _largura: Float) extends Poligono {
  override def createRaw(): Shape = {
    val r = super.createRaw()
    r.asInstanceOf[PolygonShape].setAsBox(_largura, _altura)
    return r
  }

  def altura = _altura

  def altura_=(valor: Float) = {
    _altura = valor
    atualizarCaixa()
  }

  def largura = _largura

  def largura_=(valor: Float) = {
    _largura = valor
    atualizarCaixa()
  }

  private def atualizarCaixa(): Unit = {
    _raw.asInstanceOf[PolygonShape].setAsBox(_largura, _altura)
  }
}