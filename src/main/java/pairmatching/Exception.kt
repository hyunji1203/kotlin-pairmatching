package pairmatching

class Exception {
    fun noneException(pairMatching: PairMatching, wholePair : MutableList<PairMatching>){
        nonMission(pairMatching.getMission())
        noneCourse(pairMatching.getCourse())
        noneLevel(pairMatching.getLevel())
    }
    fun noneCourse(courseName : String){
        if (courseName != "백엔드" && courseName != "프론트엔드"){
            throw IllegalArgumentException("[ERROR] 없는 과정입니다.")
        }
    }
    fun noneLevel(levelName : String){
        if (levelName != "레벨1" && levelName != "레벨2" && levelName != "레벨3" && levelName != "레벨4" && levelName != "레벨5"){
            throw IllegalArgumentException("[ERROR] 없는 레벨입니다.")
        }
    }
    fun nonMission(missionName : String){
        if (missionName != "자동차경주" && missionName != "로또" && missionName != "숫자야구게임" && missionName != "장바구니"
            && missionName != "결제" && missionName != "지하철노선도" && missionName != "성능개선" && missionName != "배포"){
            throw IllegalArgumentException("[ERROR] 없는 미션입니다.")
        }
    }
}