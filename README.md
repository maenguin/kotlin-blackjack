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
- [x] 카드는 랭크와 무늬 그리고 점수를 가진다 - Card
  - [x] 카드는 랭크와 무늬를 조합해 총 52장이 있다
- [x] 카드세트는 중복없는 카드 모음이다 - CardSet
  - [x] 카드세트에서 카드를 한장씩 뽑을 수 있다
- [x] 블랙잭에서 카드의 점수 합계는 최대한 21을 넘지 않으면서 가장 가까운 점수로 계산된다 - ?
- [ ] 플레이어는 카드를 가진다 - Player
- [ ] 딜러는 카드를 가진다 - Dealer
- [ ] 딜러는 카드세트에서 카드를 뽑아서 플레이어나 자신에게 줄 수 있다
- [ ] 블랙잭 게임은 딜러와 카드세트 그리고 여러명의 플레이어로 시작한다 - BlackjackGame
- [ ] 21을 넘는 경우 무조건 패배한다
- [ ] 21에 가장 가까운 플레이어가 승리한다
- [ ] 21을 넘지 않을 경우 카드를 계속 뽑을 수 있다 
