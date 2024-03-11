package com.sanstech.sanstechtask.utils.extension

import com.sanstech.sanstechtask.data.model.ScoreServiceModel

class FilterExtension() {

    fun filterScoresByMatchStatus(scoreList: ArrayList<ScoreServiceModel>) : Map<Int?, List<ScoreServiceModel>> {
        val filterAbbr =  scoreList.filter { it.score?.scoreSort.equals("MS") } // Tüm liste içerisinden skor bilgisi "MS" olanları filtrele
        return groupScoresByTournamentId(filterAbbr)
    }

    private fun groupScoresByTournamentId(scoreList: List<ScoreServiceModel>): Map<Int?, List<ScoreServiceModel>> {
        return scoreList.groupBy { it.tournamentInfo?.tournamentUniqueId } // UniqId'ye göre grupla
    }

}