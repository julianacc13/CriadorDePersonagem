class Nivel(val nivelAtual: Int) {
    fun aumentarAtributos(atributos: MutableMap<String, Int>) {
        if (nivelAtual % 4 == 0) {
            val atributo = atributos.keys.random()
            atributos[atributo] = atributos[atributo]!! + 1
            println("Atributo $atributo aumentado para ${atributos[atributo]}")
        }
    }
}
