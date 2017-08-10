package jerimum

import br.edu.ifrn.potigol.Potigolutil.Inteiro
import jerimum.fisica.Mundo

object JogoFisica extends Runnable {

  private[this] var fps: Int = 60
  private[this] var threadPhysics: Thread = _
  private[this] var done: Boolean = false

  private[this] var mundo: Option[Mundo] = None

  private[this] var passo: Option[() => {}] = None

  override def run() = {
    println("JogoFisica::run")
    Relogio.atualizarFisica()
    val restricao = 1000f/this.fps/1000f
    while (!done) {
      if (relogio.variacaoFisica >= restricao) {
        if (this.passo.isDefined) {
          this.passo.get()
        } else {
          this.mundo.get.passo(1f/20f, 10, 10)
        }
        Relogio.atualizarFisica()
      }
    }
  }

  def iniciar(mundo: Mundo, fps: Inteiro = 60) = synchronized {
    this.fps = fps
    this.passo = None
    this.mundo = Some(mundo)
    this.done = false
    this.threadPhysics = new Thread(this) {
      start()
    }
  }

  def iniciar(passo: () => {}) = synchronized {
    this.passo = Some(passo)
    this.mundo = None
    this.done = false
    this.threadPhysics = new Thread(this) {
      start()
    }
  }

  def parar() = synchronized {
    this.done = true
  }
}
