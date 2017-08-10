package jerimum.fisica.comum

import org.jbox2d.common.Vec2

object Vet2 {
  def zero = new Vet2(0, 0)

  def criar(vec2: Vec2) = Vet2(vec2.x, vec2.y)

  def produtoInterno(a: Vet2, b: Vet2) = Vec2.dot(a._raw, b._raw)

  def multiplicacaoCruzada(a: Vet2, b: Vet2) = Vec2.cross(a._raw, b._raw)

  def multiplicacaoCruzada(a: Vet2, b: Float) = Vec2.cross(a._raw, b)

  def multiplicacaoCruzada(a: Float, b: Vet2) = Vec2.cross(a, b._raw)
}

case class Vet2(_x: Float, _y: Float) {
  var _raw = new Vec2(_x, _y)

  def raw = _raw

  def x = _raw.x

  def x_=(valor: Float) = _raw.x = valor

  def y = _raw.y

  def y_=(valor: Float) = _raw.y = valor

  def abs = Vet2.criar(_raw.abs())

  def tamanho = _raw.length()

  def tamanhoAoQuadrado = _raw.lengthSquared()

  def +(b: Vet2) = Vet2.criar(_raw.add(b._raw))

  def +=(b: Vet2) = _raw.addLocal(b._raw)

  def -(b: Vet2) = Vet2.criar(_raw.sub(b._raw))

  def -=(b: Vet2) = _raw.subLocal(b._raw)

  def *(b: Vet2) = Vec2.cross(_raw, b._raw)

  def *(b: Float) = Vet2.criar(_raw.mul(b))

  def *=(b: Float) = Vet2.criar(_raw.mulLocal(b))

  def normalizar() = _raw.normalize()

  def atualizar(vec: Vec2): Vet2 = {
    this._raw = vec
    return this
  }
}
