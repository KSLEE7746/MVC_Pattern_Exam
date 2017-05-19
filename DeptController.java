package day15_jdbc;

import java.util.List;
import java.util.Scanner;

public class DeptController {

	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
		Scanner sc = new Scanner(System.in);
		List<DeptDTO> deptList;
		while(true){
			System.out.println("-----------------------------------");
			System.out.println("\t정보 조회\t");
			System.out.println("\t1. 모든 부서 조회");
			System.out.println("\t2. 부서 정보 삽입");
			System.out.println("\t3. 부서 정보 갱신");
			System.out.println("\t4. 부서 정보 삭제");
			System.out.println("\t9. 끝내기");
			System.out.println("-----------------------------------");
			int select = sc.nextInt();
			if(select == 9) break;
			if(select == 1){
				deptList = dao.deptSelectAll();
				DeptView.print(deptList);
			} else if(select == 2){
				System.out.println("추가할 부서 정보 입력(ex. 부서번호 부서이름)");
				int deptNo = sc.nextInt();
				String deptName = sc.next();
				dao.deptInsert(deptNo, deptName);

			} else if(select == 3){
				System.out.println("갱신할 부서 번호 입력");
				int deptNo = sc.nextInt();
				System.out.println("갱신할 부서 정보 입력(ex. 부서이름)");
				String deptName = sc.next();
				dao.deptUpdate(deptNo, deptName);
			} else if(select == 4){
				System.out.println("삭제할 부서 번호 입력");
				int deptNo = sc.nextInt();
				dao.deptDelete(deptNo);
			}
		}
	}

}
