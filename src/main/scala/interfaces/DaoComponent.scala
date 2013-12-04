package interfaces

trait DaoComponent {
  def dao: Dao

  trait Dao {
    def save(s: String)
  }
}