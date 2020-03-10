package com.bof.file.main;

import java.util.ArrayList;
import java.util.List;

import com.bof.file.FileMng;

public class Main {
	public static void main(String[] args) {
		FileMng test = new FileMng("E:/data_bai_1.txt");
		List<String> listDataList = new ArrayList<String>();
		listDataList.add("1");
		listDataList.add("2");
		listDataList.add("9");
		listDataList.add("4");
		listDataList.add("7");
		test.sortListDataAsc(listDataList);
	}
}
