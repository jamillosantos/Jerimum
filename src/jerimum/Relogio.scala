package jerimum

import java.time.{Duration, Instant}
import java.util.Date

import br.edu.ifrn.potigol.Potigolutil.{Inteiro, Real}

object Relogio {
  private[this] val inicio = new Date(1, 1, 2000).getTime;

  def agora: Real = new Date().getTime

  var instanteAtualizado = Instant.now()

  var instanteAtualizadoFisica = Instant.now()

  def milisegundos: Inteiro = (System.currentTimeMillis() - inicio).toInt

  /**
    * Segundos decorridos desde a última atualização.
    *
    * @return
    */
  def variacao: Float = Duration.between(instanteAtualizado, Instant.now()).toMillis() / 1000f

  def atualizar() = instanteAtualizado = Instant.now()

  def variacaoFisica: Float = Duration.between(instanteAtualizadoFisica, Instant.now()).toMillis() / 1000f

  def atualizarFisica() = instanteAtualizadoFisica = Instant.now()
}