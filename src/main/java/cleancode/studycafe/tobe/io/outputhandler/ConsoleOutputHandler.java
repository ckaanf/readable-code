package cleancode.studycafe.tobe.io.outputhandler;

import cleancode.studycafe.tobe.model.studycafelocker.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.studycafepass.StudyCafePass;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void show(String message) {
        System.out.println(message);
    }

    @Override
    public void askLockerPass(StudyCafeLockerPass lockerPass) {
        System.out.println();
        String askMessage = String.format(
            "사물함을 이용하시겠습니까? (%s)",
            lockerPass.display()
        );

        System.out.println(askMessage);
        System.out.println("1. 예 | 2. 아니오");
    }

    @Override
    public void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass) {
        System.out.println();
        System.out.println("이용 내역");
        System.out.println("이용권: " + selectedPass.display());
        if (lockerPass != null) {
            System.out.println("사물함: " + lockerPass.display());
        }

        double discountRate = selectedPass.getDiscountRate();
        int discountPrice = (int) (selectedPass.getPrice() * discountRate);
        if (discountPrice > 0) {
            System.out.println("이벤트 할인 금액: " + discountPrice + "원");
        }

        int totalPrice = selectedPass.getPrice() - discountPrice + (lockerPass != null ? lockerPass.getPrice() : 0);
        System.out.println("총 결제 금액: " + totalPrice + "원");
        System.out.println();
    }

    @Override
    public void showSimpleMessage(String message) {
        System.out.println(message);
    }

}
