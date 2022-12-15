package pairmatching

class Crew {
    private var course: Course? = null
    private var name: String? = null

    var metPair = mutableListOf<Crew>()

    fun setCourse(course: Course){
        this.course = course
    }
    fun setName(name : String){
        this.name = name
    }

    fun getName() : String {
        return name.toString()
    }
}