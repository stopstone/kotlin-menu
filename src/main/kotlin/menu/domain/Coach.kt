package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class Coach(private val name: String, private val cantEatMenu: List<String>, private val weekdayCategory: MutableList<Category>) {
    private val recommendMenus = mutableListOf<String>()

    fun coachToChooseMenu(day: Category): MutableList<String> {
        val menu = chooseRecommendMenu(day)
        if (checkDuplicateRecommend(menu)) {
            recommendMenus.add(menu)
        }
        return recommendMenus
    }

    private fun chooseRecommendMenu(recommendMenu: Category): String {
        var menu: String
        do {
            menu = Randoms.shuffle(recommendMenu.menu)[0]
        } while (cantEatMenu.contains(menu))
        return menu
    }

    private fun checkDuplicateRecommend(menu: String): Boolean {
        return !recommendMenus.contains(menu)
    }

    fun getName() = name

    fun getRecommendMenus() = recommendMenus

}