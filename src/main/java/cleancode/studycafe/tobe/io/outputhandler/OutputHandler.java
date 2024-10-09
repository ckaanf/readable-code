package cleancode.studycafe.tobe.io.outputhandler;

import cleancode.studycafe.tobe.model.studycafelocker.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.studycafepass.StudyCafePass;

public interface OutputHandler {

	void show(String message);

	void askLockerPass(StudyCafeLockerPass lockerPass);

	void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass);

	void showSimpleMessage(String message);
}
