package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {
	// 관심사 분리
	// 애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 
	// 구현 객체를 생성하고, 연결하는 책임을 가지는 클래스
	
	// SRP 단일 책임 원칙
	// 한 클래스는 하나의 책임만 가져야 한다.
	
	// DIP 의존관계 역전 원칙
	// 프로그래머는 “추상화에 의존해야지, 구체화에 의존하면 안된다.” 의존성 주입은 이 원칙을 따르는 방법 중 하나다.

	// OCP
	// 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다

	
	// 회원서비스 생성
	@Bean
	public MemberService memberService( ) {
		return new MemberServiceImpl(memberRepository());
	}
	
	// 주문서비스 생성
	@Bean
	public OrderService orderService( ) {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	// 리팩터링 - 중복코드 제거
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	// 리팩터링 - 역할에 따른 구현이 보이도록
	@Bean
	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
	}
	
}
