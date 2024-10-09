package cleancode.studycafe.tobe.io.inputhandler;

import java.util.List;

import cleancode.studycafe.tobe.model.studycafepass.StudyCafePass;
import cleancode.studycafe.tobe.model.studycafepass.StudyCafePassType;

public interface InputHandler {

	String input();

	StudyCafePassType getPassTypeSelectingUserAction();

	StudyCafePass getSelectPass(List<StudyCafePass> passes);

	boolean getLockerSelection();
}
