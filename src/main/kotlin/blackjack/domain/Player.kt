package blackjack.domain

import blackjack.domain.BlackjackCardPointCalculator.BLACKJACK_POINT_THRESHOLD

/**
 * ### 블랙잭을 플레이하는 사람을 표현하는 객체 입니다.
 */
sealed class Player {
    abstract val name: String
    abstract val deck: Deck
    abstract val canHit: Boolean

    val isBurst: Boolean
        get() = BLACKJACK_POINT_THRESHOLD < getDeckPointSum()

    fun receive(card: Card) {
        check(canHit) { "Can not hit anymore" }
        deck.add(card)
    }

    fun getDeckPointSum(): Int {
        return deck.getCardPointSum()
    }
}

/**
 * ### 블랙잭 플레이어 중 딜리를 표현하는 객체입니다
 */
data class Dealer(
    override val name: String = "Dealer",
    override val deck: Deck = Deck(),
) : Player() {
    override val canHit: Boolean
        get() = getDeckPointSum() <= DEALER_HIT_THRESHOLD

    companion object {
        private const val DEALER_HIT_THRESHOLD = 16
    }
}

/**
 * ### 블랙잭 플레이어 중 딜러가 아닌 도전자를 표현하는 객체입니다
 */
data class Challenger(
    override val name: String,
    override val deck: Deck = Deck(),
) : Player() {

    private var isStay: Boolean = false
    override val canHit: Boolean
        get() = BLACKJACK_POINT_THRESHOLD >= getDeckPointSum() && isStay.not()

    fun stay() {
        isStay = true
    }

    fun isWin(dealer: Dealer): Boolean {
        if (this.isBurst) {
            return false
        }
        if (dealer.isBurst) {
            return true
        }
        return this.getDeckPointSum() > dealer.getDeckPointSum()
    }
}
