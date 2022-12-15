package pairmatching.UI

import pairmatching.Course
import pairmatching.Level
import pairmatching.PairMatching

class OutputView {
    fun menu(){
        println("기능을 선택하세요.\n" +
                "1. 페어 매칭\n" +
                "2. 페어 조회\n" +
                "3. 페어 초기화\n" +
                "Q. 종료")
    }

    fun example(){
        println("#############################################\n" +
                "과정: ${Course.BACKEND} | ${Course.FRONTEND}\n" +
                "미션:\n" + "  - ${Level.LEVEL1}: 자동차경주 | 로또 | 숫자야구게임\n" +
                "  - ${Level.LEVEL2}: 장바구니 | 결제 | 지하철노선도\n" +
                "  - ${Level.LEVEL3}: \n" +
                "  - ${Level.LEVEL4}: 성능개선 | 배포\n" +
                "  - ${Level.LEVEL5}: \n" +
                "############################################\n" +
                "과정, 레벨, 미션을 선택하세요.\n" +
                "ex) 백엔드, 레벨1, 자동차경주")
    }

    fun retryMatch(){
        println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" +
                "네 | 아니오")
    }

    fun pairMatchResult(pairMatching : PairMatching){
        println("페어 매칭 결과입니다.")
        if (pairMatching.even == 1){
            for (i in pairMatching.pair){ println("${i[0].getName()} : ${i[1].getName()}") }
        }
        if (pairMatching.even == 0){
            for (i in pairMatching.pair){
                if (i.size == 3) println("${i[0].getName()} : ${i[1].getName()} : ${i[2].getName()}")
                if (i.size == 2 ) println("${i[0].getName()} : ${i[1].getName()}")
            }
        }
        println("")
    }

    fun init(){
        println("초기화 되었습니다. ")
    }
}