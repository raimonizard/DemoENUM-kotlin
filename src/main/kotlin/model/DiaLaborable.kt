package model

enum class DiaLaborable(val assignatures: Array<String>) {
    DILLUNS(arrayOf("Programació", "Tutoria", "Llenguatge de marques")),
    DIMARTS(arrayOf("Programació", "Desplegament d'aplicacions web", "Bases de dades")),
    DIMECRES(arrayOf("Programació", "Llenguatge de marques")),
    DIJOUS(arrayOf("IPO", "Llenguatge de marques")),
    DIVENDRES(arrayOf("Programació", "Llenguatge de marques", "Bases de dades"))
}