package cleancode.studycafe.tobewb;

import java.util.List;
import java.util.Optional;

import cleancode.studycafe.tobewb.exception.AppException;
import cleancode.studycafe.tobewb.io.StudyCafeFileHandler;
import cleancode.studycafe.tobewb.io.StudyCafeIOHandler;
import cleancode.studycafe.tobewb.model.order.StudyCafePassOrder;
import cleancode.studycafe.tobewb.model.pass.locker.StudyCafeLockerPass;
import cleancode.studycafe.tobewb.model.pass.locker.StudyCafeLockerPasses;
import cleancode.studycafe.tobewb.model.pass.seat.StudyCafeSeatPass;
import cleancode.studycafe.tobewb.model.pass.StudyCafePassType;

public class StudyCafePassMachine {

	private final StudyCafeIOHandler ioHandler = new StudyCafeIOHandler();
	private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

	public void run() {
		try {
			ioHandler.showWelcomeMessage();
			ioHandler.showAnnouncement();

			StudyCafeSeatPass selectedPass = selectPass();
			Optional<StudyCafeLockerPass> optionalLockerPass = selectLockerPass(selectedPass);
			StudyCafePassOrder passOrder = StudyCafePassOrder.of(
				selectedPass,
				optionalLockerPass.orElse(null)
			);

			ioHandler.showPassOrderSummary(passOrder);

		} catch (AppException e) {
			ioHandler.showSimpleMessage(e.getMessage());
		} catch (Exception e) {
			ioHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
		}
	}

	private StudyCafeSeatPass selectPass() {

		StudyCafePassType passType = ioHandler.askPassTypeSelecting();
		List<StudyCafeSeatPass> passCandidates = findPassCandidatesBy(passType);

		return ioHandler.askPassSelecting(passCandidates);
	}

	private List<StudyCafeSeatPass> findPassCandidatesBy(StudyCafePassType studyCafePassType) {
		return studyCafeFileHandler.readStudyCafePasses().findPassBy(studyCafePassType);
	}

	private Optional<StudyCafeLockerPass> selectLockerPass(StudyCafeSeatPass selectedPass) {
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

	private Optional<StudyCafeLockerPass> findLockerPassCandidateBy(StudyCafeSeatPass pass) {
		StudyCafeLockerPasses allLockerPasses = studyCafeFileHandler.readLockerPasses();
		return allLockerPasses.findLockerPassBy(pass);
	}
}
