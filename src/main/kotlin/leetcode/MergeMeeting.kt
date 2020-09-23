package leetcode

import leetcode.MergeMeeting.mergeRanges
import kotlin.test.assertEquals

object MergeMeeting {
    fun mergeRanges(meetings: List<Meeting>): List<Meeting> {
        if (meetings.size <= 1) return meetings
        val sorted = meetings.sortedWith(compareBy({ it.start }, {it.end}))
        val result = mutableListOf<Meeting>()
        var preStartTime = sorted.first().start
        var preEndTime = sorted.first().end
        sorted.forEach {m ->
            if (m.start <= preEndTime) {
                if (m.end > preEndTime)
                    preEndTime = m.end
            } else {
                result.add(Meeting(preStartTime, preEndTime))
                preStartTime = m.start
                preEndTime = m.end
            }
        }
        result.add(Meeting(preStartTime, preEndTime))
        return result
    }
}

data class Meeting(val start: Int, val end: Int)

fun main() {
    meetingsOverlapTest()
    meetingsNotSortedTest()
    meetingContainsOtherMeetingTest()
    meetingsStaySeparateTest()
    meetingsTouchTest()
    multipleMergedMeetingsTest()
    oneLongMeetingContainsSmallerMeetingsTest()
    sampleInputTest()
}

fun meetingsOverlapTest() {
    val meetings = listOf(Meeting(1, 3), Meeting(2, 4))
    val actual: List<Meeting> = mergeRanges(meetings)
    val expected = listOf(Meeting(1, 4))
    assertEquals(expected, actual)
}

fun meetingsTouchTest() {
    val meetings = listOf(Meeting(5, 6), Meeting(6, 8))
    val actual: List<Meeting> = mergeRanges(meetings)
    val expected = listOf(Meeting(5, 8))
    assertEquals(expected, actual)
}

fun meetingContainsOtherMeetingTest() {
    val meetings = listOf(Meeting(1, 8), Meeting(2, 5))
    val actual: List<Meeting> = mergeRanges(meetings)
    val expected = listOf(Meeting(1, 8))
    assertEquals(expected, actual)
}

fun meetingsStaySeparateTest() {
    val meetings = listOf(Meeting(1, 3), Meeting(4, 8))
    val actual: List<Meeting> = mergeRanges(meetings)
    val expected = listOf(
            Meeting(1, 3), Meeting(4, 8)
    )
    assertEquals(expected, actual)
}

fun multipleMergedMeetingsTest() {
    val meetings = listOf(
            Meeting(1, 4), Meeting(2, 5), Meeting(5, 8))
    val actual: List<Meeting> = mergeRanges(meetings)
    val expected = listOf(Meeting(1, 8))
    assertEquals(expected, actual)
}

fun meetingsNotSortedTest() {
    val meetings = listOf(
            Meeting(5, 8), Meeting(1, 4), Meeting(6, 8))
    val actual: List<Meeting> = mergeRanges(meetings)
    val expected = listOf(
            Meeting(1, 4), Meeting(5, 8)
    )
    assertEquals(expected, actual)
}

fun oneLongMeetingContainsSmallerMeetingsTest() {
    val meetings = listOf(
            Meeting(1, 10), Meeting(2, 5), Meeting(6, 8),
            Meeting(9, 10), Meeting(10, 12)
    )
    val actual: List<Meeting> = mergeRanges(meetings)
    val expected = listOf(
            Meeting(1, 12)
    )
    assertEquals(expected, actual)
}

fun sampleInputTest() {
    val meetings = listOf(
            Meeting(0, 1), Meeting(3, 5), Meeting(4, 8),
            Meeting(10, 12), Meeting(9, 10)
    )
    val actual: List<Meeting> = mergeRanges(meetings)
    val expected = listOf(
            Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)
    )
    assertEquals(expected, actual)
}