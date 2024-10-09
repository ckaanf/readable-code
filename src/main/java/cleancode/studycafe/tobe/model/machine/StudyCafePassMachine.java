package cleancode.studycafe.tobe.model.machine;

import cleancode.studycafe.tobe.model.StudyCafeAdmin;

public interface StudyCafePassMachine extends InitializeMachine, ControlMachine {

	default void service(StudyCafeAdmin admin) {
		initialize(admin);
		startup();
		run();
	};
}
