fun main() {

    val ago = 30000
    agoToText(ago)

}

fun agoToText(ago: Int) {
    var agoText = when (ago) {
        in 0..60 -> "Только что"
        in 60..60 * 60 -> toMminutes(ago)
        in 60 * 60 + 1..24 * 60 * 60 -> toHours(ago)
        in 24 * 60 * 60..24 * 60 * 60 * 2 -> "вчера"
        in 24 * 60 * 60 * 2..24 * 60 * 60 * 3 -> "позавчера"
        else -> "давно"
    }
    println("Пользователь был(а) в сети $agoText")
}

fun toMminutes(ago: Int): String {
    var minutes = ago / 60
    var minutesText = when (minutes) {
        1, 21, 31, 41, 51 -> "минуту"
        in 5..20, in 25..30, in 35..40, in 45..50, in 55..60 -> "минут"
        else -> "минуты"
    }
    return "$minutes $minutesText назад"
}

fun toHours(ago: Int): String {
    var hours = ago / (60 * 60)
    var hoursText = when (hours) {
        1, 21 -> "час"
        in 5..20 -> "часов"
        else -> "часа"
    }
    return "$hours $hoursText назад"
}