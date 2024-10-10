package cleancode.studycafe.tobewb;

import cleancode.studycafe.tobewb.io.PassReader;
import cleancode.studycafe.tobewb.io.StudyCafeFileHandler;
import cleancode.studycafe.tobewb.io.provider.LockerPassFileReader;
import cleancode.studycafe.tobewb.io.provider.SeatPassFileReader;
import cleancode.studycafe.tobewb.provider.LockerPassProvider;
import cleancode.studycafe.tobewb.provider.SeatPassProvider;

public class StudyCafeApplication {

	public static void main(String[] args) {
		SeatPassProvider seatPassProvider = new SeatPassFileReader();
		LockerPassProvider lockerPassProvider = new LockerPassFileReader();

		StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(
			seatPassProvider,
			lockerPassProvider
		);
		studyCafePassMachine.run();
	}

}
