package jerimum.fisica

import jerimum.fisica.comum.Vet2
import org.jbox2d.dynamics.{BodyDef, BodyType}

object CorpoTipo extends Enumeration {
  val DINAMICO = BodyType.DYNAMIC
  val DINÂMICO = BodyType.DYNAMIC
  val CINEMATICO = BodyType.KINEMATIC
  val CINEMÁTICO = BodyType.KINEMATIC
  val ESTATICO = BodyType.STATIC
  val ESTÁTICO = BodyType.STATIC
}

class DefinicaoCorpo {
  private val _definition: BodyDef = new BodyDef()

  def tipo: CorpoTipo.Value = {
    return _definition.`type` match {
      case BodyType.DYNAMIC => CorpoTipo.DINAMICO
      case BodyType.KINEMATIC => CorpoTipo.CINEMATICO
      case _ => CorpoTipo.ESTATICO
    }
  }

  def dado_=(value: Object) = _definition.userData = value

  def dado: Object = _definition.userData

  def dado_=(value: Object) = _definition.userData = value

  def posicao: Vet2 = _definition.position

  def posicao_=(value: Vet2) = _definition.position = value

  def angulo: Float = _definition.angle

  def angulo_=(value: Float) = _definition.angle = value

  def velocidadeLinear: Vet2 = _definition.linearVelocity

  def velocidadeLinear_=(value: Vet2) = _definition.linearVelocity = value

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