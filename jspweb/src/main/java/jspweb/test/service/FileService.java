package jspweb.test.service;

import java.io.File;

public class FileService {
	
	// 1. 파일 삭제 메소드
	public static boolean fileDelete(String filepath) {
		
		// 1. 파일경로의 파일객체 선언[ 다양한 메소드 제공 ]
		File file = new File(filepath);
		
		if(file.exists()) {
			file.delete();		// 경로상의 파일 삭제
		}
		
		return false;
	}

}


/*
 		File 클래스
 			메소드
 				1. .lenght()	: 파일의 용량[바이트] 호출
 				2. .exists()	: 경로상의 파일 존재여부 있으면 true / 없으면 false
 				3. .delete()	: 경로상의 파일 삭제
 */

















