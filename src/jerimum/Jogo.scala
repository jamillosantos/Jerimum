package jerimum

import java.awt.Graphics2D
import java.awt.geom.AffineTransform

import scala.util.{Failure, Try}
import br.edu.ifrn.potigol.Potigolutil.{Inteiro, Real, Texto}
import jerimum.fisica.Mundo

object Jogo extends Runnable {
  var transformacao: Option[AffineTransform] = None

  var titulo: Texto = "Sem Nome"
  var largura: Inteiro = 640
  var altura: Inteiro = 480
  var fps: Inteiro = 60
  private[this] var display: Tela = _
  private[this] var running = false
  private[this] var thread: Thread = _

  private[this] var desenhe, atualize = () => {}

  private[this] def init() = {
    display = new Tela(titulo, largura, altura) {
      frame.addKeyListener(Teclado)
      frame.addMouseListener(Mouse)
      frame.addMouseMotionListener(Mouse)
      canvas.addMouseListener(Mouse)
      canvas.addMouseMotionListener(Mouse)
    }
  }

  private[this] def draw() = {
    Option(display.canvas.getBufferStrategy) match {
      case None =>
        display.canvas.createBufferStrategy(3)
      case Some(strategy) => strategy.getDrawGraphics match {
        case g: Graphics2D =>
          g.clearRect(0, 0, largura, altura)
          if (this.transformacao.isDefined) {
            g.setTransform(this.transformacao.get)
          }
          Desenho.desenhe(g)
          strategy.show
          g.dispose()
      }
    }
  }

  override def run() = {
    init()
    val restricao = 1000f/this.fps/1000f
    Relogio.atualizar()
    atualize()
    draw()
    desenhe()
    while (running) {
      if (relogio.variacao >= restricao) {
        atualize()
        draw()
        desenhe()
        Relogio.atualizar()
      }
    }
    parar()
  }

  def iniciar(titulo: Texto = "Potigol com Jerimum", largura: Inteiro = 640,
              altura: Inteiro = 480, atualize: => Unit = {},
              desenhe: => Unit = {}, fps: Inteiro = 60, transformacao: AffineTransform = null) = synchronized {
    this.titulo = titulo
    this.largura = largura
    this.altura = altura
    this.fps = fps
    this.atualize = atualize _
    this.desenhe = desenhe _
    if (transformacao != null) {
      this.transformacao = Some(transformacao)
    }
    if (!running) {
      running = true
      thread = new Thread(this) {
        start()
      }
    }
  }

  private[this] def parar() = synchronized {
    if (running) {
      running = false
      Try(thread.join()) match {
        case Failure(e) => e.printStackTrace()
        case _ =>
      }
    }
  }

  def distância(x1: Real, y1: Real, x2: Real, y2: Real): Real = {
    Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))
  }

  val distancia = distância _

  def projeção_X(angulo: Real, valor: Real): Real = {
    Math.sin(angulo * Math.PI / 180) * valor

  }

  def projeção_Y(angulo: Real, valor: Real): Real = {
    -Math.cos(angulo * Math.PI / 180) * valor
  }

  val projecao_X = projeção_X _
  val projeçao_X = projeção_X _
  val projecão_X = projeção_X _
  val projecao_Y = projeção_Y _
  val projeçao_Y = projeção_Y _
  val projecão_Y = projeção_Y _

}