package com.shiftkey.codingchallenge.shiftdetails

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.shiftkey.codingchallenge.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShiftListFragment : Fragment(R.layout.shift_list_fragment) {

    val args: ShiftListFragmentArgs by navArgs()
    val location: String by lazy { args.location }

    private val viewModel: ShiftListViewModel by viewModels()
}
