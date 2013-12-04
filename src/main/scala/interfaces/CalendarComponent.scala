package interfaces

import java.util.Date

trait CalendarComponent {
  def calendar: Calendar

  trait Calendar {
    def now: Date
  }
}