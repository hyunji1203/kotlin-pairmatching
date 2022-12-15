package pairmatching

class PairMatching {
    private var course = ""
    private var level = ""
    private var mission = ""

    var pair = mutableListOf<MutableList<Crew>>()
    var even = 1

    fun setCourse(course : String){
        this.course = course
    }
    fun setLevel(level : String){
        this.level = level
    }
    fun setMission(mission : String){
        this.mission = mission
    }

    fun getCourse() : String{
        return this.course
    }
    fun getLevel() : String{
        return this.level
    }
    fun getMission() : String{
        return this.mission
    }

    fun compare(){

    }
}