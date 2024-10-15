package cleancode.studycafe.tobe.model.order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;

class StudyCafePassOrderTest {

	@DisplayName("좌석이용권과 사물함 이용권의 할인이 반영된 총 금액을 계산한다.")
	@Test
	void givenOrderWhenGetTotalPriceThenReturnTotalPrice() {
		// given
		StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(
			StudyCafePassType.FIXED, 30, 120000, 0.1
		);

		StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(
			StudyCafePassType.FIXED, 30, 30000
		);
		StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);

		// when
		int totalPrice = order.getTotalPrice();

		// then
		assertThat(totalPrice).isEqualTo(138000);
	}

	@DisplayName("좌석이용권의 할인이 반영된 총 금액을 계산한다.")
	@Test
	void givenOrderWithOutLockerPassWhenGetTotalPriceThenReturnTotalPrice() {
		// given
		StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(
			StudyCafePassType.FIXED, 30, 120000, 0.1
		);

		StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, null);

		// when
		int totalPrice = order.getTotalPrice();

		// then
		assertThat(totalPrice).isEqualTo(108000);
	}

	@DisplayName("반영된 할인 금액이 총 가격보다 많으면 예외를 반환한다.")
	@Test
	void givenOrderWhenGetTotalPriceThenReturnException() {
		// given
		StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(
			StudyCafePassType.FIXED, 30, 120000, 1.0
		);
		StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(
			StudyCafePassType.FIXED, 30, 30000
		);
		StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);

		// when
		int totalPrice = order.getTotalPrice();

		// then
		assertThatThrownBy(order::getTotalPrice)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("할인 금액이 총 결제 금액보다 클 수 없습니다.");
	}

	/*
	  이런 것도 테스트 해야하는 지요?
	  @Test
	  void getLockerPass() {
	   }
	 */
}
