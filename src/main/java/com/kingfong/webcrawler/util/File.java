package com.kingfong.webcrawler.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class File {
	private final Logger logger=Logger.getLogger(File.class);
	
	public List<String> getFileContent(String path) {
		List<String> resultList=null;
		BufferedReader bReader=null;
		FileReader fileReader=null;
		try {
			logger.info("读取文件："+path);
			fileReader=new FileReader(path);
			bReader=new BufferedReader(fileReader);
			resultList=new ArrayList<String>();
			String content=null;
			while ((content=bReader.readLine())!=null) {
				resultList.add(content);
			}
		} catch (FileNotFoundException e) {
			logger.error(e);;
		} catch (IOException e) {
			logger.error(e);
		}finally {
			if (bReader!=null) {
				try {
					bReader.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
			if (fileReader!=null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
		return resultList;
	}
}
