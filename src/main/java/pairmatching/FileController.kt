package pairmatching

import java.nio.file.Files
import java.nio.file.Paths

class FileController {
    fun readBackendFile() : MutableList<String> {
        var result = mutableListOf<String>()
        val path = Paths.get("C:\\Users\\LG Gram15\\kotlin-pairmatching\\src\\main\\resources\\backend-crew.md")
        Files.lines(path, Charsets.UTF_8).forEach { result.add(it) }
        return result
    }

    fun readFrontendFile() : MutableList<String> {
        var result = mutableListOf<String>()
        val path = Paths.get("C:\\Users\\LG Gram15\\kotlin-pairmatching\\src\\main\\resources\\frontend-crew.md")
        Files.lines(path, Charsets.UTF_8).forEach { result.add(it) }
        return result
    }
}