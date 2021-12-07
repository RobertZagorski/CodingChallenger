package com.shiftkey.codingchallenge.usecases

import com.shiftkey.codingchallenge.model.ShiftkeyTime
import com.shiftkey.codingchallenge.model.WorkWeek
import com.shiftkey.codingchallenge.repositories.ShiftListRepository
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.any
import org.mockito.Mockito.argThat
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetAvailableShiftListUseCaseTest {

    @Mock
    private lateinit var repository: ShiftListRepository

    private val getAvailableShiftListUseCase by lazy { GetAvailableShiftListUseCase(repository) }

    @Test
    fun `Should load the shifts based on start time and location`() {
        // given
        `when`(repository.getShifts(any())).thenReturn(emptyList())
        val params = GetAvailableShiftListUseCase.Params(
            location = LOCATION,
            start = ShiftkeyTime(START_TIME)
        )
        // when
        val result = getAvailableShiftListUseCase.execute(params)

        // then
        verify(repository).getShifts(argThat {
            it.address == LOCATION &&
                it.start.timestamp == START_TIME &&
                it.radius == RADIUS &&
                it.type == WorkWeek.WEEK
        })
        assertTrue(result.isEmpty())
    }
}

private const val LOCATION = "Dallas,TX"
private const val START_TIME = 1L
private const val RADIUS = 10
