package day15_jdbc;

import java.util.List;

public class DeptView {
	public static void print(List<DeptDTO> deptList){
		System.out.println("부서 정보 모두 출력");
		for(DeptDTO dept : deptList){
			System.out.println(dept);
		}
	}
	public static void print(DeptDTO dept){
		System.out.println("부서 정보 1건 출력");
		System.out.println(dept);
	}
}
