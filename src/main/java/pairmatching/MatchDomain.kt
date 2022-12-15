package pairmatching

import pairmatching.UI.InputView

class MatchDomain {
    fun backendMatch(pairMatch : PairMatching, wholePair: MutableList<PairMatching>) : PairMatching{
        var pairMatch = pairMatch
        val crewNames = FileController().readBackendFile()
        val shuffleCrew = LittleDomain().createShuffleCrew(crewNames)

        if (shuffleCrew.size % 2 == 1) pairMatch = oddCrewMatch(shuffleCrew, pairMatch, wholePair)
        if (shuffleCrew.size % 2 == 0) pairMatch = evenCrewMatch(shuffleCrew, pairMatch, wholePair)
        return pairMatch
    }

    fun frontendMatch(pairMatch: PairMatching, wholePair: MutableList<PairMatching>) : PairMatching{
        var pairMatch = pairMatch
        val crewNames = FileController().readFrontendFile()
        val shuffleCrew = LittleDomain().createShuffleCrew(crewNames)

        //홀수짝수 구분
        if (shuffleCrew.size % 2 == 1) pairMatch = oddCrewMatch(shuffleCrew, pairMatch, wholePair)
        if (shuffleCrew.size % 2 == 0) pairMatch = evenCrewMatch(shuffleCrew, pairMatch, wholePair)
        return pairMatch
    }

    fun multi(wholePair : MutableList<PairMatching>, pairMatch: PairMatching): MutableList<PairMatching> {
        for (i in wholePair){
            if (i.getCourse() == pairMatch.getCourse() && i.getLevel() == pairMatch.getLevel() && i.getMission() == pairMatch.getMission()){
                val answer = InputView().retryMatch()
                if (answer == "아니오") {
                    return GameController().menu1(wholePair)
                }
            }
        }
        return wholePair
    }

    fun evenCrewMatch(shuffleCrew : MutableList<Crew>, pairMatch: PairMatching, wholePair: MutableList<PairMatching>) : PairMatching{
        for (i in (0..shuffleCrew.size-2) step 2){
            var match = mutableListOf(shuffleCrew[i],shuffleCrew[i+1])
            if (shuffleCrew[i].metPair.contains(shuffleCrew[i+1])){
                pairMatch.pair.clear()
                GameController().menu1(wholePair)
            }
            LittleDomain().metCrew(shuffleCrew, i)
            pairMatch.pair.add(match)
        }
        pairMatch.even = 1
        return pairMatch
    }

    fun oddCrewMatch(shuffleCrew: MutableList<Crew>, pairMatch: PairMatching, wholePair: MutableList<PairMatching>) : PairMatching{
        var pairMatch = pairMatch
        for (i in (0..shuffleCrew.size-3) step 2){
            if (i == shuffleCrew.size-3){
                if (shuffleCrew[i].metPair.contains(shuffleCrew[i+1])){
                    pairMatch.pair.clear()
                    GameController().menu1(wholePair)
                }
                LittleDomain().metCrew(shuffleCrew, i)

                pairMatch = lastPair(shuffleCrew[i],shuffleCrew[i+1],shuffleCrew[i+2],pairMatch)
            }
            if (i != shuffleCrew.size-3){
                if (shuffleCrew[i].metPair.contains(shuffleCrew[i+1])){
                    pairMatch.pair.clear()
                    GameController().menu1(wholePair)
                }
                LittleDomain().metCrew(shuffleCrew, i)

                pairMatch = normalPair(shuffleCrew[i],shuffleCrew[i+1],pairMatch)
            }
        }
        pairMatch.even = 0
        return pairMatch
    }
    fun normalPair(one : Crew, two : Crew, pairMatch: PairMatching) : PairMatching{
        var match = mutableListOf(one, two)
        pairMatch.pair.add(match)
        return pairMatch
    }
    fun lastPair(one : Crew, two : Crew, three : Crew, pairMatch: PairMatching) : PairMatching{
        var match = mutableListOf(one, two, three)
        pairMatch.pair.add(match)
        return pairMatch
    }
}