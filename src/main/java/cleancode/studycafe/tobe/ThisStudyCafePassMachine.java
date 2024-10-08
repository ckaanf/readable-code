package cleancode.studycafe.tobe;

import java.util.List;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.StudyCafeFileHandler;
import cleancode.studycafe.tobe.io.inputhandler.ConsoleInputHandler;
import cleancode.studycafe.tobe.io.inputhandler.InputHandler;
import cleancode.studycafe.tobe.io.outputhandler.ConsoleOutputHandler;
import cleancode.studycafe.tobe.io.outputhandler.OutputHandler;
import cleancode.studycafe.tobe.model.StudyCafeAdmin;
import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassList;
import cleancode.studycafe.tobe.model.StudyCafePassType;

public class ThisStudyCafePassMachine implements StudyCafePassMachine {

	private final InputHandler InputHandler;
	private final OutputHandler OutputHandler;
	private StudyCafePassList studyCafePassList;
	private List<StudyCafeLockerPass> lockerPasses;

	public ThisStudyCafePassMachine() {
		InputHandler = new ConsoleInputHandler();
		OutputHandler = new ConsoleOutputHandler();

	}

    @Override
    public void service() {
        this.initialize();
        this.startup();
        this.run();
    }

	@Override
	public void initialize() {
		this.studyCafePassList = StudyCafePassList.of(StudyCafeAdmin.setupPassList());
		this.lockerPasses = StudyCafeAdmin.setupLockerPassList();
	}

	@Override
	public void startup() {
		OutputHandler.show(StudyCafeAdmin.WELLCOME);
		OutputHandler.show(StudyCafeAdmin.ANNOUNCEMENT);
	}

	@Override
	public void run() {
		try {

            StudyCafePassType studyCafePassType = selectedPassType();
            List<StudyCafePass> passes = studyCafePassList.findBy(studyCafePassType);

            StudyCafePass selectedPass = selectedStudyCafePass(passes);

            OutputHandler.showPassOrderSummary(selectedPass, null);
			if (studyCafePassType == StudyCafePassType.FIXED) {
				StudyCafeLockerPass lockerPass = lockerPasses.stream()
					.filter(option ->
						option.getPassType() == selectedPass.getPassType()
							&& option.getDuration() == selectedPass.getDuration()
					)
					.findFirst()
					.orElse(null);

				boolean lockerSelection = false;
				if (lockerPass != null) {
					OutputHandler.askLockerPass(lockerPass);
					lockerSelection = InputHandler.getLockerSelection();
				}

				if (lockerSelection) {
					OutputHandler.showPassOrderSummary(selectedPass, lockerPass);
				} else {
					OutputHandler.showPassOrderSummary(selectedPass, null);
				}
			}
		} catch (AppException e) {
			OutputHandler.showSimpleMessage(e.getMessage());
		} catch (Exception e) {
			OutputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
		}
	}

    private StudyCafePass selectedStudyCafePass(List<StudyCafePass> passes) {
        OutputHandler.show(studyCafePassList.passList(passes));
		return InputHandler.getSelectPass(passes);
    }

    private StudyCafePassType selectedPassType() {
        OutputHandler.show(StudyCafeAdmin.selectType());
        String input = InputHandler.input();
		return StudyCafePassType.getPassTypeSelectingUserAction(input);
    }

    @Override
	public void shutdown() {

	}
}
