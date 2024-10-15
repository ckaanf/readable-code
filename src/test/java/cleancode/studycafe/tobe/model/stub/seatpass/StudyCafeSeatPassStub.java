package cleancode.studycafe.tobe.model.stub.seatpass;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;

public class StudyCafeSeatPassStub {
	public static StudyCafeSeatPass FIXED_SEAT_PASS = StudyCafeSeatPass.of(
		StudyCafePassType.FIXED, 0, 0, 0.0);

	public static StudyCafeSeatPass HOURLY_SEAT_PASS = StudyCafeSeatPass.of(
		StudyCafePassType.HOURLY, 0, 0, 0.0);

	public static StudyCafeSeatPass WEEKLY_SEAT_PASS = StudyCafeSeatPass.of(
		StudyCafePassType.WEEKLY, 4, 10000, 0.1);
}
