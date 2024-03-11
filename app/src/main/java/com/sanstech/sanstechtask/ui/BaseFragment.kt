package com.sanstech.sanstechtask.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.sanstech.sanstechtask.utils.cache.PrefUtil
import com.sanstech.sanstechtask.utils.custom.CustomProgressBar
import com.sanstech.sanstechtask.utils.custom.CustomToast
import javax.inject.Inject


abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    // region variables
    lateinit var binding: VB

    @Inject
    lateinit var cache: PrefUtil

    @Inject
    lateinit var customToast: CustomToast

    lateinit var customProgressBar: CustomProgressBar

    //endregion

    //region fragment lifecycle
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentContext = requireContext()
        customProgressBar = CustomProgressBar(currentContext)
        customToast = CustomToast(currentContext)
    }
    //endregion

    //region tools
    abstract fun getViewBinding(): VB
    //endregion
}