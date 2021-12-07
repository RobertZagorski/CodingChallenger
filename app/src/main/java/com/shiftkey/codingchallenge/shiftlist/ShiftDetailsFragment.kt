package com.shiftkey.codingchallenge.shiftlist

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.shiftkey.codingchallenge.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShiftDetailsFragment : Fragment(R.layout.shift_details_fragment) {

    companion object {
        fun newInstance() = ShiftDetailsFragment()
    }

    private val viewModel: ShiftDetailsViewModel by viewModels()
}
