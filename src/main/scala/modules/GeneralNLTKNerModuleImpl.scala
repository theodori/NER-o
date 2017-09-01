package modules
import ner.modules.NerModule

class GeneralNLTKNerModuleImpl (cmd:String) extends NerModule{

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
