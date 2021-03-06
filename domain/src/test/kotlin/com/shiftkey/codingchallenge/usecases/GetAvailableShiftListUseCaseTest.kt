package com.shiftkey.codingchallenge.usecases

import com.shiftkey.codingchallenge.model.ShiftkeyTime
import com.shiftkey.codingchallenge.model.WorkWeek
import com.shiftkey.codingchallenge.repositories.ShiftListRepository
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.argThat
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetAvailableShiftListUseCaseTest {

    @Mock
    private lateinit var repository: ShiftListRepository

    private val getAvailableShiftListUseCase by lazy { GetAvailableShiftListUseCase(repository) }

    @Test
    fun `Should load the shifts based on start time and location`() {
        // given
        whenever(repository.getShifts(any()))
            .thenReturn(emptyList())
        val params = GetAvailableShiftListUseCase.Params(
            location = LOCATION,
            start = ShiftkeyTime(START_TIME)
        )
        // when
        val result = getAvailableShiftListUseCase.execute(params)

        // then
        verify(repository).getShifts(argThat {
            address == LOCATION &&
                start.timestamp == START_TIME &&
                radius == RADIUS &&
                type == WorkWeek.WEEK
        })
        assertTrue(result.isEmpty())
    }
}

private const val LOCATION = "Dallas,TX"
private const val START_TIME = 1L
private const val RADIUS = 10
