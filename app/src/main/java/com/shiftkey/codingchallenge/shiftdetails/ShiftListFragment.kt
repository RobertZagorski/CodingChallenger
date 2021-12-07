package com.shiftkey.codingchallenge.shiftdetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shiftkey.codingchallenge.R

class ShiftListFragment : Fragment() {

    companion object {
        fun newInstance() = ShiftListFragment()
    }

    private lateinit var viewModel: ShiftListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shift_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShiftListViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
