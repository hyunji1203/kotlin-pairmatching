package pairmatching

enum class Level(name : String) {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    fun existLevel(level: String) : Boolean {
        if (LEVEL1.name != level && LEVEL2.name != level && LEVEL3.name != level && LEVEL4.name != level && LEVEL5.name != level){
            return false
        }
        return true
    }
}