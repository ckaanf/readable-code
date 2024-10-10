package cleancode.studycafe.tobewb;

import java.util.List;
import java.util.Optional;

import cleancode.studycafe.tobewb.exception.AppException;
import cleancode.studycafe.tobewb.io.StudyCafeFileHandler;
import cleancode.studycafe.tobewb.io.StudyCafeIOHandler;
import cleancode.studycafe.tobewb.model.StudyCafeLockerPass;
import cleancode.studycafe.tobewb.model.StudyCafeLockerPasses;
import cleancode.studycafe.tobewb.model.StudyCafePass;
import cleancode.studycafe.tobewb.model.StudyCafePassType;

public class StudyCafePassMachine {

	private final StudyCafeIOHandler ioHandler = new StudyCafeIOHandler();
	private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

	public void run() {
		try {
			ioHandler.showWelcomeMessage();
			ioHandler.showAnnouncement();

			StudyCafePass selectedPass = selectPass();
			Optional<StudyCafeLockerPass> optionalLockerPass = selectLockerPass(selectedPass);
			optionalLockerPass.ifPresentOrElse(
				lockerPass -> ioHandler.showPassOrderSummary(selectedPass, lockerPass),
				() -> ioHandler.showPassOrderSummary(selectedPass)
			);

		} catch (AppException e) {
			ioHandler.showSimpleMessage(e.getMessage());
		} catch (Exception e) {
			ioHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
		}
	}

	private StudyCafePass selectPass() {

		StudyCafePassType passType = ioHandler.askPassTypeSelecting();
		List<StudyCafePass> passCandidates = findPassCandidatesBy(passType);

		return ioHandler.askPassSelecting(passCandidates);
	}

	private List<StudyCafePass> findPassCandidatesBy(StudyCafePassType studyCafePassType) {
		return studyCafeFileHandler.readStudyCafePasses().findPassBy(studyCafePassType);
	}

	private Optional<StudyCafeLockerPass> selectLockerPass(StudyCafePass selectedPass) {
		// TODO 고정 좌석 타입이 아닌가?
		// 사물함 옵션을 사용할 수 있는 타입이 아닌가?
		if (selectedPass.cannotUseLocker()) {
			return Optional.empty();
		}

		//NPE 방지
		Optional<StudyCafeLockerPass> lockerPassCandidate = findLockerPassCandidateBy(selectedPass);

		if (lockerPassCandidate.isPresent()) {
			StudyCafeLockerPass lockerPass = lockerPassCandidate.get();

			boolean isLockerSelected = ioHandler.askLockerPass(lockerPass);
			if (isLockerSelected) {
				return Optional.of(lockerPass);
			}
		}
		return Optional.empty();
	}

	private Optional<StudyCafeLockerPass> findLockerPassCandidateBy(StudyCafePass pass) {
		StudyCafeLockerPasses allLockerPasses = studyCafeFileHandler.readLockerPasses();
		return allLockerPasses.findLockerPassBy(pass);
	}
}
