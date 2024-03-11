package com.sanstech.sanstechtask.ui.mainPage.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sanstech.sanstechtask.R
import com.sanstech.sanstechtask.data.model.ScoreServiceModel
import kotlinx.android.synthetic.main.item_score_list.view.*

class ScoreListAdapter(
    private val scoreList: Map<Int?, List<ScoreServiceModel>>,
    val context: Context,
    var listener: OnScoreItemClicked?
) : RecyclerView.Adapter<ScoreListAdapter.ViewHolder>() {


    inner class ViewHolder(val viewBinding: View) :
        RecyclerView.ViewHolder(viewBinding)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_score_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tournamentId =
            scoreList.keys.elementAt(position)   // tournamentId ile var olan key bilgisini aldık

        val detailAdapter = scoreList[tournamentId]?.let {
            ScoreDetailAdapter(it, context, object : OnScoreItemClicked {
                override fun onClicked() {
                    listener?.onClicked()
                }
            })
        } // alınan key bilgisi ile map içerisindeki o elemanı seçip adaptera gönderiyoruz
        holder.viewBinding.detailRecyclerView.adapter = detailAdapter
        holder.viewBinding.detailRecyclerView.setHasFixedSize(true) // öğelerin boyutu sabit kalacağı için kullanıldı

        holder.viewBinding.tournamentText.text =
            scoreList[tournamentId]?.get(0)?.tournamentInfo?.tournamentName
        Glide.with(context)
            .load(scoreList[tournamentId]?.get(0)?.tournamentInfo?.flag)
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_placeholder)
            .into(holder.viewBinding.tournamenImageView)


    }

    override fun getItemCount(): Int = scoreList.size
}
