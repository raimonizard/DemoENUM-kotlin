import model.DiaLaborable
import model.DiaSetmana

fun main() {
    demoQualsevolDia()
    demoDiaLaborable()
}

fun demoQualsevolDia() {
    var diaSetmana: DiaSetmana
    var opcioDia: Int? = null

    // Estructura do-while per demanar a l'usuari@ un dia de la setmana per
    // teclat i capturar la seva resposta amb validació.
    do {
        println("Escull un dia de la setmana:")
        for (dia in DiaSetmana.entries) {
            println("${dia.ordinal}: $dia")
        }

        opcioDia = readln().toIntOrNull()

    }while((opcioDia == null) || (opcioDia < 0) || (opcioDia >= DiaSetmana.entries.size))

    diaSetmana = DiaSetmana.entries[opcioDia]

    println("Has escollit el dia $diaSetmana")
}

fun demoDiaLaborable(){
    var diaLaborable: DiaLaborable
    var opcioDia: Int? = null

    // Estructura do-while per demanar a l'usuari@ un dia de la setmana per
    // teclat i capturar la seva resposta amb validació.
    do {
        println("Escull un dia de la setmana i et diré les teves assignatures:")
        for (dia in DiaLaborable.entries) {
            println("${dia.ordinal}: $dia")
        }

        opcioDia = readln().toIntOrNull()

    }while((opcioDia == null) || (opcioDia < 0) || (opcioDia >= DiaLaborable.entries.size))

    diaLaborable = DiaLaborable.entries[opcioDia]

    println("Has escollit el dia $diaLaborable")
    for (assignatura in diaLaborable.assignatures){
        println("\t- " + assignatura)
    }
}