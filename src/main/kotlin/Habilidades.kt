interface Habilidade {

    fun usar(): String
}

class Ataque : Habilidade {
    override fun usar(): String {
        return "Realizando um ataque poderoso!"
    }
}

class Defesa : Habilidade {
    override fun usar(): String {
        return "Preparando uma defesa sólida!"
    }
}

class Magia : Habilidade {
    override fun usar(): String {
        return "Lançando um feitiço mágico!"
    }
}

