package cleancode.studycafe.tobewb.provider;

import cleancode.studycafe.tobewb.model.pass.seat.StudyCafeSeatPasses;

public interface SeatPassProvider {
	// Provider를 외부에 두고 구현체를 하나 더 패키지 만드는 게 중요함
	// 상위 레벨의 추상 개념 spec을 제공함 -> like port - adaptor
	// 인터페이스가 하위레벨에 있으면 너무 구현에 가까움
	StudyCafeSeatPasses getSeatPasses();
}
