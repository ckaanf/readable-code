package cleancode.studycafe.tobe.model.pass.seat;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPasses;
import cleancode.studycafe.tobe.model.stub.seatpass.StudyCafeSeatPassListStub;

class StudyCafeSeatPassesTest {

	@DisplayName("좌석 이용권 리스트에서 타입이 같은 좌석 이용권들을 찾는다.")
	@Test
	void givenStudyCafePassTypeWhenFindPassByThenReturnStudyCafeSeatList() {
		// given
		StudyCafePassType studyCafePassType = StudyCafePassType.FIXED;
		// TODO StudyCafeSeatPasses 객체 생성에 대한 것을 어떻게 다룰지?
		StudyCafeSeatPasses studyCafeSeatPasses = StudyCafeSeatPasses.of(StudyCafeSeatPassListStub.getSeatPassList());

		// when
		List<StudyCafeSeatPass> studyCafeSeatPassList = studyCafeSeatPasses.findPassBy(studyCafePassType);

		// then
		assertThat(studyCafeSeatPassList.size()).isEqualTo(2);
		assertThat(studyCafeSeatPassList).extracting(StudyCafeSeatPass::getPassType).containsOnly(studyCafePassType);
	}

	@DisplayName("좌석 이용권 리스트에 같은 타입이 없으면 빈 리스트를 반환한다.")
	@Test
	void givenStudyCafePassTypeWhenFindPassByThenReturnEmptyList() {
		// given
		StudyCafePassType studyCafePassType = StudyCafePassType.FIXED;
		StudyCafeSeatPasses studyCafeSeatPasses = StudyCafeSeatPasses.of(List.of(
			StudyCafeSeatPass.of(null, 10, 10000, 0.0)
		));

		// when
		List<StudyCafeSeatPass> studyCafeSeatPassList = studyCafeSeatPasses.findPassBy(studyCafePassType);

		// then
		assertThat(studyCafeSeatPassList).isEmpty();
	}
}
