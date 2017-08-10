package jerimum.fisica

import jerimum.fisica.comum.Vet2
import jerimum.fisica.formas.Forma
import org.jbox2d.dynamics.Body

object Corpo {
  def criar(mundo: Mundo, definicao: DefinicaoCorpo): Corpo = {
    return new Corpo(mundo.world.createBody(definicao.raw))
  }
}

class Corpo protected(protected val body: Body) {
  val _posicao = new Vet2(0, 0)

  def posicao = _posicao.atualizar(body.getPosition())

  def criarMontagem(forma: Forma, densidade: Float) = body.createFixture(forma.raw, densidade)

  def aplicarForca(forca: comum.Vet2, ponto: comum.Vet2) = {
    body.applyForce(forca.raw, ponto.raw)
  }

  def aplicarImpulsoAngular(impulso: Float) = {
    body.applyAngularImpulse(impulso)
  }

  def aplicarForcaAoCentro(forca: comum.Vet2) = {
    body.applyForceToCenter(forca.raw)
  }

  def aplicarImpulsoLinear(impulso: comum.Vet2, ponto: comum.Vet2) = {
    body.applyLinearImpulse(impulso.raw, ponto.raw)
  }
}
