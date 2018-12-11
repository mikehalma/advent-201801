import java.io.File
import java.nio.charset.Charset

fun calculateFrequency(changeFileName :String): Int {
    val changes = loadChanges(changeFileName)
    return calculateFrequency(changes)
}

fun calculateFrequency(changes :List<String>): Int {
    var count = 0
    for (change in changes)
        count += getChangeValue(change)
    return count
}

fun getFirstDuplicate(changeFileName :String): Int {
    val changes = loadChanges(changeFileName)
    return getFirstDuplicate(changes)
}

fun getFirstDuplicate(changes :List<String>): Int {
    val counts = mutableSetOf<Int>()
    var count = 0
    counts.add(count)
    while (true) {
        changes.forEach { change ->
            count += getChangeValue(change)
            if (counts.contains(count)) {
                return count
            } else {
                counts.add(count)
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