package day03;

import java.util.Scanner;

public class MemberView {
	private Scanner sc = new Scanner(System.in);
	
	public int mainMenu() {
		System.out.println("------------- Test App ver1.0-----------");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 회원리스트");
		System.out.println("4. 로그아웃");
		System.out.println("5. 종료");
		return getSelNum("메뉴를 선택하세요 >> ");
	}
	
	public MemberDTO joinInputValue() {
		String id = getInputValue("아이디 : ");
		String pw = getInputValue("비밀번호 : ");
		String pw2 = getInputValue("비밀번호 확인 : ");
		String name = getInputValue("이름 : ");
		String email = getInputValue("이메일 : ");
		
		MemberDTO joinData = new MemberDTO(id, pw, name, email);
		
		if(pw.equals(pw2)) {
			return joinData;
//			System.out.println(id + "님 가입을 축하 드립니다!!");
		}else {
//			System.out.println("비밀번호를 다시 확인하세요~!");
			return null;
		}
	}
	
	public String getInputValue(String msg) {
		System.out.print(msg);
//		String input = sc.next();
//		return input;
		return sc.next();
	}
	
	public int getSelNum(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}
	
}
