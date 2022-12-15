package pairmatching

enum class Course (course : String) {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    fun existCourse(course: String) : Boolean {
        if (BACKEND.name != course && FRONTEND.name != course){
            return false
        }
        return true
    }
}