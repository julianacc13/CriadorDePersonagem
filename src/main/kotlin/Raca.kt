interface Raca {

    fun bonusRacial(): Map<String, Int>
}

class Elfo : Raca {
    override fun bonusRacial(): Map<String, Int> {
        return mapOf(
            "Destreza" to 2,
            "Constituição" to -1
        )
    }
}

class Anão : Raca {
    override fun bonusRacial(): Map<String, Int> {
        return mapOf(
            "Constituição" to 2,
            "Destreza" to -1
        )
    }
}
