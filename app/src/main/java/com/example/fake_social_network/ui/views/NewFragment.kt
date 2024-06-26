package com.example.fake_social_network.ui.views

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fake_social_network.R
import com.example.fake_social_network.ui.viewmodels.NewViewModel

class NewFragment : Fragment() {

    companion object {
        fun newInstance() = NewFragment()
    }

    private val viewModel: NewViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_new, container, false)
    }
}