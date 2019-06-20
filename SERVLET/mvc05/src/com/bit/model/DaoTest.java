package com.bit.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Dao�� �׽�Ʈ�ϱ� ���� Ŭ����
 * ���߿� ����� 
 * */
public class DaoTest {
	public static void main(String[] args){
		Guest02Dao dao = new Guest02Dao();
		System.out.println("Connection? "+(dao.conn!=null));
		
		/////////////////////////////////////////////////////
		///getList �׽�Ʈ
		ArrayList<Guest02Dto> list = dao.getList();
		int last=0;
		
		for(Guest02Dto bean : list){
			int num = bean.getNum();
			if(last<num) last = num;
			System.out.println(bean.toString());
		}
		
		//���� ��������� �˱� ������ �뷫���� ������ Ȯ��
		System.out.println("list ?"+(list!=null));
		int size = list.size();
		System.out.println("list size>0 ?"+(size>0));
		
		/////////////////////////////////////////////////////
		///addList �׽�Ʈ
		//��� 1 pstmt.executeUpdate() ���ϰ� ��
		
		//��� 2 list�� size ��
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
		///getListOne �׽�Ʈ
		dao = new Guest02Dao();
		Guest02Dto bean = dao.getListOne(target.getNum());
		System.out.println(bean.equals(target)+", "+target.toString());
		
		
		/////////////////////////////////////////////////////
		///editOne �׽�Ʈ
		dao = new Guest02Dao();
		target.setSub("edit01");
		target.setPay(2222);
		System.out.println("update? "+(dao.editOne(target.getSub(), target.getPay(), target.getNum())>0)+","+target.toString());
		
		/////////////////////////////////////////////////////
		///deleteOne �׽�Ʈ
		dao = new Guest02Dao();
		System.out.println("delete? "+(dao.deleteOne(target.getNum())>0)+","+target.toString());
		
		
	}
}
