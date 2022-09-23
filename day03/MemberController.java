package day03;

public class MemberController {
	MemberDAO dao = new MemberDAO();
	MemberView mv = new MemberView();
	
	public void run() {
		int selMenu = 0;
		
		while((selMenu =  mv.mainMenu())!= 5) {
			switch(selMenu) {
			case 1: dao.login();break;
			case 2: dao.memberJoin();break;
			case 3: dao.memberList();break;
			case 4:
				if(dao.loginId == null) {
					System.out.println("로그아웃 상태입니다...");
				}else {
					System.out.println("["+dao.loginId+"] 님이 로그아웃 되었습니다!!");
					dao.logout();
				}
				
				break;
			}
		} // while
		System.out.println("프로그램 종료 ~~~");
	}
}
