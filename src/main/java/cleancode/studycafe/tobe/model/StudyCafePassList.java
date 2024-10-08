package cleancode.studycafe.tobe.model;

import java.util.List;

public class StudyCafePassList {
	private final List<StudyCafePass> passList;

	public StudyCafePassList(List<StudyCafePass> passList) {
		this.passList = passList;
	}

	public static StudyCafePassList of(List<StudyCafePass> passList) {
		return new StudyCafePassList(passList);
	}

	public List<StudyCafePass> findBy(StudyCafePassType type) {
		return passList.stream()
			.filter(pass -> pass.isSameType(type))
			.toList();
	}

	public String passList(List<StudyCafePass> passList) {
		StringBuilder builder = new StringBuilder();
		builder.append("\n").append("이용권 목록").append("\n");
		for (int index = 0; index < passList.size(); index++) {
			StudyCafePass pass = passList.get(index);
			builder.append(index + 1).append(".").append(pass.display()).append("\n");
		}
		return builder.toString();
	}
}
