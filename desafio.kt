// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario (val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        if (usuario !in inscritos) {
            inscritos.add(usuario)
            println("${usuario.nome} matriculado(a) em $nome.")
        } else {
            println("${usuario.nome} já está matriculado(a) em $nome.")
        }
    }

    
}

fun main() {
   // TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    // Criando conteúdos educacionais
    val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin", 60)
    val pooKotlin = ConteudoEducacional("POO com Kotlin", 120)
    val colecoesKotlin = ConteudoEducacional("Coleções em Kotlin", 90)

    // Criando formações
    val formacaoKotlin = Formacao(
        nome = "Kotlin Developer",
        nivel = Nivel.BASICO,
        conteudos = listOf(kotlinBasico, pooKotlin)
    )

    val formacaoAvancada = Formacao(
        nome = "Kotlin Avançado",
        nivel = Nivel.DIFICIL,
        conteudos = listOf(colecoesKotlin)
    )

    // Criando usuários
    val usuario1 = Usuario("Ana", "ana@email.com")
    val usuario2 = Usuario("Carlos", "carlos@email.com")
    val usuario3 = Usuario("Mariana", "mariana@email.com")

    // Simulando matrículas
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario1) // Testando matrícula duplicada

    formacaoAvancada.matricular(usuario1)
    formacaoAvancada.matricular(usuario3)

    // Exibindo resultados
    println("\nFormação: ${formacaoKotlin.nome}")
    println("Nível: ${formacaoKotlin.nivel}")
    println("Conteúdos:")
    formacaoKotlin.conteudos.forEach {
        println("- ${it.nome} (${it.duracao} minutos)")
    }

    println("\nAlunos matriculados em ${formacaoKotlin.nome}:")
    formacaoKotlin.inscritos.forEach {
        println("- ${it.nome}")
    }

    println("\nAlunos matriculados em ${formacaoAvancada.nome}:")
    formacaoAvancada.inscritos.forEach {
        println("- ${it.nome}")
    }
}

