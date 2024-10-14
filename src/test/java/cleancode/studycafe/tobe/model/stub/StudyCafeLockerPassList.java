package cleancode.studycafe.tobe.model.stub;

import java.util.List;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;

public class StudyCafeLockerPassList {
	private static final List<StudyCafeLockerPass> lockerPassList = List.of(
		StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 10000),
		StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000)
	);

	public List<StudyCafeLockerPass> getLockerPassList() {
		return lockerPassList;
	}
}
