package cleancode.studycafe.tobe.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudyCafeAdmin {
	public static final String WELLCOME = "*** 프리미엄 스터디카페 ***";
	public static final String ANNOUNCEMENT = """
		* 사물함은 고정석 선택 시 이용 가능합니다. (추가 결제)
		* !오픈 이벤트! 2주권 이상 결제 시 10% 할인, 12주권 결제 시 15% 할인! (결제 시 적용)
		
		""";

	public static String selectType() {
		StringBuilder builder = new StringBuilder();
		for (int index = 0; index < StudyCafePassType.values().length; index++) {
			StudyCafePassType type = StudyCafePassType.values()[index];
			builder.append(index + 1).append(". ").append(type.getDescription()).append(" | ");
		}
		builder.replace(builder.length() - 3, builder.length(), "");
		return builder.toString();
	}

	private static List<StudyCafePass> passList = null;

	public static List<StudyCafePass> setupPassList() {
		if (passList == null) {
			try {
				List<String> lines = Files.readAllLines(
					Paths.get("src/main/resources/cleancode/studycafe/pass-list.csv"));
				List<StudyCafePass> studyCafePasses = new ArrayList<>();
				for (String line : lines) {
					String[] values = line.split(",");
					StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
					int duration = Integer.parseInt(values[1]);
					int price = Integer.parseInt(values[2]);
					double discountRate = Double.parseDouble(values[3]);

					StudyCafePass studyCafePass = StudyCafePass.of(studyCafePassType, duration, price, discountRate);
					studyCafePasses.add(studyCafePass);
				}

				return studyCafePasses;
			} catch (IOException e) {
				throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
			}
		}
		return passList;
	}

	private static List<StudyCafeLockerPass> lockerPassList = null;

	public static List<StudyCafeLockerPass> setupLockerPassList() {
		if (lockerPassList == null) {
			try {
				List<String> lines = Files.readAllLines(Paths.get("src/main/resources/cleancode/studycafe/locker.csv"));
				List<StudyCafeLockerPass> lockerPasses = new ArrayList<>();
				for (String line : lines) {
					String[] values = line.split(",");
					StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
					int duration = Integer.parseInt(values[1]);
					int price = Integer.parseInt(values[2]);

					StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(studyCafePassType, duration, price);
					lockerPasses.add(lockerPass);
				}

				return lockerPasses;
			} catch (IOException e) {
				throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
			}
		}
		return lockerPassList;
	}
}
