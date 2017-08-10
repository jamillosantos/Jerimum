package jerimum.fisica

import jerimum.fisica.comum.Vet2
import org.jbox2d.dynamics.{BodyDef, BodyType}

object CorpoTipo extends Enumeration {
  val DINAMICO, CINEMATICO, ESTATICO = Value
}

object DefinicaoCorpo {
  def criar(tipo: CorpoTipo.Value, posicao: Vet2): DefinicaoCorpo = {
    val r = new DefinicaoCorpo()
    r.tipo = tipo
    r.posicao = posicao
    return r
  }
}

case class DefinicaoCorpo() {
  private val _definition: BodyDef = new BodyDef()

  def raw = _definition

  def tipo: CorpoTipo.Value = {
    return _definition.`type` match {
      case BodyType.DYNAMIC => CorpoTipo.DINAMICO
      case BodyType.KINEMATIC => CorpoTipo.CINEMATICO
      case _ => CorpoTipo.ESTATICO
    }
  }

  def tipo_=(valor: CorpoTipo.Value) = {
    _definition.`type` = valor match {
      case CorpoTipo.DINAMICO => BodyType.DYNAMIC
      case CorpoTipo.CINEMATICO => BodyType.KINEMATIC
      case _ => BodyType.STATIC
    }
  }

  def dado_=(value: Object) = _definition.userData = value

  def dado: Object = _definition.userData

  def posicao: Vet2 = Vet2.criar(_definition.position)

  def posicao_=(value: Vet2) = _definition.position = value._raw

  def angulo: Float = _definition.angle

  def angulo_=(value: Float) = _definition.angle = value

  def velocidadeLinear: Vet2 = Vet2.criar(_definition.linearVelocity)

  def velocidadeLinear_=(value: Vet2) = _definition.linearVelocity = value._raw

  def velocidadeAngular: Float = _definition.angularVelocity

  def velocidadeAngular_=(value: Float) = _definition.angularVelocity = value

  def amortecimentoLinear: Float = _definition.linearDamping

  def amortecimentoLinear_=(value: Float) = _definition.linearDamping = value

  def amortecimentoAngular: Float = _definition.angularDamping

  def amortecimentoAngular_=(value: Float) = _definition.angularDamping = value

  def dormivel: Boolean = _definition.allowSleep

  def dormivel_=(value: Boolean) = _definition.allowSleep = value

  def acordado: Boolean = _definition.awake

  def acordado_=(value: Boolean) = _definition.awake = value

  def rotacaoFixa: Boolean = _definition.fixedRotation

  def rotacaoFixa_=(value: Boolean) = _definition.fixedRotation = value

  def municao: Boolean = _definition.bullet

  def municao_=(value: Boolean) = _definition.bullet = value

  def escalarGravidade: Float = _definition.gravityScale

  def escalarGravidade_=(value: Float) = _definition.gravityScale = value
}