package cleancode.studycafe.tobe.model.machine;

import java.util.List;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.inputhandler.ConsoleInputHandler;
import cleancode.studycafe.tobe.io.inputhandler.InputHandler;
import cleancode.studycafe.tobe.io.outputhandler.ConsoleOutputHandler;
import cleancode.studycafe.tobe.io.outputhandler.OutputHandler;
import cleancode.studycafe.tobe.model.StudyCafeAdmin;
import cleancode.studycafe.tobe.model.studycafelocker.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.studycafelocker.StudyCafeLockerPassList;
import cleancode.studycafe.tobe.model.studycafepass.StudyCafePass;
import cleancode.studycafe.tobe.model.studycafepass.StudyCafePassList;
import cleancode.studycafe.tobe.model.studycafepass.StudyCafePassType;
import cleancode.studycafe.tobe.model.StudyCafeTicket;

public class ThisStudyCafePassMachine implements StudyCafePassMachine {

	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;
	private StudyCafePassList passList;
	private StudyCafeLockerPassList lockerPassList;

	public ThisStudyCafePassMachine() {
		this.inputHandler = new ConsoleInputHandler();
		this.outputHandler = new ConsoleOutputHandler();
	}

	@Override
	public void initialize(StudyCafeAdmin admin) {
		this.passList = StudyCafePassList.of(admin.setupPassList());
		this.lockerPassList = StudyCafeLockerPassList.of(admin.setupLockerPassList());
	}

	@Override
	public void startup() {
		outputHandler.show(StudyCafeAdmin.WELLCOME);
		outputHandler.show(StudyCafeAdmin.ANNOUNCEMENT);
	}

	@Override
	public void run() {
		try {
			StudyCafeTicket ticket = createTicket();
			outputHandler.show(ticket.ticketSummary());
		} catch (AppException e) {
			outputHandler.showSimpleMessage(e.getMessage());
		} catch (Exception e) {
			outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
		}
	}

	@Override
	public void shutdown() {
	}

	private StudyCafeTicket createTicket() {
		StudyCafePassType studyCafePassType = selectPassType();
		List<StudyCafePass> passes = passList.findBy(studyCafePassType);
		StudyCafePass selectedPass = selectStudyCafePass(passes);
		StudyCafeLockerPass lockerPass = lockerPassList.findBy(selectedPass);
		activateLocker(lockerPass);
		return StudyCafeTicket.of(selectedPass, lockerPass);
	}

	private StudyCafePassType selectPassType() {
		outputHandler.show(StudyCafeAdmin.selectType());
		String input = inputHandler.input();
		return StudyCafePassType.getPassTypeSelectingUserAction(input);
	}

	private StudyCafePass selectStudyCafePass(List<StudyCafePass> passes) {
		outputHandler.show(passList.passList(passes));
		return inputHandler.getSelectPass(passes);
	}

	private void activateLocker(StudyCafeLockerPass lockerPass) {
		outputHandler.show(lockerPass.askLockerPass());
		String input = inputHandler.input();
		lockerPass.useLocker(input);
	}
}

