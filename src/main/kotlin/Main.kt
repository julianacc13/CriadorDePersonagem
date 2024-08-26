fun main() {
    println("Escolha uma raça (1. Elfo, 2. Anão):")
    val raca = when (readLine()?.toIntOrNull()) {
        1 -> Elfo()
        2 -> Anão()
        else -> {
            println("Opção inválida. Selecionando Elfo por padrão.")
            Elfo()
        }
    }

    val atributos = mutableMapOf(
        "Força" to 0,
        "Destreza" to 0,
        "Constituição" to 0,
        "Inteligência" to 0,
        "Sabedoria" to 0,
        "Carisma" to 0
    )
    var pontosRestantes = 27

    while (pontosRestantes > 0) {
        println("Atributos disponíveis para distribuir: $pontosRestantes")
        atributos.entries.forEachIndexed { index, entry ->
            println("${index + 1}. ${entry.key}: ${entry.value}")
        }

        println("Escolha um atributo para aumentar pelo número (ou digite 'sair' para finalizar):")
        val escolha = readLine()?.trim() ?: ""
        if (escolha.lowercase() == "sair") break

        val atributoIndex = escolha.toIntOrNull()
        if (atributoIndex != null && atributoIndex in 1..atributos.size) {
            val atributoEscolhido = atributos.keys.elementAt(atributoIndex - 1)
            println("Digite a quantidade a ser adicionada ao atributo $atributoEscolhido:")
            val aumento = readLine()?.toIntOrNull() ?: 0
            if (aumento > 0 && aumento <= pontosRestantes) {
                atributos[atributoEscolhido] = atributos[atributoEscolhido]!! + aumento
                pontosRestantes -= aumento
            } else {
                println("Valor inválido ou insuficiente.")
            }
        } else {
            println("Número inválido. Tente novamente.")
        }
    }

    println("Escolha uma classe (1. Guerreiro, 2. Mago):")
    val classe = when (readLine()?.toIntOrNull()) {
        1 -> Guerreiro()
        2 -> Mago()
        else -> {
            println("Opção inválida. Selecionando Guerreiro por padrão.")
            Guerreiro()
        }
    }

    println("Digite o nível do personagem:")
    val nivel = Nivel(readLine()?.toIntOrNull() ?: 1)

    println("Digite o nome do personagem:")
    val nome = readLine() ?: "Desconhecido"

    val personagem = Personagem(nome, raca, atributos, classe, nivel)

    personagem.exibirAtributos()
    personagem.usarHabilidade()
}
