package extensions

import kotlin.js.Date

fun Date.toUtcISoDateString(): String {
    val year = this.getUTCFullYear()
    val month = leadingZeroIfSingleDigit(this.getUTCMonth() + 1)
    val day = leadingZeroIfSingleDigit(this.getDate())
    return "${year}-${month}-${day}"
}

fun Date.toUtcIsoTimeString(): String {
    val hours = leadingZeroIfSingleDigit(this.getUTCHours())
    val minutes = leadingZeroIfSingleDigit(this.getUTCMinutes())
    val seconds = leadingZeroIfSingleDigit(this.getUTCSeconds())
    return "${hours}:${minutes}:${seconds}Z"
}

private fun leadingZeroIfSingleDigit(value: Int): String =
    if (value > 9) {
        value.toString()
    } else {
        "0$value"
    }
