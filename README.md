# java-racingcar-2021

## String 클래스에 대한 학습 테스트

- [X] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
- [X] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
- [X] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
- [X] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
- [X] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
- [X] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

힌트
- assertj의 contains()
- assertj의 containsExactly()

## Set Collection에 대한 학습 테스트

- [X] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
- [X] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
    - JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
- [X] 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
    - 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.

# Step2 - 문자열 계산기

목표
- 이번 미션의 핵심은 내가 구현하는 코드에 단위 테스트를 추가하는 경험을 하는 것이다. 모든 예외 상황을 처리하기 위해 너무 복잡하게 접근하지 않아도 된다.

기능 요구사항
- [X] 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- [X] 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
- [X] 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
- [X] 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- [X] 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

분석
- 계산기는 문자열로 이루어진 계산식을 받아 사칙연산 기능을 제공한다. 
- 사칙연산은 더하기, 빼기, 곱하기, 나누기로 연산자로 이루어진다.
- 연산자는 문자열을 받아 연산자 객체를 반환한다.
  - [X] "+"를 받으면 PLUS Operator를 반환한다.
  - [X] "-"를 받으면 MINUS Operator를 반환한다.
  - [X] "*"를 받으면 MULTIPLY Operator를 반환한다.
  - [X] "/"를 받으면 DIVIDE Operator를 반환한다.
  - [X] 해당하지 않는 경우 IllegalArgumentException이 발생한다.
  - 더하기
    - 두 개의 숫자를 받아 더한 뒤 반환한다.
      - [X] 1, 2를 받으면 3을 반환한다.
      - [X] 3, 4를 받으면 7을 반환한다.
      - [X] 8, 0을 받으면 8을 반환한다.
  - 빼기
    - 두 개의 숫자를 받아 뺀 뒤 반환한다.
      - [X] 1, 2를 받으면 -1을 반환한다.
      - [X] 10, 2를 받으면 8을 반환한다.
      - [X] 5, 5를 받으면 0을 반환한다.
  - 곱하기
    - 두 개의 숫자를 받아 곱한 뒤 반환한다.
      - [X] 1, 2를 받으면 2를 반환한다.
      - [X] 4, 7을 받으면 28을 반환한다.
      - [X] 9, 0을 받으면 0을 반환한다.
  - 나누기
    - 두 개의 숫자를 받아 나눈 뒤 반환한다.
      - [X] 5, 1을 받으면 5를 반환한다.
      - [X] 6, 2를 받으면 3을 반환한다.
      - [X] 10, 5를 받으면 2를 반환한다.
      - [X] 두 번째 인자 값으로 0을 받으면 IllegalArgumentException


# Step3

초간단 자동차 경주 게임을 구현한다.
- [X] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [X] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [X] 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- [X] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

프로그래밍 요구사항
- [X] 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- [X] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- [X] UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- [X] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [X] else 예약어를 쓰지 않는다.

커밋 요구사항
- [X] 구현 전 기능 목록을 정리해 추가한다.
- [X] 기능 목록 단위로 커밋한다.
- [X] commit message convention을 지킨다.

개발 전, 요구사항 분석
- [X] 사용자로부터 이동을 시도할 횟수, 자동차 수를 받아라
  - [X] 입력 가이드를 출력하라
- [X] 자동차 수만큼 자동차를 생성하라
- [X] 시도 횟수만큼 자동차를 움직여라
- [X] 자동차의 상태를 출력하라

# Step 4 자동차 경주 (우승자)

기능 요구사항
- [X] 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- [X] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [X] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

프로그래밍 요구사항 (추가)
- [X] indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- [ ] 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- [ ] 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- [ ] 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ] 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.

개발 전, 요구사항 분석
- [X] 이름 입력을 요청하라
- [X] 이름을 받아 Cars를 생성하라
  - [X] 받은 이름을 쉼표로 분리하라
  - [X] Car 생성시 이름을 전달하라
- [ ] 이름
  - [ ] 문자열을 받아 이름을 생성하라 
  - [ ] blank 또는 6자를 받으면 에러를 throw 하라
- [ ] 우승자
  - [ ] TODO
