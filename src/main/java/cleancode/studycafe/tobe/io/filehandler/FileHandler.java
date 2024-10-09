package cleancode.studycafe.tobe.io.filehandler;

import java.util.List;

import cleancode.studycafe.tobe.model.studycafelocker.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.studycafepass.StudyCafePass;

public interface FileHandler {
	String PASS_PATH = "src/main/resources/cleancode/studycafe/pass-list.csv";
	String LOCKER_PATH = "src/main/resources/cleancode/studycafe/locker.csv";

	List<StudyCafePass> readStudyCafePasses();

	List<StudyCafeLockerPass> readLockerPasses();
}
