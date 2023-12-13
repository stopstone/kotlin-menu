package menu.controller

import menu.domain.Coach
import menu.domain.MenuRecommend
import menu.validator.ValidateCoach.coachValidate
import menu.view.InputView
import menu.view.OutputView

class MenuController {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val menuRecommend = MenuRecommend()

    private var coaches = mutableListOf<Coach>()

    init {
        outputView.printServiceStartMessage()
    }

    fun programRun() {
        val coachNames = readCoachNames()
        val cantEatMenus = readCantEatMenus(coachNames)
        createCoachItems(coachNames, cantEatMenus)
        outputView.printResultRecommend()
        outputView.printWeekday()
        outputView.printCategory(menuRecommend.getWeekdayCategory())
        outputView.printRecommendMenu(coaches)
        outputView.printServiceEndMessage()
    }


    private fun readCoachNames(): List<String> {
        outputView.readCoachNamesMessage()
        val coachNames = inputView.readCoachNames()
        coachValidate(coachNames)
        return coachNames
    }

    private fun readCantEatMenus(coachNames: List<String>): MutableList<List<String>> {
        val cantEatMenus = mutableListOf<List<String>>()
        coachNames.forEach { name ->
            outputView.readCantEatMenusMessage(name)
            cantEatMenus.add(inputView.readCantEatMenus())
        }
        return cantEatMenus
    }

    private fun createCoachItems(coachNames: List<String>, cantEatMenus: MutableList<List<String>>) {
        for (idx in coachNames.indices) {
            coaches.add(Coach(coachNames[idx], cantEatMenus[idx], menuRecommend))
        }
    }
}