package impl

import interfaces.CalendarComponent
import java.util.Date

trait DefaultCalendarComponent extends CalendarComponent {

  case class DefaultCalendar(d: Date) extends Calendar {
    override def now = d
  }
}