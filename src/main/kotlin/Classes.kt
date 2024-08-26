interface Classe {
    fun habilidadesDeClasse(): List<Habilidade>
    fun bonusDeClasse(): Map<String, Int>
}
class Guerreiro : Classe {
    override fun habilidadesDeClasse(): List<Habilidade> {
        return listOf(Ataque(), Defesa())
    }

    override fun bonusDeClasse(): Map<String, Int> {
        return mapOf(
            "Força" to 2,
            "Constituição" to 1
        )
    }
}

class Mago : Classe {
    override fun habilidadesDeClasse(): List<Habilidade> {
        return listOf(Magia())
    }

    override fun bonusDeClasse(): Map<String, Int> {
        return mapOf(
            "Inteligência" to 2
        )
    }
}
