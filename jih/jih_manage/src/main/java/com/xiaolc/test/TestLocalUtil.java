package com.xiaolc.test;


import com.xiaolc.util.LocalUtil;

import java.util.List;


public class TestLocalUtil {
	public static void main(String[] args) {
		LocalUtil lu =  LocalUtil.getInstance();
		List<String> list = 	lu.getCities("中国", "河南");
		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i) + " ");
		}
	}
}
