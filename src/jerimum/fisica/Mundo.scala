package jerimum.fisica

import jerimum.fisica.comum.Vet2
import org.jbox2d.dynamics.World

class Mundo(g:Vet2) {
  val world = new World(g)

  def gravidade():Vet2 = world.getGravity()

  def criarCorpo(definicao:DefinicaoCorpo)
}
