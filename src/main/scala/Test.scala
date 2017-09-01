import modules.GeneralNLTKNerModuleImpl

object Test {

  def main(args: Array[String]): Unit = {
    val module = new GeneralNLTKNerModuleImpl("python " + getClass.getResource("/ne_chunk.py").getPath);
    val result: Some[String] = module.process("Athens is a global city and one of the biggest economic centres in southeastern Europe. It has a large financial sector, and its port Piraeus is both the largest passenger port in Europe")
    println(result.get)
  }
}
