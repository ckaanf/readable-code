package cleancode.studycafe.tobe.io.provider;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPasses;

class LockerPassFileReaderTest {

	@DisplayName("외부에서 좌석 이용권 리스트를 정상적으로 가져왔는지 확인한다.")
	@Test
	void givenFilerReaderWhenGetLockerPassesThenReturnNoExceptions() {
		// given
		LockerPassFileReader fileReader = new LockerPassFileReader();

		// when
		StudyCafeLockerPasses lockerPass = fileReader.getLockerPasses();

		// then
		assertThat(lockerPass).isNotNull();
		assertThatCode(fileReader::getLockerPasses).doesNotThrowAnyException();
	}
}
