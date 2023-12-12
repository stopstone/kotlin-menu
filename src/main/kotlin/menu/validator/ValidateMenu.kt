package menu.validator

object ValidateMenu {
    fun menuValidate(cantEatMenus: List<String>): List<String> {
        checkCantEatSize(cantEatMenus)
        return cantEatMenus
    }

    private fun checkCantEatSize(cantEatMenus: List<String>) {
        require(cantEatMenus.size in 0..2)
        {"[ERROR] 못 먹는 음식은 최소 0개에서 최대 2개 입력해야 합니다."}
    }
}