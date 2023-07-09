package blackjack.view

import blackjack.domain.Challengers
import blackjack.domain.Dealer
import blackjack.domain.Player

class ResultView {
    fun outputInitialHand(challengers: Challengers, dealer: Dealer) {
        println("딜러와 ${challengers.joinToString { it.name }}에게 2장씩 나누었습니다.")
        println("딜러: ${dealer.deck.cards.last()}")
        challengers.forEach { challenger ->
            println("${challenger.name}카드: ${getAllHandString(challenger)}")
        }
    }

    fun outputCurrentHand(player: Player) {
        println(getAllHandString(player))
    }

    fun outputGameResult(challengers: Challengers, dealer: Dealer) {
        println()
        println("딜러 카드: ${getAllHandString(dealer)} ${dealer.getDeckPointSum()}")
        challengers.forEach { challenger ->
            println("${challenger.name}카드: ${getAllHandString(challenger)} ${challenger.getDeckPointSum()}")
        }

        println("## 최종 승패")
        val dealerLooseCount = challengers.count { it.isWin(dealer) }
        val dealerWinCount = challengers.size - dealerLooseCount
        println("딜러: ${dealerWinCount}승 ${dealerLooseCount}패")
        challengers.forEach { challenger ->
            println("${challenger.name}: ${ if (challenger.isWin(dealer)) "승" else "패" }")
        }
    }

    fun outputDealerDeal() {
        println("딜러는 16이하라 한장의 카드를 더받았습니다.")
    }

    private fun getAllHandString(player: Player): String {
        return player.deck.cards.joinToString { it.toString() }
    }
}
