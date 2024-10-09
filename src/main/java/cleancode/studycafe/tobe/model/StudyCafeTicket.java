package cleancode.studycafe.tobe.model;

import cleancode.studycafe.tobe.model.studycafelocker.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.studycafepass.StudyCafePass;

public class StudyCafeTicket {
	private final StudyCafePass studyCafePass;
	private final StudyCafeLockerPass studyCafeLockerPass;

	public StudyCafeTicket(StudyCafePass studyCafePass, StudyCafeLockerPass studyCafeLockerPass) {
		this.studyCafePass = studyCafePass;
		this.studyCafeLockerPass = studyCafeLockerPass;
	}

	public static StudyCafeTicket of (StudyCafePass studyCafePass, StudyCafeLockerPass studyCafeLockerPass) {
		return new StudyCafeTicket(studyCafePass, studyCafeLockerPass);
	}


	public String ticketSummary() {
		StringBuilder builder = new StringBuilder();

		builder.append(showStudyCafePassSummary());

		if (studyCafeLockerPass.isActive()) {
			builder.append(showStudyCafeLockerPassSummary());
		}

		if (studyCafePass.getDiscountPrice() > 0) {
			 builder.append(hasEvent());
		}

		builder.append(showTotalSummary());

		return builder.toString();
	}

	private String showStudyCafePassSummary() {
		return String.format("""
			이용내역
			이용권: %s
			""", studyCafePass.display());
	}

	private String showStudyCafeLockerPassSummary() {
		return "사물함: " + studyCafeLockerPass.display() + "\n";
	}

	private String hasEvent() {
		return "이벤트 할인 금액 :" +studyCafePass.getDiscountPrice() + "원\n";
	}
	private String showTotalSummary() {
		int totalPrice =
			studyCafePass.getPrice() - studyCafePass.getDiscountPrice() + (studyCafeLockerPass != null ? studyCafeLockerPass.getPrice() :
				0);
		return "총 결제 금액: " + totalPrice + "원\n";
	}
}
