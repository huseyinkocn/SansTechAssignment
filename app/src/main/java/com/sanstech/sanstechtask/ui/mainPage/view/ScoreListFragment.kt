package com.sanstech.sanstechtask.ui.mainPage.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.sanstech.sanstechtask.R
import com.sanstech.sanstechtask.data.model.ScoreServiceModel
import com.sanstech.sanstechtask.databinding.FragmentScoreListBinding
import com.sanstech.sanstechtask.ui.BaseFragment
import com.sanstech.sanstechtask.ui.detailPage.ScoreDetailFragment
import com.sanstech.sanstechtask.ui.mainPage.MainActivity
import com.sanstech.sanstechtask.ui.mainPage.adapter.OnScoreItemClicked
import com.sanstech.sanstechtask.ui.mainPage.adapter.ScoreListAdapter
import com.sanstech.sanstechtask.ui.mainPage.viewmodel.ScoreListViewModel
import com.sanstech.sanstechtask.utils.extension.FilterExtension
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScoreListFragment : BaseFragment<FragmentScoreListBinding>() {

    //region variables
    private lateinit var viewModel: ScoreListViewModel
    private var scoreModelList: ArrayList<ScoreServiceModel>? = null
    private lateinit var scoreListAdapter: ScoreListAdapter
    //endregion

    //region lifecycle
    override fun getViewBinding(): FragmentScoreListBinding =
        FragmentScoreListBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    //endregion

    //region init
    private fun init() {
        viewModel = ViewModelProvider(this)[ScoreListViewModel::class.java]
        getScoreList()
        setObservers()
    }
    //endregion

    //region tools
    private fun getScoreList() {
        customProgressBar.show()
        viewModel.getScoreList()
    }

    private fun setData() {
        // filterScoresByMatchStatus fonksiyonu ile servisten gelen liste, skoru "MS" olanlara göre filtrelenip sonrasında ise turnuvalarına göre gruplandı
        scoreModelList?.let {
            scoreListAdapter = ScoreListAdapter(
                FilterExtension().filterScoresByMatchStatus(it),
                requireContext(),
                object : OnScoreItemClicked {
                    override fun onClicked() {
                        val fragmentManager = parentFragmentManager
                        val transaction = fragmentManager.beginTransaction()
                        val secondFragment = ScoreDetailFragment()
                        transaction.replace(R.id.fragmentContainerView, secondFragment)
                        transaction.addToBackStack(null)
                        transaction.commit()
                    }

                }
            )
        }
        binding.scoreListRv.adapter = scoreListAdapter
    }
    //endregion

    //region add observers
    private fun setObservers() {
        viewModel.scoreListData.observe(viewLifecycleOwner) {
            it?.data.let { data ->
                if (data != null) {
                    customProgressBar.dismiss()
                    scoreModelList?.clear()
                    scoreModelList = data
                    setData()
                }
            }
        }
    }
    //endregion

}