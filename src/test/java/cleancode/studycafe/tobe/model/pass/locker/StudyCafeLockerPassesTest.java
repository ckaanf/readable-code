package cleancode.studycafe.tobe.model.pass.locker;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.stub.StudyCafeLockerPassStubList;

class StudyCafeLockerPassesTest {

	@DisplayName("사물함 이용권에서 좌석 이용권과 기간이 같은 이용권을 찾는다.")
	@Test
	void findLockerPassBy() {
		// given
		StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 250000, 0.1);
		StudyCafeLockerPasses studyCafeLockerPasses = StudyCafeLockerPasses.of(
			StudyCafeLockerPassStubList.getLockerPassList());

		// when
		Optional<StudyCafeLockerPass> studyCafeLockerPass = studyCafeLockerPasses.findLockerPassBy(seatPass);

		// then
		// Optional 객체 있는 지 먼저 검증하고 그 다음에 있으면 안에 값 검증 체이닝으로
		assertThat(studyCafeLockerPass.get().getDuration()).isEqualTo(seatPass.getDuration());

		assertThat(studyCafeLockerPass).isNotEmpty()
			.get()
			.extracting(StudyCafeLockerPass::getDuration)
			.isEqualTo(seatPass.getDuration());
	}

	@DisplayName("좌석 이용권과 동일한 기간을 가진 사물함 이용권이 없으면 빈 Optional 객체를 반환한다.")
	@Test
	void shouldReturnEmptyOptionalWhenNoLockerPassMatchesSeatPassPeriod() {
		// given
		StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 4, 250000, 0.1);
		StudyCafeLockerPasses studyCafeLockerPasses = StudyCafeLockerPasses.of(
			StudyCafeLockerPassStubList.getLockerPassList());

		// when
		Optional<StudyCafeLockerPass> studyCafeLockerPass = studyCafeLockerPasses.findLockerPassBy(seatPass);

		// then
		assertThat(studyCafeLockerPass).isEmpty();
	}
}
