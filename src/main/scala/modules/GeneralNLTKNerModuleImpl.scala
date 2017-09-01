package modules

import java.util

import ner.modules.NerModule
import scala.collection.JavaConverters._

// it is required to have installed python
class GeneralNLTKNerModuleImpl() extends NerModule {
  val cmd = "python " + getClass.getResource("/ne_chunk.py").getPath

  override def process(input: String): Some[String] = {
    val result: (Int, String, String) = runCommand(cmd, Some(input))
    result._1 match {
      case 0 =>
        Some(result._2)
      case _ =>
        println(result._3)
        throw new RuntimeException(result._3)
    }

  }

  def createRDF(input: String): String = {
    import org.nlp2rdf.bean.{NIFBean, NIFType}
    import org.nlp2rdf.nif21.impl.NIF21
    val contextBuilder = new NIFBean.NIFBeanBuilder
    contextBuilder.context("http://test/resource").mention(input).nifType(NIFType.CONTEXT)
    val beanContext = new NIFBean(contextBuilder)

    val types: util.List[String] = Seq(
      "http://dbpedia.org/ontology/Person",
      "http://dbpedia.org/ontology/Place",
      "http://dbpedia.org/ontology/Organization"

    ).asJava


    val entityBuilder = new NIFBean.NIFBeanBuilder
    entityBuilder.context("http://test/annotation").mention("Argentina").beginIndex(23).endIndex(32)
      .annotator("http://www.nltk.org/ne_chunk")
      .types(types);


    val beans = Seq(
      new NIFBean(entityBuilder),
      new NIFBean(contextBuilder)
    ).asJava
    val nif = new NIF21(beans)
    nif.getTurtle
  }


}
