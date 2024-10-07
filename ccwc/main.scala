import scala.io.Source
import java.io.File



object CcWc {
  val man = """
    Usage: 
    -c retrieve number of bytes of file
    -l number of lines
  """

  def main(args: Array[String]): Unit = {
    if (args.length == 0) println(man)

    def nextArg(map: Map[String, Any], list: List[String]): Map[String, Any] = {
      list match {
        case Nil => map
        case "-c" :: value :: tail =>
          countBytes(value)
          nextArg(map ++ Map("byteSize" -> value), tail)
        case "-l" :: value :: tail =>
          countLine(value)
          nextArg(map ++ Map("lineCount" -> value), tail)
        case "-w" :: value :: tail =>
          countWords(value)
          nextArg(map ++ Map("wordCount" -> value), tail)
        case string :: Nil =>
          nextArg(map ++ Map("filename" -> string), list.tail)
        case unknown :: _ =>
          println("Unknown option " + unknown)
          sys.exit(1)
      }
    }
    val options = nextArg(Map(), args.toList)
    // println(options)

  }

  def countBytes(filename: String): Unit = {
    val file = new File(filename)
    println(s"${file.length()}")
  }

  def countLine(filename: String): Unit = {
    val bufferdSource = Source.fromFile(filename)
    println(bufferdSource.getLines.length)
    bufferdSource.close
  }

  def countWords(filename: String): Unit = {
    val bufferedSource = Source.fromFile(filename)
    var sum = 0

    for (line <- bufferedSource.getLines) {
      // Split the line by spaces (or other whitespace) and filter out empty strings
      val words = line.split("\\s+").filter(_.nonEmpty)
      sum += words.length
    }

    println(sum)
    bufferedSource.close()
  }


}
