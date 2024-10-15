package cleancode.studycafe.tobe.model.pass.seat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.stub.lockerpass.StudyCafeLockerPassStub;
import cleancode.studycafe.tobe.model.stub.seatpass.StudyCafeSeatPassStub;

class StudyCafeSeatPassTest {

	@DisplayName("사물함을 사용할 수 없는 이용권인지 확인한다.")
	@Test
	void givenWhenCannotUserLockerThenReturnTrue() {
		//Given
		StudyCafeSeatPass seatPass = StudyCafeSeatPassStub.WEEKLY_SEAT_PASS;

		//When
		boolean result = seatPass.cannotUseLocker();

		//Then
		assertThat(result).isEqualTo(true);
	}

	@DisplayName("사물함을 사용할 수 있는 이용권이면 실패를 반환한다.")
	@Test
	void givenWhenCannotUserLockerThenReturnFalse() {
		//Given
		StudyCafeSeatPass seatPass = StudyCafeSeatPassStub.FIXED_SEAT_PASS;

		//When
		boolean result = seatPass.cannotUseLocker();

		//Then
		assertThat(result).isEqualTo(false);
	}

	@DisplayName("주어진 타입이 좌석 이용권의 타입과 같은 지 확인한다.")
	@Test
	void givenPassTypeWhenIsSameTypeThenReturnTrue() {
		// given
		StudyCafePassType studyCafePassType = StudyCafePassType.FIXED;
		StudyCafeSeatPass seatPass = StudyCafeSeatPassStub.FIXED_SEAT_PASS;

		// when
		boolean result = seatPass.isSamePassType(studyCafePassType);

		// then
		assertThat(result).isEqualTo(true);
	}

	@DisplayName("주어진 타입이 좌석 이용권의 타입과 다르면 실패를 반환 한다.")
	@Test
	void givenPassTypeWhenIsSameTypeThenReturnFalse() {
		// given
		StudyCafePassType studyCafePassType = StudyCafePassType.FIXED;
		StudyCafeSeatPass seatPass = StudyCafeSeatPassStub.WEEKLY_SEAT_PASS;

		// when
		boolean result = seatPass.isSamePassType(studyCafePassType);

		// then
		assertThat(result).isEqualTo(false);
	}

	@DisplayName("주어진 기간이 좌석 이용권의 기간과 같은 지 확인한다.")
	@Test
	void giveDurationWhenIsSameDurationThenReturnTrue() {
		// given
		int duration = 4;
		StudyCafeLockerPass lockerPass = StudyCafeLockerPassStub.LOCKER_PASS;

		// when
		boolean result = lockerPass.isSameDuration(duration);

		// then
		assertThat(result).isEqualTo(true);
	}

	@DisplayName("주어진 기간이 좌석 이용권의 기간과 같지 않으면 실패를 반환 한다.")
	@Test
	void giveDurationWhenIsSameDurationThenReturnFalse() {
		// given
		int duration = 10;
		StudyCafeLockerPass lockerPass = StudyCafeLockerPassStub.LOCKER_PASS;

		// when
		boolean result = lockerPass.isSameDuration(duration);

		// then
		assertThat(result).isEqualTo(false);
	}

	@DisplayName("할인된 가격을 반환한다.")
	@Test
	void givenWhenGetDiscountPriceThenReturnDiscountPrice() {
		// given
		StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(
			StudyCafePassType.WEEKLY, 4, 10000, 0.1
		);

		// when
		int result = seatPass.getDiscountPrice();

		// then
		assertThat(result).isEqualTo(1000);
	}
}
