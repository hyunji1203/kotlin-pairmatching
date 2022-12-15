package pairmatching

import camp.nextstep.edu.missionutils.Randoms

class LittleDomain {
    fun createShuffleCrew(crewNames : MutableList<String>) : MutableList<Crew>{
        var shuffleNames = Randoms.shuffle(crewNames)
        var shuffleCrew = mutableListOf<Crew>()
        for (i in shuffleNames){
            var crew = Crew()
            crew.setCourse(Course.BACKEND)
            crew.setName(i)
            shuffleCrew.add(crew)
        }
        return shuffleCrew
    }

    fun metCrew(shuffleCrew : MutableList<Crew>, i : Int){
        //만났던 크루 넣기
        shuffleCrew[i].metPair.add(shuffleCrew[i+1])
        shuffleCrew[i+1].metPair.add(shuffleCrew[i])
    }
}