package modules
import ner.modules.NerModule

// it is required to have installed python
class GeneralNLTKNerModuleImpl () extends NerModule{
  val cmd="python " + getClass.getResource("/ne_chunk.py").getPath
  override def process(input: String): Some[String] = {
    println(input)
    println(cmd)
    val result: (Int, String, String) =runCommand(cmd, Some(input))
    result._1 match{
      case 0 =>
              Some(result._2)
      case _ =>
              println(result._3)
              throw new RuntimeException(result._3)
    }

    }


}
