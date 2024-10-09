package cleancode.studycafe.tobe.model;

import java.util.List;
import java.util.Collections;

import cleancode.studycafe.tobe.io.filehandler.FileHandler;
import cleancode.studycafe.tobe.io.filehandler.StudyCafeFileHandler;
import cleancode.studycafe.tobe.model.studycafelocker.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.studycafepass.StudyCafePass;
import cleancode.studycafe.tobe.model.studycafepass.StudyCafePassType;

public class StudyCafeAdmin {
	public static final String WELLCOME = "*** 프리미엄 스터디카페 ***";
	public static final String ANNOUNCEMENT = """
		* 사물함은 고정석 선택 시 이용 가능합니다. (추가 결제)
		* !오픈 이벤트! 2주권 이상 결제 시 10% 할인, 12주권 결제 시 15% 할인! (결제 시 적용)
		""";

	private final FileHandler fileHandler;
	private static List<StudyCafePass> passList;
	private static List<StudyCafeLockerPass> lockerPassList;

	public StudyCafeAdmin() {
		this.fileHandler = new StudyCafeFileHandler();
	}

	public synchronized List<StudyCafePass> setupPassList() {
		if (passList == null) {
			passList = fileHandler.readStudyCafePasses();
			passList = Collections.unmodifiableList(passList);
		}
		return passList;
	}

	public synchronized List<StudyCafeLockerPass> setupLockerPassList() {
		if (lockerPassList == null) {
			lockerPassList = fileHandler.readLockerPasses();
			lockerPassList = Collections.unmodifiableList(lockerPassList);
		}
		return lockerPassList;
	}

	public static String selectType() {
		StringBuilder builder = new StringBuilder();
		for (int index = 0; index < StudyCafePassType.values().length; index++) {
			StudyCafePassType type = StudyCafePassType.values()[index];
			builder.append(index + 1).append(". ").append(type.getDescription()).append(" | ");
		}
		builder.replace(builder.length() - 3, builder.length(), "");
		return builder.toString();
	}
}
