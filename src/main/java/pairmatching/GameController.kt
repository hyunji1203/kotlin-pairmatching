package pairmatching

import pairmatching.UI.InputView
import pairmatching.UI.OutputView

class GameController {
    fun menu1(wholePair : MutableList<PairMatching>) : MutableList<PairMatching> {
        var pairMatch = InputView().pairInput(wholePair)
        MatchDomain().multi(wholePair, pairMatch)
        if (pairMatch.getCourse() == "백엔드") pairMatch = MatchDomain().backendMatch(pairMatch, wholePair)
        if (pairMatch.getCourse() == "프론트엔드") pairMatch = MatchDomain().frontendMatch(pairMatch, wholePair)
        wholePair.add(pairMatch)
        OutputView().pairMatchResult(pairMatch)
        return wholePair
    }

    fun menu2(wholePair: MutableList<PairMatching>){
        var pairMatch = InputView().pairInput(wholePair)
        for (i in wholePair){
            if (i.getCourse() == pairMatch.getCourse() && i.getLevel() == pairMatch.getLevel() && i.getMission() == pairMatch.getMission()){
                OutputView().pairMatchResult(i)
            }
        }
    }
}