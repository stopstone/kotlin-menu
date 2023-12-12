package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.validator.ValidateMenu.menuValidate

class InputView {
    fun readCoachNames(): List<String> {
        val coachNames =  Console.readLine()
        println()
        return coachNames.split(",")
    }

    fun readCantEatMenus(): List<String> {
        while (true) {
            try {
                val cantEatMenus = Console.readLine()
                println()
                return menuValidate(cantEatMenus.split(","))
            } catch (e:IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}