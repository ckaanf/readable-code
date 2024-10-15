package cleancode.studycafe.tobe.io.provider;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPasses;

class SeatPassFileReaderTest {

	@DisplayName("외부에서 좌석 이용권 리스트를 정상적으로 가져왔는지 확인한다.")
	@Test
	void getSeatPasses() {
		// given
		SeatPassFileReader fileReader = new SeatPassFileReader();

		// when
		StudyCafeSeatPasses seatPasses = fileReader.getSeatPasses();

		// then
		// assertDoesNotThrow 파일을 잘 읽었다는 뉘앙스로 작성
		assertThat(seatPasses).isNotNull();

		//
		assertThatCode(fileReader::getSeatPasses).doesNotThrowAnyException();
	}
}
