package cleancode.studycafe.tobe.model.pass.locker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.stub.lockerpass.StudyCafeLockerPassStub;

class StudyCafeLockerPassTest {

	@DisplayName("주어진 타입이 현재 이용권의 타입과 같은 지 확인한다.")
	@Test
	void givenPassTypeWhenIsSameTypeThenReturnTrue() {
		// given
		StudyCafePassType studyCafePassType = StudyCafePassType.FIXED;
		StudyCafeLockerPass lockerPass = StudyCafeLockerPassStub.LOCKER_PASS;

		// when
		boolean result = lockerPass.isSamePassType(studyCafePassType);

		// then
		assertTrue(result);
	}

	@DisplayName("주어진 타입이 현재 이용권의 타입과 다르면 실패를 반환 한다.")
	@Test
	void givenPassTypeWhenIsSameTypeThenReturnFalse() {
		// given
		StudyCafePassType studyCafePassType = StudyCafePassType.HOURLY;
		StudyCafeLockerPass lockerPass = StudyCafeLockerPassStub.LOCKER_PASS;

		// when
		boolean result = lockerPass.isSamePassType(studyCafePassType);

		// then
		assertFalse(result);
	}

	@DisplayName("주어진 기간이 이용권의 기간과 같은 지 확인한다.")
	@Test
	void giveDurationWhenIsSameDurationThenReturnTrue() {
		// given
		int duration = 4;
		StudyCafeLockerPass lockerPass = StudyCafeLockerPassStub.LOCKER_PASS;

		// when
		boolean result = lockerPass.isSameDuration(duration);

		// then
		assertTrue(result);
	}

	@DisplayName("주어진 기간이 이용권의 기간과 같지 않으면 실패를 반환 한다.")
	@Test
	void giveDurationWhenIsSameDurationThenReturnFalse() {
		// given
		int duration = 10;
		StudyCafeLockerPass lockerPass = StudyCafeLockerPassStub.LOCKER_PASS;

		// when
		boolean result = lockerPass.isSameDuration(duration);

		// then
		assertFalse(result);
	}
}
