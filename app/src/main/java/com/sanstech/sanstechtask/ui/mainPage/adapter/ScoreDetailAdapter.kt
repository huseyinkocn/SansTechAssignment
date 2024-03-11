package com.sanstech.sanstechtask.ui.mainPage.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanstech.sanstechtask.R
import com.sanstech.sanstechtask.data.model.ScoreServiceModel
import kotlinx.android.synthetic.main.item_score.view.*

class ScoreDetailAdapter(
    private val scoreList: List<ScoreServiceModel>,
    val context: Context,
    private var listener: OnScoreItemClicked?
) : RecyclerView.Adapter<ScoreDetailAdapter.ViewHolder>() {


    inner class ViewHolder(val viewBinding: View) :
        RecyclerView.ViewHolder(viewBinding)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_score, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val scoreServiceModel = scoreList[position]

        val htScore = scoreServiceModel.score?.homeTeam?.teamGoalScored // ev sahibi takım gol bilgisi
        val atScore = scoreServiceModel.score?.awayTeam?.teamGoalScored // deplasman takım gol bilgisi

        val htFirstHalfScore = scoreServiceModel.score?.homeTeam?.firstHalf // ev sahibi takım ilk yarı gol bilgisi
        val atFirstHalfScore = scoreServiceModel.score?.awayTeam?.firstHalf // deplasman takımı ilk yarı gol bilgisi

        holder.viewBinding.abbrName.text = scoreServiceModel.score?.scoreSort
        holder.viewBinding.scoreTextView.text =
            context.getString(R.string.matchScore, htScore.toString(), atScore.toString())
        holder.viewBinding.halfAbbrTextView.text = context.getString(
            R.string.matchScore,
            htFirstHalfScore.toString(),
            atFirstHalfScore.toString()
        )
        holder.viewBinding.htNameTextView.text = scoreServiceModel.host?.htName
        holder.viewBinding.atNameTextView.text = scoreServiceModel.awayTeam?.htName

        holder.viewBinding.setOnClickListener { listener?.onClicked() }

    }

    override fun getItemCount(): Int = scoreList.size
}

interface OnScoreItemClicked {
    fun onClicked()
}