package pairmatching.UI

import camp.nextstep.edu.missionutils.*
import pairmatching.Exception
import pairmatching.PairMatching
import kotlin.IllegalArgumentException

class InputView {
    fun menu() : String{
        OutputView().menu()
        var menuNumber = Console.readLine()
        return menuNumber
    }

    fun pairInput(wholePair : MutableList<PairMatching>) : PairMatching {
        var pairMatching = PairMatching()
        try {
            OutputView().example()
            var condition = Console.readLine().split(", ")
            pairMatching = setPairMatching(pairMatching, condition)
            Exception().noneException(pairMatching,wholePair)
        } catch (e : IllegalArgumentException){
            println(e.message)
            return pairInput(wholePair)
        }
        return pairMatching
    }
    fun setPairMatching(pairMatching: PairMatching, condition : List<String>) : PairMatching{
        pairMatching.setCourse(condition[0])
        pairMatching.setLevel(condition[1])
        pairMatching.setMission(condition[2])
        return pairMatching
    }

    fun retryMatch() : String{
        OutputView().retryMatch()
        var answer = Console.readLine()

        return answer
    }
}