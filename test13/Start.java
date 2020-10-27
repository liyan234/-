/*public class Student {

	private String stuNum;
	private String stuName;
	private String stuSex;
	private int stuAge;

	public void study() {
		System.out.println(stuName + "在学习");
	}

	public Student(String num,String name,Sting sex,int age) {
		setStuNum(num);
		setStuName(name);
		setStuSex(sex);
		setStuAge(age);
	}

//为私有属性创建获取和设置方法
	public void setStuNum(String stuNum) {
		if(stuNum.lengtn() == 12) {
		    this.stuNum = stuNum;
	    }
	}
	public String getStuNum() {
		return stuNum;
	}

	public void setStuName(String stuName) {
			this.stuName = stuName;
	}
	public String getStuName() {
		return stuname;
	}

	public void setStuSex(String stuSex) {
		if(stuSex == 'man' || stuSex == 'woman') {
		    this.stuSex = stuSex;
	    }
	}
	public String getStuSex() {
		return stunSex;
	}

	pubilc void setStuAge(int stuAge) {
		if(stuAge >= 6) {
		    this.stuAge = stuAge;
	    }
	}
	public int getStuAge() {
		return stuAge;
	}
}







public class Group {
	private String groupName;//组名
	private Student leader；//组长
	private Student[] members;//小组成员,学生类一个数组来描述小组成员

	public void setGroupName (String groupName) {
		this.groupName = groupName;
	}
	public String getGroupName () {
		return groupName;
	}

	public void setLeader(Student leader) {
		this.leader = leader;
	}
	public Student getLeader() {
		return leader;
	}

	public void setMembers(Student[] members) {
		this.members = members;
	}
	public Student[] getMembers() {
		return members;
	}

	public Group (String groupName,Student leader,Student[] members) {
		setGroupName(groupName);
		setLeader(leader);
		setMembers(members);
	}

	//用来输出小组信息的方法
	public void showInformation() {
		System.out.println("小组学习名称为" + groupName);
		System.out.println("小组组长：" + leader.getStuName);
		System.out.println("小组成员" );
		for( int i = 0; i < members.lengtn; i++) {
			System.out.print(members[i].getStuName + ',');
		}
	}
}





public class Teacher() {
	private String teaName;
	private String teaNum;//教工编号
	private String teaSex;
	private String teaCourse;

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getteaName() {
		return teaName;
	}

	public void setTeaNum(String teaNum) {
		this.teaNum = teaNum;
	}
	public String getteaNum() {
		return teaNum;
	}

	public void setTeaSex(String teaSex) {
		this.teaSex = teaSex;
	}
	public String getteaSex() {
		return teaSex;
	}

	public void setTeaCourse(String teaCourse) {
		this.teaCourse = teaCourse;
	}
	public String getteaCourse() {
		return teaCourse;
	}


	public Teacher (String teaName,String teaNum,String teaSex,String teaCourse) {
		setTeaName(teaName);
		setTeaNum(teaNum);
		setTeaSex(teaSex);
		setTeaCourse(teaCourse);
	}
 
}


public clas Depatment() {
	private String dNum;
	private String dName;
	private Teacher leader;
	private Teacher[] teachers;

	




	public Depatment(String num, String name,Teacher leader,Teacher[] teachers) {
		setdNum(num);
		setdName(name);
		setLeader(leader);
		setTeachers(teachers);
	}
} 


*/

import java.arrays.util

public class Start {

	public static int[] copyArray(int[] array) {
		int[] array2 = new int[array.length];
		for(int i = 0;i < array.length; i++) {
			array2[i] = array[i];
		}
		return array2;
	}



	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		System.out.println()
	}
}