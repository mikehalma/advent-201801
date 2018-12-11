import java.io.File
import java.nio.charset.Charset

fun calculateFrequency(changeFileName :String): Int {
    val changes = loadChanges(changeFileName)
    return calculateFrequency(changes)
}

fun calculateFrequency(changes :List<String>): Int {
    return changes.map {getChangeValue(it)}.sum()
}

fun getFirstDuplicate(changeFileName :String): Int {
    val changes = loadChanges(changeFileName)
    return getFirstDuplicate(changes)
}

fun getFirstDuplicate(changes :List<String>): Int {
    val counts = mutableSetOf(0)
    while (true) {
        changes.forEach { change ->
            val changeVal = counts.last() + getChangeValue(change)
            if (!counts.add(changeVal)) {
                return changeVal
            }
        }
    }
}

fun getChangeValue(change :String): Int {
    val operator = change.substring(0, 1)
    val number = change.substring(1).toInt()
    return if (operator == "+") number else 0 - number

}

fun loadChanges(fileName :String) :List<String> {
    return File(object {}.javaClass.getResource(fileName).toURI()).readLines(Charset.defaultCharset())
}