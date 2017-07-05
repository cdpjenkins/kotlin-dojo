package dojo

import java.io.BufferedReader;
import java.io.InputStreamReader;

fun main(args: Array<String>) {
        val game =  Game()

        val stdIn =  BufferedReader(InputStreamReader(System.`in`))
        val out = System.out
        val ui = ConsoleUI(game, ::readLine, out::println)

        ui.run()
}

