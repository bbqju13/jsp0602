package handler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHandler {
	private static Logger log = LoggerFactory.getLogger(FileHandler.class);

	// 파일이름 과 경로를 받아서 파일을 삭제 하는 메서드 만들기
	// 리턴 타입 : int -> 잘 삭제되었는지 체크하기 위한 변수 == isOk
	public int deleteFile(String imageFileName, String savePath) {
		// 파일을 삭제하는 메서드의 리턴 타입이 boolean
		boolean isDel = false;
		log.info(" >> deleteFile 메서드 접근 >> : ");		
		log.info(" >> imageFileName >> : " + imageFileName);
		
		File fileDir = new File(savePath);
		File removeFile = new File(fileDir+File.separator+imageFileName);
		File removeThFile = new File(fileDir+File.separator+"TH_"+imageFileName);
//		File removeThFile new File(fileDir+File.separator+"TH_"+ imageFileName);
		
		// 파일이 있는지(존재하는지) 확인 -> 삭제
		if(removeFile.exists() || removeThFile.exists()) {
			isDel = removeFile.delete(); // 리턴형태는 boolean
			log.info(" >> removeFile >> : "+(isDel ? "OK" : "FAIL"));
			
			if(isDel) { // 메인 파일이 지워졌다면 썸네일 파일도 삭제
				isDel = removeThFile.delete();
				log.info(" >> removeThFile >> : "+(isDel ? "OK" : "FAIL"));
			}
		}
		log.info(" >> FileHandler remove OK >> : ");
		return isDel ? 1 : 0;
	}

}
