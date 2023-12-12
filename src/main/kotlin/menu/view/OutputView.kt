package menu.view

import menu.domain.Category
import menu.domain.Coach

class OutputView {
    fun printServiceStartMessage() {
        println("점심 메뉴 추천을 시작합니다.")
        println()
    }

    fun readCoachNamesMessage() {
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
    }

    fun readCantEatMenusMessage(name: String) {
        println("${name}(이)가 못 먹는 메뉴를 입력해 주세요.")
    }

    fun printWeekday() {
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
    }

    fun printCategory(weekdayOfRecommend: MutableList<Category>) {
        print("[ 카테고리 ")
        weekdayOfRecommend.forEach {
            print("| ${it.category} ")
        }
        println("]")
    }

    fun printRecommendMenu(coaches: MutableList<Coach>) {
        coaches.forEach { coach ->
            print("[ ${coach.getName()} ")
            println("| ${coach.getRecommendMenus().joinToString(" | ")}]")
        }

    }

    fun printResultRecommend() {
        println("메뉴 추천 결과입니다..")
    }
    fun printServiceEndMessage() {
        println()
        println("추천을 완료했습니다.")
    }

}