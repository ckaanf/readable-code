package cleancode.studycafe.tobewb.io;

import cleancode.studycafe.tobewb.model.pass.locker.StudyCafeLockerPasses;
import cleancode.studycafe.tobewb.model.pass.seat.StudyCafeSeatPasses;

public interface PassReader {
	StudyCafeSeatPasses readStudyCafePasses();

	StudyCafeLockerPasses readLockerPasses();
}
