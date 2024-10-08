package cleancode.studycafe.tobe.model;

import cleancode.studycafe.tobe.exception.AppException;

public enum StudyCafePassType {

	HOURLY("시간 이용권(자유석)"),
	WEEKLY("주단위 이용권(자유석)"),
	FIXED("1인 고정석");


	private final String description;

	StudyCafePassType( String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static StudyCafePassType getPassTypeSelectingUserAction(String input) {
		try {
			return StudyCafePassType.values()[Integer.parseInt(input) - 1];
		} catch (RuntimeException e) {
			throw new AppException("잘못된 입력입니다.");
		}
	}
}
