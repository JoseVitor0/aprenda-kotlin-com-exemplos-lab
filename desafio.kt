enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario (val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    
    val inscritos = mutableListOf<String>()
    
    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios){
         	inscritos.add(usuario.nome)   
        }
    }
    
    fun listarMatriculas(): MutableList<String>{
        return inscritos
    }
    
    fun listarConteudos(){
        for (conteudo in conteudos){
            println(conteudo.nome)
        }
    }
}

fun <ConteudoEducacional> MutableList<ConteudoEducacional>.addConteudo(vararg conteudos: ConteudoEducacional){
    for (conteudo in conteudos){
        this.add(conteudo)
    }
}

fun main() {
    val jose = Usuario("jose")
    val ruan = Usuario("ruan")
    val jonathan = Usuario("jonathan")
    val juninho = Usuario("juninho")
    
    val listaConteudos: MutableList<ConteudoEducacional> = mutableListOf()
    
    val conteudo1 = ConteudoEducacional("lógica de programação", 60, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("princípios de programação em Kotlin", 60, Nivel.BASICO)
    val conteudo3 = ConteudoEducacional("programação orientada a objetos em Kotlin", 120, Nivel.INTERMEDIARIO)
    val conteudo4 = ConteudoEducacional("desenvolvimento android com Kotlin", 240, Nivel.AVANCADO) 
    
	listaConteudos.addConteudo(conteudo1, conteudo2, conteudo3, conteudo4)
    
    val formacao = Formacao("formação android developer", listaConteudos, Nivel.INTERMEDIARIO)
    
    formacao.matricular(jose, ruan, jonathan, juninho)
    println(formacao.listarMatriculas())
    formacao.listarConteudos()
    
    
    
    
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}