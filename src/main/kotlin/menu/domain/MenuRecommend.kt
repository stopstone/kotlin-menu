package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class MenuRecommend {
    private val weekCategory = mutableListOf<Category>()

    init {
        weekdayOfCategory()
    }
    private fun weekdayOfCategory() {
        while (weekCategory.size != 5) {
            val menu = dayOfRecommend()
            if (checkDuplicateCategory(menu)) {
                weekCategory.add(menu)
            }
        }
    }

    private fun checkDuplicateCategory(menu: Category): Boolean {
        return !weekCategory.contains(menu)
    }

    private fun dayOfRecommend(): Category {
        return when (chooseCategory()) {
            1 -> Category.JAPANESE
            2 -> Category.KOREAN
            3 -> Category.CHINESE
            4 -> Category.ASIAN
            5 -> Category.AMERICAN
            else -> throw IllegalArgumentException()
        }
    }

    private fun chooseCategory(): Int {
        return Randoms.pickNumberInRange(1,5)
    }


    fun getWeekdayCategory() = weekCategory
}