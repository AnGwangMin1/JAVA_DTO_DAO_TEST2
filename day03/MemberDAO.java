package day03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MemberDAO {
	Scanner sc = new Scanner(System.in);
	
	// 모든 회원정보를 저장하는 리스트
	ArrayList<MemberDTO> members = new ArrayList<MemberDTO>();
	MemberView mv = new MemberView();
	
	public String loginId = null;
	
	// DAO 객체가 생성될 때 3명의 회원정보가 members에 저장된다.
	public MemberDAO() {
		members.add(new MemberDTO("kim", "1234", "김길동", "kim@naver.com"));
		members.add(new MemberDTO("hong", "1234", "홍길동", "hone@naver.com"));
		members.add(new MemberDTO("ko", "1234", "고길동", "ko@naver.com"));
	}
	
	// 회원가입 메소드
	public void memberJoin() {
//	public MemberDTO memberJoin() {
//		String id = getInputValue("아이디 : ");
//		String pw = getInputValue("비밀번호 : ");
//		String pw2 = getInputValue("비밀번호 확인 : ");
//		String name = getInputValue("이름 : ");
//		String email = getInputValue("이메일 : ");
		
//		MemberDTO joinData = new MemberDTO(id, pw, name, email);
		
		
		MemberDTO joinDto = mv.joinInputValue();
		
		// 아이디 중복 확인하기
//		if(idCheck(id)) {
//			System.out.println("중복된 아이디가 존재합니다!!");
//		}else if(pw.equals(pw2)) {
////			return joinData;
//			members.add(joinData);
//			System.out.println(id + "님 가입을 축하 드립니다!!");
//		}else {
//			System.out.println("비밀번호를 다시 확인하세요~!");
////			return null;
//		}
		
		if(idCheck(joinDto.getId())) {
			System.out.println("중복된 아이디가 존재합니다!!");
		}else {
			members.add(joinDto);
			System.out.println(joinDto.getId() + "님 가입을 축하 드립니다!!");
		}
	}
	
	// 아이디 중복 체크
	public boolean idCheck(String id) {
		boolean isId = true;
		
		MemberDTO member = findById(id);
		if(member == null) {
			isId = false;
		}
		return isId;
	}
	

//	public String getInputValue(String msg) {
//		System.out.print(msg);
////		String input = sc.next();
////		return input;
//		return sc.next();
//	}
	
	// login 메소드
	public void login() {
		System.out.println("id : ");
		String id = sc.next();
		
		System.out.println("pw : ");
		String pw = sc.next();
		
		MemberDTO member = findById(id);
		
		if(member == null) {
			System.out.println("존재하지 않는 ID 입니다!!");
		}else if(member.getPw().equals(pw)) {
			// 로그인을 성공하면 id값을 loginId에 저장
			loginId = member.getId();
			System.out.println("[" +member.getId()+ "] 님께서 로그인 하셨습니다.");
		}else {
			System.out.println("비밀번호가 틀렸습니다!!!");
		}
	}
	
	// 입력 id와 일치하는 회원정보(MemberDTO) 가져오기
	public MemberDTO findById(String id) {
		for(MemberDTO dto : members) {
			if(dto.getId().equals(id)) {
				return dto;
			}
		}
		return null;
	}
	
	// 회원리스트
	public void memberList() {
//		for(MemberDTO mDto : members) {
//			System.out.println(mDto.toString());
//		}
		
		// 반복자
		Iterator<MemberDTO> iterator = members.iterator();
		
		// hasNext() 다음 요소가 있으면 true
		while(iterator.hasNext()) {
			// next() 요소를 가져오기
			System.out.println(iterator.next());
		}
		
	}
	
	// 로그아웃
	public void logout() {
		loginId = null;
	}
	
}
