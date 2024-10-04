import java.time.format.{DateTimeFormatter, FormatStyle}
import java.time.LocalDate
import java.util.Locale._

object FrenchDate {
  def main(args: Array[String]): Unit = {
    val now = LocalDate.now
    val df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(FRANCE)
    println(df.format(now))
  }
}
