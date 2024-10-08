package cleancode.studycafe.tobe.io.inputhandler;

import java.util.List;

import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;

public interface InputHandler {

	String input();

	StudyCafePassType getPassTypeSelectingUserAction();

	StudyCafePass getSelectPass(List<StudyCafePass> passes);

	boolean getLockerSelection();
}
