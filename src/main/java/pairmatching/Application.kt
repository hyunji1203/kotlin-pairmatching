package pairmatching

import pairmatching.UI.InputView
import pairmatching.UI.OutputView


fun main() {
    var wholePair = Lookup().wholePair
    var menu = ""
    while (menu != "Q") {
        menu = InputView().menu()
        if (menu == "1") wholePair = GameController().menu1(wholePair)
        if (menu == "2") GameController().menu2(wholePair)
        if (menu == "3"){
            OutputView().init()
            wholePair.clear()
        }
    }
}

