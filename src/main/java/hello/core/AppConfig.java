package hello.core;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
	// 관심사 분리
	// 애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 
	// 구현 객체를 생성하고, 연결하는 책임을 가지는 클래스
	
	// 회원서비스 생성
	public MemberService memberService( ) {
		return new MemberServiceImpl(new MemoryMemberRepository());
	}
	
	// 주문서비스 생성
	public OrderService orderService( ) {
		return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
	}
	
}
