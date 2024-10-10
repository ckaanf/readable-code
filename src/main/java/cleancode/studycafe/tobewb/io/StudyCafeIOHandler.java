package cleancode.studycafe.tobewb.io;

import java.util.List;

import cleancode.studycafe.tobewb.model.StudyCafeLockerPass;
import cleancode.studycafe.tobewb.model.StudyCafePass;
import cleancode.studycafe.tobewb.model.StudyCafePassType;

public class StudyCafeIOHandler {
	private final InputHandler inputHandler = new InputHandler();
	private final OutputHandler outputHandler = new OutputHandler();

	public void showWelcomeMessage() {
		outputHandler.showWelcomeMessage();
	}

	public void showAnnouncement() {
		outputHandler.showAnnouncement();
	}

	public void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass) {
		outputHandler.showPassOrderSummary(selectedPass, lockerPass);
	}

	public void showPassOrderSummary(StudyCafePass selectedPass) {
		outputHandler.showPassOrderSummary(selectedPass, null);
	}

	public void showSimpleMessage(String message) {
		outputHandler.showSimpleMessage(message);
	}

	public StudyCafePassType askPassTypeSelecting() {
		outputHandler.askPassTypeSelection();
		return inputHandler.getPassTypeSelectingUserAction();
	}

	public StudyCafePass askPassSelecting(List<StudyCafePass> passCandidates) {
		outputHandler.showPassListForSelection(passCandidates);
		return inputHandler.getSelectPass(passCandidates);
	}

	public boolean askLockerPass(StudyCafeLockerPass lockerPassCandidate) {
		outputHandler.askLockerPass(lockerPassCandidate);
		return inputHandler.getLockerSelection();
	}
}
