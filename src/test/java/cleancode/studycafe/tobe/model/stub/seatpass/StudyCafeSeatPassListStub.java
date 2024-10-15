package cleancode.studycafe.tobe.model.stub.seatpass;

import java.util.List;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;

public class StudyCafeSeatPassListStub {
	public static List<StudyCafeSeatPass> getSeatPassList() {
		return List.of(
			StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 2, 4000, 0.0),
			StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 4, 6500, 0.0),
			StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 6, 9000, 0.0),
			StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 1, 60000, 0.0),
			StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1),
			StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 3, 130000, 0.1),
			StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 250000, 0.1),
			StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15)
		);
	}
}
