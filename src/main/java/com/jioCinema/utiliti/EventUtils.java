package com.jioCinema.utiliti;

import java.io.File;

public class EventUtils {

	public void createFolder(String foldPath) {
		File f = new File(foldPath);
		if (!f.exists()) {
			f.mkdirs();
		}
	}
}
