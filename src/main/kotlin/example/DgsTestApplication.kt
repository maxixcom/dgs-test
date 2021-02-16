package example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DgsTestApplication

fun main(args: Array<String>) {
    runApplication<DgsTestApplication>(*args)
}
