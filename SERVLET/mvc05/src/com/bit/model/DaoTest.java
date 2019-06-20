package com.bit.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Dao를 테스트하기 위한 클래스
 * 나중에 지울것 
 * */
public class DaoTest {
	public static void main(String[] args){
		Guest02Dao dao = new Guest02Dao();
		System.out.println("Connection? "+(dao.conn!=null));
		
		/////////////////////////////////////////////////////
		///getList 테스트
		ArrayList<Guest02Dto> list = dao.getList();
		int last=0;
		
		for(Guest02Dto bean : list){
			int num = bean.getNum();
			if(last<num) last = num;
			System.out.println(bean.toString());
		}
		
		//세부 내용까지는 알기 어려우니 대략적인 정보만 확인
		System.out.println("list ?"+(list!=null));
		int size = list.size();
		System.out.println("list size>0 ?"+(size>0));
		
		/////////////////////////////////////////////////////
		///addList 테스트
		//방법 1 pstmt.executeUpdate() 리턴값 비교
		
		//방법 2 list의 size 비교
		dao = new Guest02Dao();
		Guest02Dto target = new Guest02Dto();
		target.setNum(last+1);
		target.setSub("newTest1");
		target.setUnum(1);
		target.setPay(1111);
		
		dao.addList(target.getSub(), target.getUnum(), target.getPay());
		dao = new Guest02Dao();
		System.out.println("insert? "+((size+1)==dao.getList().size()));
		
		/////////////////////////////////////////////////////
		///getListOne 테스트
		dao = new Guest02Dao();
		Guest02Dto bean = dao.getListOne(target.getNum());
		System.out.println(bean.equals(target)+", "+target.toString());
		
		
		/////////////////////////////////////////////////////
		///editOne 테스트
		dao = new Guest02Dao();
		target.setSub("edit01");
		target.setPay(2222);
		System.out.println("update? "+(dao.editOne(target.getSub(), target.getPay(), target.getNum())>0)+","+target.toString());
		
		/////////////////////////////////////////////////////
		///deleteOne 테스트
		dao = new Guest02Dao();
		System.out.println("delete? "+(dao.deleteOne(target.getNum())>0)+","+target.toString());
		
		
	}
}
