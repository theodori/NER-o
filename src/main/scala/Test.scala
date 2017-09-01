import modules.GeneralNLTKNerModuleImpl

object Test {
  def main(args: Array[String]): Unit = {
    val module = new GeneralNLTKNerModuleImpl();
    val result: Some[String] = module.process("Athens is a global city and one of the biggest economic " +
      "centres in southeastern Europe. the United Nations are hosted there. It has a large financial sector, and its port Piraeus is both the largest passenger port in Europe")
    println(result.get)
  }
}
