import junit.framework.Assert.assertEquals
import org.junit.Test;
import java.time.Instant
import java.time.temporal.ChronoUnit

class FrequencyCalculatorTest {

    @Test
    fun calculateFrequency_singlePositiveChange_returnsValue() {
        assertEquals(1, calculateFrequency(listOf("+1")))
    }

    @Test
    fun calculateFrequency_singleNegativeChange_returnsValue() {
        assertEquals(-1, calculateFrequency(listOf("-1")))
    }

    @Test
    fun calculateFrequency_twoPositiveNumbers_returnsSum() {
        assertEquals(2, calculateFrequency(listOf("+1", "+1")))
    }

    @Test
    fun calculateFrequency_twoNegativeNumbers_returnsSum() {
        assertEquals(-2, calculateFrequency(listOf("-1", "-1")))
    }

    @Test
    fun calculateFrequency_twoMixedNumbers_returnsSum() {
        assertEquals(2, calculateFrequency(listOf("+5", "-3")))
    }

    @Test
    fun loadChanges_emptyFile_returnsEmpty() {
        assertEquals(listOf<String>(), loadChanges("emptyFile.txt"))
    }

    @Test
    fun loadChanges_multipleLines_returnsListOfLines() {
        assertEquals(listOf("+1", "+4", "-2"), loadChanges("multipleLines.txt"))
    }

    @Test
    fun calculatFrequencyFile_emptyFile_returnsZero() {
        assertEquals(0, calculateFrequency("emptyFile.txt"))
    }

    @Test
    fun calculatFrequencyFile_multipleLines_returnsSum() {
        assertEquals(3, calculateFrequency("multipleLines.txt"))
    }

    @Test
    fun calculateFrequenceFile_frequencies_returnsSum() {
        assertEquals(510, calculateFrequency("frequencies.txt"))
    }

    @Test
    fun getFirstDuplicate_firstIsZero() {
        assertEquals(0, getFirstDuplicate("firstIsZero.txt"))
    }

    @Test
    fun getFirstDuplicate_firstIsTen() {
        assertEquals(10, getFirstDuplicate("firstIsTen.txt"))
    }

    @Test
    fun getFirstDuplicate_firstIsFive() {
        assertEquals(5, getFirstDuplicate("firstIsFive.txt"))
    }

    @Test
    fun getFirstDuplicate_firstIsFourteen() {
        assertEquals(14, getFirstDuplicate("firstIsFourteen.txt"))
    }

    @Test
    fun getFirstDuplicate_returnsFirst() {
        val start = Instant.now()
        assertEquals(69074, getFirstDuplicate("frequencies.txt"))
        val end = Instant.now()
        System.out.println("Completed challenge 2 in " + start.until(end, ChronoUnit.MILLIS))
    }
}
