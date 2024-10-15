package cleancode.studycafe.tobe.model.stub.lockerpass;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;

public class StudyCafeLockerPassStub {
	public static StudyCafeLockerPass LOCKER_PASS = StudyCafeLockerPass.of(
		StudyCafePassType.FIXED, 4, 10000);
}
