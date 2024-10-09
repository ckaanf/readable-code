package cleancode.studycafe.tobe.model.studycafelocker;

import java.util.List;

import cleancode.studycafe.tobe.model.studycafepass.StudyCafePass;

public class StudyCafeLockerPassList {
	private final List<StudyCafeLockerPass> studyCafeLockerPassList;

	public StudyCafeLockerPassList(List<StudyCafeLockerPass> studyCafeLockerPassList) {
		this.studyCafeLockerPassList = studyCafeLockerPassList;
	}
	public static StudyCafeLockerPassList of(List<StudyCafeLockerPass> studyCafeLockerPassList) {
		return new StudyCafeLockerPassList(studyCafeLockerPassList);
	}

	public StudyCafeLockerPass findBy(StudyCafePass pass) {
		return studyCafeLockerPassList.stream()
			.filter(option ->
				option.getPassType() == pass.getPassType() && option.getDuration() == pass.getDuration())
			.findFirst()
			.orElse(null);
	}
}
