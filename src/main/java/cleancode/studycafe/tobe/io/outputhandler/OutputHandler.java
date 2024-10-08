package cleancode.studycafe.tobe.io.outputhandler;

import java.util.List;

import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;

public interface OutputHandler {

	void show(String message);

	void askLockerPass(StudyCafeLockerPass lockerPass);

	void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass);

	void showSimpleMessage(String message);
}
