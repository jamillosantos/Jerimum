package jerimum.fisica

import jerimum.fisica.comum.Vet2
import org.jbox2d.dynamics.World

object Mundo {
}

case class Mundo(g: Vet2) {
  val world = new World(g.raw)

  def gravidade: Vet2 = Vet2.criar(world.getGravity())

  def gravidade_=(valor: Vet2) = world.setGravity(valor.raw)

  def criarCorpo(definicao: DefinicaoCorpo) = {
    Corpo.criar(this, definicao)
  }

  def passo(tempo: Float, iteracoesDeVelocidade: Int, iteracoesDePosicao: Int) = {
    world.step(tempo, iteracoesDeVelocidade, iteracoesDePosicao)
  }
}
