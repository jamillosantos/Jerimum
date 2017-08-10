package exemplo.fisica

import jerimum._
import jerimum.fisica._
import jerimum.fisica.comum.Vet2
import jerimum.fisica.formas.Caixa

object Piramide extends App {

  case class Bloco(mundo: Mundo) {

    val corpo = mundo.criarCorpo(DefinicaoCorpo.criar(CorpoTipo.DINAMICO, Vet2(100, 500)))
    val forma = Caixa(20, 20)
    corpo.criarMontagem(forma, 1f)

    def atualizar(): Unit = {
      // corpo.posicao += new Vet2(0, 1)
    }

    var dy = 0

    def desenhe() = {
      Desenho.incluir(0, g => {
        // g.translate(corpo.posicao.x, dy)
        dy += 1
        g.drawRect(100, -10 + dy, 20, 20)
      })
    }
  }

  case class Estrela() {
  }

  val mundo = Mundo(Gravidade.terra)

  val bloco = Bloco(mundo)

  def atualize() = {
    bloco.atualizar()
  }

  def desenhe() = {
    bloco.desenhe()
  }

  val altura = 480

  jogo.iniciar("Piramide", 640, altura, atualize, desenhe, 60, Transformacoes.inverterVerticalmente(altura))
  // jogoFisica.iniciar(mundo)
}
