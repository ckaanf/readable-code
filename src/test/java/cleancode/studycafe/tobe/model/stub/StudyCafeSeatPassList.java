package cleancode.studycafe.tobe.model.stub;

import java.util.ArrayList;
import java.util.List;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;

public class StudyCafeSeatPassList {
	private static final List<StudyCafeSeatPass> seatPassList = new ArrayList<>();

	static {
		seatPassList.add(StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 2, 4000, 0.0));
		seatPassList.add(StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 4, 6500, 0.0));
		seatPassList.add(StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 6, 9000, 0.0));
		seatPassList.add(StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 8, 11000, 0.0));
		seatPassList.add(StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 10, 12000, 0.0));
		seatPassList.add(StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 12, 13000, 0.0));
		seatPassList.add(StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 1, 60000, 0.0));
		seatPassList.add(StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1));
		seatPassList.add(StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 3, 130000, 0.1));
		seatPassList.add(StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 4, 150000, 0.1));
		seatPassList.add(StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 12, 400000, 0.15));
		seatPassList.add(StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 250000, 0.1));
		seatPassList.add(StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15));
	}
	public List<StudyCafeSeatPass> getSeatPassList() {
		return seatPassList;
	}
}
