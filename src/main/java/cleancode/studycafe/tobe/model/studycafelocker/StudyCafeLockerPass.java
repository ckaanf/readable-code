package cleancode.studycafe.tobe.model.studycafelocker;

import cleancode.studycafe.tobe.model.studycafepass.StudyCafePassType;

public class StudyCafeLockerPass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;

    private boolean isActive;

    private StudyCafeLockerPass(StudyCafePassType passType, int duration, int price) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
    }

    public static StudyCafeLockerPass of(StudyCafePassType passType, int duration, int price) {
        return new StudyCafeLockerPass(passType, duration, price);
    }

    public StudyCafePassType getPassType() {
        return passType;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public String display() {
        if (passType == StudyCafePassType.HOURLY) {
            return String.format("%s시간권 - %d원", duration, price);
        }
        if (passType == StudyCafePassType.WEEKLY) {
            return String.format("%s주권 - %d원", duration, price);
        }
        if (passType == StudyCafePassType.FIXED) {
            return String.format("%s주권 - %d원", duration, price);
        }
        return "";
    }

    public String askLockerPass() {
        return String.format("""
            사물함을 이용하시겠습니까? (%s)
            1. 예 | 2. 아니오
            """,display());
    }

    public boolean isActive() {
        return this.isActive;
    }

    public boolean useLocker(String input) {
        return this.isActive = "1".equals(input);
    }

}
