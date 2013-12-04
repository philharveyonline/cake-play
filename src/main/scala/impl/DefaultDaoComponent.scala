package impl

import interfaces.DaoComponent

trait DefaultDaoComponent extends DaoComponent {

  override val dao = new DefaultDao

  class DefaultDao extends Dao {
    override def save(s: String) = println(s"saving $s")
  }
}