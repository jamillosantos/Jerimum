package jerimum

import java.awt.geom.AffineTransform

import br.edu.ifrn.potigol.Potigolutil.Inteiro

object Transformacoes {
  def inverterVerticalmente(altura: Inteiro): AffineTransform = {
    val r = new AffineTransform()
    r.translate(0, altura)
    r.scale(1, -1)
    return r
  }
}
