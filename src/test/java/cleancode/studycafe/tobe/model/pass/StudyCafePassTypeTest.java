package cleancode.studycafe.tobe.model.pass;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafePassTypeTest {

	@DisplayName("사물함을 이용할 수 있는 이용권인지 확인한다.")
	@Test
	void givenLockerTypeWhenIsLockerTypeThenReturnTrue() {
		// given
		StudyCafePassType passType = StudyCafePassType.FIXED;

		// when
		boolean result = passType.isLockerType();

		// then
		assertThat(result).isTrue();
	}

	@DisplayName("사물함을 이용할 수 없는 이용권이면 실패를 반환한다.")
	@Test
	void givenLockerTypeWhenIsLockerTypeThenReturnFalse() {
		// given
		StudyCafePassType passType = StudyCafePassType.HOURLY;

		// when
		boolean result = passType.isLockerType();

		// then
		assertThat(result).isFalse();
	}

	@DisplayName("사물함을 이용할 수 없는 이용권인지 확인한다.")
	@Test
	void givenLockerTypeWhenIsNotLockerTypeThenReturnTrue() {
		// given
		StudyCafePassType passType = StudyCafePassType.HOURLY;

		// when
		boolean result = passType.isNotLockerType();

		// then
		assertThat(result).isTrue();
	}

	@DisplayName("사물함을 이용할 수 있는 이용권이면 실패를 반환한다.")
	@Test
	void givenLockerTypeWhenIsNotLockerTypeThenReturnFalse() {
		// given
		StudyCafePassType passType = StudyCafePassType.HOURLY;

		// when
		boolean result = passType.isLockerType();

		// then
		assertThat(result).isFalse();
	}
}
