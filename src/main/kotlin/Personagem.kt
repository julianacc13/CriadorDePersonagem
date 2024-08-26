class Personagem(
    private val nome: String,
    private val raca: Raca,
    atributos: Map<String, Int>,
    private val classe: Classe,
    private val nivel: Nivel
) {
    val atributos: MutableMap<String, Int>
    val pontosDeVida: Int
    private val habilidades: List<Habilidade>

    init {
        this.atributos = atributos.toMutableMap()
        aplicarBonusRacial()
        aplicarBonusDeClasse()
        habilidades = classe.habilidadesDeClasse()
        pontosDeVida = calcularPontosDeVida()
        nivel.aumentarAtributos(this.atributos)
    }

    private fun aplicarBonusRacial() {
        val bonus = raca.bonusRacial()
        for ((atributo, valor) in bonus) {
            atributos[atributo] = atributos.getOrDefault(atributo, 0) + valor
        }
    }

    private fun aplicarBonusDeClasse() {
        val bonus = classe.bonusDeClasse()
        for ((atributo, valor) in bonus) {
            atributos[atributo] = atributos.getOrDefault(atributo, 0) + valor
        }
    }

    private fun calcularPontosDeVida(): Int {
        val modificadorDeConstituicao = (atributos["Constituição"]!! - 10) / 2
        return 10 + modificadorDeConstituicao
    }

    fun exibirAtributos() {
        println("Atributos do personagem $nome:")
        for ((atributo, valor) in atributos) {
            println("$atributo: $valor")
        }
        println("Pontos de vida: $pontosDeVida")
    }

    fun usarHabilidade() {
        habilidades.forEach {
            println(it.usar())
        }
    }
}
