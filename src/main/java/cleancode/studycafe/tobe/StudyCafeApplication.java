package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.model.StudyCafeAdmin;
import cleancode.studycafe.tobe.model.machine.StudyCafePassMachine;
import cleancode.studycafe.tobe.model.machine.ThisStudyCafePassMachine;

public class StudyCafeApplication {

    public static void main(String[] args) {
        StudyCafeAdmin admin = new StudyCafeAdmin();
        StudyCafePassMachine machine = new ThisStudyCafePassMachine();
        machine.service(admin);
    }

}
