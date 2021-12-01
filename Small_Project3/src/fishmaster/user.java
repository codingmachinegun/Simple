package fishmaster;

import java.util.Scanner;

public class user {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		MemberDAO a= new MemberDAO();
		Finfo b= new Finfo();
		FPoint c = new FPoint();
		Result d= new Result();
		View e = new View();
		
		while(true){
			e.view();
			System.out.println("원하는 메뉴를 선택하세요.");
			int input = scan.nextInt();
			scan.nextLine();
			
			if(input==1) {
				a.mclass();
			}
			else if(input==2) {
				b.fclass();
			}
			else if(input==3) {
				c.fpoint();
			}
			else if(input==4) {
				d.fresult();
			}
			else if(input==5) {
				System.out.println("FISHMASTER를 종료합니다");
				break;

			}
		}
		
		
		
	}

}
