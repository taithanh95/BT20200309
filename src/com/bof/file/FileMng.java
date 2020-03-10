package com.bof.file;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileMng {
	private File fileSrc;

	public FileMng(String path) {
		this.fileSrc = new File(path);
	}

	public FileMng() {
	}

	public void readFile() {
		if (!fileSrc.exists()) {
			System.out.println("Khong tim thay file du lieu!");
			return;
		}
		if (fileSrc.length() == 0) {
			System.out.println("Tep khong co du lieu dau vao!");
			return;
		}
		try {
			String text = "";
			FileInputStream in = new FileInputStream(fileSrc);
			byte buff[] = new byte[1024];

			int len = in.read(buff);
			while (len > 0) {
				text += new String(buff, 0, len);
				len = in.read(buff);
			}
			in.close();
			List<String> dataNumberList = new ArrayList<String>();
			dataNumberList.add(text);
			// List<String> dataNumberList = Arrays.asList(text);
			System.out.println(dataNumberList);

			for (int i = 0; i < dataNumberList.size() - 1; i++) {
				for (int j = i + 1; j < dataNumberList.size(); j++) {
					String kyTu = dataNumberList.get(i);
					int num = Integer.parseInt(kyTu);
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String validateFile(String path) {
		// Case 1: Khong tim thay file du lieu
		// Case 2: File khong co du lieu
		return null;
	}

	public List<String> readFile(File file) {
		List<String> listDataList = new ArrayList<>();
		// Do some thing
		return listDataList;
	}

	public List<String> checkNotIsNumber(List<String> listDataList) {
		List<String> listDataErrList = new ArrayList<>();
		// Do some thing
		for (int i = 0; i < listDataList.size(); i++) {
			try {
				Long valueLong = Long.valueOf(listDataList.get(i));
			} catch (Exception e) {
				listDataErrList.add("Dong thu " + (i + 1) + " co gia tri [" + listDataList.get(i) + "] khong phai la dinh dang so.");
			};
		}
		return listDataErrList;
	}
	
	public static void main(String[] args) {
		List<String> listDataList = new ArrayList<>();
		listDataList.add("1");
		listDataList.add("2");
		listDataList.add("9");
		listDataList.add("4");
		listDataList.add("7");
		List<Long> listDataErrList = new FileMng().sortListDataAsc(listDataList);
		if (listDataErrList != null && listDataErrList.size() > 0)
			for (Long string : listDataErrList) 
				System.out.println(string);
	}

	public List<Long> sortListDataAsc(List<String> listDataList) {
		List<Long> listDataSort = new ArrayList<>();
		// Do some thing
		for (String string : listDataList) {
			listDataSort.add(Long.valueOf(string));
		}
		listDataSort.sort((o1, o2) -> o1.compareTo(o2));
		return listDataSort;
	}

	public void writeFile(List<String> listDataListAfterSort) {

	}

	public void exe(String path) {
		// Validate file
		String errString = validateFile(path);
		if (errString != null && !errString.equals("")) {
			System.out.println(errString);
			return;
		}
		// Doc du lieu file
		List<String> listDataList = readFile(new File(path));

		// Kiem tra cac dong khong phai number
		List<String> listDataErrList = checkNotIsNumber(listDataList);
		if (listDataErrList != null && listDataErrList.size() > 0) {
			for (String string : listDataErrList) {
				System.out.println(string);
			}
			return;
		}

		// Sap xep lai
		List<Long> listDataSort = sortListDataAsc(listDataList);
		
		//In ra man hinh so min/max
		System.out.println("Min = " + listDataSort.get(0));
		System.out.println("Max = " + listDataSort.get(listDataSort.size() - 1));
		
		
		

	}
}
