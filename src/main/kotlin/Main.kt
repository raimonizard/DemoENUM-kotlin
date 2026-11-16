import model.DiaLaborable
import model.DiaSetmana
import java.awt.Dialog

fun main() {
    var opcio: Int?

    do {
        println(
            """Escull una de les demos disponibles:
                    1.Demo escollir de dilluns a diumenge usant números
                    2.Demo escollir de dilluns a divendres usant números i veure assignatures
                    3.Demo escollir de dilluns a divendres usant String i veure assignatures
                    4.Sortir
                """.trimIndent()
        )

        opcio = llegirEnter(1, 4)

        when (opcio) {
            1 -> demoQualsevolDia()
            2 -> demoDiaLaborable()
            3 -> demoDiaLaborableText()
            else -> println("Adéu")
        }
    }while (opcio < 4)
}

/**
 * Mètode que serveix per llegir un enter per teclat amb control d'errors
 * i domini de valors
 * @author RIS
 * @param min valor min acceptat
 * @param max valor max acceptat
 * @return retorna un Int dins del llindar [min,max]
 */
fun llegirEnter(min: Int, max: Int): Int {
    var op: Int? = null

    do{
        println("Escull un valor")
        op = readln().toIntOrNull()
    }while (op == null || op < min || op > max)

    return op
}

/**
 * Mètode que permet escollir un mètode dins de l'ENUM DiaSetmana
 * usant enters
 * @author RIS
 */
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

/**
 * Mètode que serveix per escollir un valor de DiaLaborable usant enter
 * @author RIS
 */
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

/**
 * Mètode que permet escollir un valor de DiaLaborable usant String
 * @author RIS
 */
fun demoDiaLaborableText(){
    var dia: DiaLaborable = escollirDiaSet()
    mostrarAssignatures(dia)
}

/**
 * Mètode que mostra les assignatures d'un DiaLaborable donat
 * @author RIS
 * @param diaLaborable
 */
fun mostrarAssignatures(diaLaborable: DiaLaborable){
    println("Has escollit el dia $diaLaborable")
    for (assignatura in diaLaborable.assignatures){
        println("\t- " + assignatura)
    }
}

/**
 * Aquest mètode serveix per obligar a l'usuari@ de la app, a escollir un valor dels disponibles
 * dins de l'ENUM DiaSetmana
 * @author RIS
 * @return retorna un valor ENUM dels disponibles dins de DiaSetmana
 */
fun escollirDiaSet(): DiaLaborable{
    var dia: String
    var diaSetmana: DiaLaborable = DiaLaborable.DILLUNS
    var diaCorrecte: Boolean = false

    do {
        println("Quina dia de la setmana vols veure?")
        printDivisor(30)

        dia = readln()

        for (d in DiaLaborable.entries) {
            if (dia.uppercase() == d.name){
                diaCorrecte = true
                diaSetmana = d
            }
        }
    }while (!diaCorrecte)

    return diaSetmana
}

/**
 * Aquest mètode envellidor només serveix per imprimir un divisor (rodolí)
 * @author RIS
 * @param nombre d'asterics a mostrar xaval
 */
fun printDivisor(numAsteriscs: Int){
    repeat(numAsteriscs){print("*")}
    println()
}