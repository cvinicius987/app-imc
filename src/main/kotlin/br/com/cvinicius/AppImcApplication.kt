package br.com.cvinicius

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppImcApplication

fun main(args: Array<String>) {
	runApplication<AppImcApplication>(*args)
}
