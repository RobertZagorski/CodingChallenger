package com.shiftkey.codingchallenge.shiftdetails

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.shiftkey.codingchallenge.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShiftListFragment : Fragment(R.layout.shift_list_fragment) {

    companion object {
        fun newInstance() = ShiftListFragment()
    }

    private val viewModel: ShiftListViewModel by viewModels()
}
