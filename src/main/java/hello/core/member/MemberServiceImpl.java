package hello.core.member;

public class MemberServiceImpl implements MemberService {
	
	//private final MemberRepository memberRepository = new MemoryMemberRepository();
	// DIP 위반 수정 -> 추상에만 의존하도록 변경(인터페이스에만 의존)
	private final MemberRepository memberRepository;

	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

}

