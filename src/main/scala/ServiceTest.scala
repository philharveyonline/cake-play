import interfaces.ServiceComponent
import impl.DefaultServiceComponent
import interfaces.JmsConfigComponent
import interfaces.CalendarComponent
import impl.DefaultJmsConfigComponent
import impl.DefaultCalendarComponent
import java.util.Date

object TestSuite extends App {
  val s = new ServiceTest
  s.test
}

class ServiceTest {

  /**
   * Uses a dummy business logic component
   */
  class ServiceToTest
      extends DefaultServiceComponent // the thing we're actually testing
      with DummyBusinessLogicComponent
      with DefaultJmsConfigComponent
      with DefaultCalendarComponent {

    override val jmsConfig = new DefaultJmsConfig
    override val calendar = new DefaultCalendar(new Date(0))
    override val service = new DefaultService
  }

  def test = {
    println("testing it")
    val s = new ServiceToTest
    s.service.runService
  }
}