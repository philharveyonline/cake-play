import impl.SavingBusinessLogicComponent
import impl.DefaultDaoComponent
import impl.DefaultJmsConfigComponent
import impl.DefaultServiceComponent
import impl.DefaultCalendarComponent
import java.util.Date

object ComponentRegistry
    extends DefaultServiceComponent
    with DefaultJmsConfigComponent
    with SavingBusinessLogicComponent
    with DefaultDaoComponent
    with DefaultCalendarComponent {

  override val service = new DefaultService
  override val jmsConfig = new DefaultJmsConfig


  private val persistingBusinessLogic = new PersistingBusinessLogic

  override def businessLogic = {
    println(s"Returning $persistingBusinessLogic")
    persistingBusinessLogic
  }


  override val calendar = new DefaultCalendar(new Date)
}