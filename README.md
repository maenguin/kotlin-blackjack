# kotlin-blackjack

## 기능 요구사항
블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.

##실행 결과
```
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason

pobi, jason에게 2장의 나누었습니다.
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드

pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17
```

## 기능 목록
### Card
카드는 랭크와 무늬 그리고 점수를 가진다
- [x] 카드는 랭크와 무늬를 조합해 총 52장이 있다
- [x] 카드의 랭크와 무늬가 같으면 동일한 카드이다

### CardSet
카드세트는 중복없는 카드 모음이다
- [x] 카드세트에서 카드를 한장씩 뽑을 수 있다
- [x] 카드세트에서 카드를 전부 뽑았을때 다시 뽑으면 예외가 발생한다

### Deck
덱은 플레이어가 소지한 카드를 표현한다
- [x] 덱에 카드를 추가할 수 있다
- [x] 덱에 있는 카드의 점수 합계를 알 수 있다

### State
소지한 카드에 따른 상태를 표현한다
#### Begin
최초의 핸드가 구성되기 전 시작 상태를 표현한다
- [x] 시작 상태에서 카드를 두 장 받았을때 21점 미만이면 히트 상태가 된다
- [x] 시작 상태에서 카드를 두 장 받았을때 21이면 블랙잭 상태가 된다
#### Hit
카드를 두장이상 받았을때 카드를 더 받을 수 있는 상태를 표현한다
- [x] 카드를 두 장 이상 보유한 상태가 아니면 예외가 발생한다
- [x] 카드의 점수가 21점을 넘으면 예외가 발생한다
- [x] 히트 상태에서 카드를 한장 받았을때 21점 이하면 히트 상태가 된다
- [x] 히트 상태에서 카드를 한장 받았을때 21점이 초과되면 버스트 상태가 된다
- [x] 히트 상태에서 스테이를 선언하면 스테이 상태가 된다

### BlackjackCardPointCalculator
카드의 점수를 계산하는 주체이다
- [x] 블랙잭에서 카드의 점수 합계는 최대한 21을 넘지 않으면서 가장 가까운 점수로 계산된다

### Player
플레이어는 블랙잭을 플레이하는 주체이다
- [x] 플레이어는 이름을 가진다
- [x] 플레이어는 카드를 받고 점수를 계산할 수 있다
- [x] 플레이어는 카드 점수 합계가 21점을 넘으면 버스트 된다
- [x] 플레이어가 히트할 수 없을때 카드를 받으면 예외가 발생한다
- [x] 플레이어는 수익 금액을 가진다
- [x] 플레이어가 최초로 카드를 두장을 받았을때 점수가 21이면 블랙잭이다
#### Challenger
- [x] 도전자는 카드 점수 합계가 21점 이하면 히트 가능하다
- [x] 도전자가 스테이(카드를 받지 않음)를 하면 더이상 히트 할 수 없다
- [x] 도전자가 먼저 버스트 되면 패배한다
- [x] 도전자가 버스트되지 않았는데 딜러가 버스트되면 점수에 상관없이 승리한다
- [x] 도전자와 딜러 둘다 버스트되지 않았다면 점수가 큰 쪽이 승리한다
- [x] 도전자는 배팅 금액을 가진다
- [x] 도전자가 블랙잭이되면 배팅 금액의 1,5배를 돌려받는다
- [x] 도전자와 딜러 모두 블랙잭이되면 도전자는 베팅한 금액을 그대로 돌려받는다
- [x] 도전자가 딜러에게 패배할 경우 베팅 금액을 돌려받지 못한다
#### Dealer
- [x] 딜러는 카드 점수 합계가 17점 이상이면 히트할 수 없다

### BlackjackGame
블랙잭 게임은 딜러와 카드세트 그리고 여러명의 플레이어로 시작한다
- [x] 게임이 시작되면 플레이어는 두장의 카드를 받는다
- [x] 플레이어에게 추가로 카드를 전달할 수 있다

