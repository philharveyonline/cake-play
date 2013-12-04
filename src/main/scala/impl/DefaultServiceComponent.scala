package impl

import interfaces.BusinessLogicComponent
import interfaces.JmsConfigComponent
import interfaces.ServiceComponent
import interfaces.CalendarComponent

trait DefaultServiceComponent extends ServiceComponent {
  this: BusinessLogicComponent with JmsConfigComponent with CalendarComponent =>

  class DefaultService extends Service {
    protected def initialise = {
      println(s"Initialised service with config ${jmsConfig}")
    }

    def publishMessage = {
      println(s"About to publish to ${jmsConfig.queueName}")
    }

    def runService = {
      println(s"Service started at ${calendar.now}")
      businessLogic.doStuff
      publishMessage
    }
  }
}