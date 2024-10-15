package cleancode.studycafe.tobe.model.stub;

import java.util.List;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;

public class StudyCafeLockerPassStubList {
	public static List<StudyCafeLockerPass> getLockerPassList() {
		return List.of(
			StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 10000),
			StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000)
		);
	}
}
