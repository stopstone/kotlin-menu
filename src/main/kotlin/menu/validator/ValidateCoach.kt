package menu.validator

object ValidateCoach {
    fun coachValidate(coachNames: List<String>) {
        checkCoachNameLength(coachNames)
        checkCoachMinMaxSize(coachNames)
    }

    private fun checkCoachMinMaxSize(coachNames: List<String>) {
        require(coachNames.size in 2..5)
        {"[ERROR] 코치는 최소 2명 이상, 최대 5명으로 입력해야 합니다."}
    }

    private fun checkCoachNameLength(coachNames: List<String>) {
        coachNames.forEach { name ->
            require(name.length in 2..4)
            {"[ERROR] 코치의 이름은 2글자에서 4글자로 입력해야 합니다."}
        }
    }
}