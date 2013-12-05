package com.meteor.module;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Module {

	private static int LONG_BYTE_LENGTH = 8;
	//private static int LONG_BYTE_LENGTH = 1024;
	
	private static ByteBuffer buffer = ByteBuffer.allocateDirect(LONG_BYTE_LENGTH);

	private static RandomAccessFile seqFile = null;
	
	/**
	 * File read
	 */
	public static void file_read(){
		File file;
		String line;
		//file = new File("C:/a.txt");
		file = new File("L:/Crew 11000 port.txt");
		//file = new File("C:/130425");
		//long time = System.currentTimeMillis();
		long start = 0,end = 0;
		try {
			
			seqFile = new RandomAccessFile(file, "r");
			start = System.currentTimeMillis();
			seqFile.seek(1000000000);
			end = System.currentTimeMillis();	
			/**/
			while( (line = seqFile.readLine())!=null ){
			//while( (line = seqFile. )!=null ){
				System.out.println(line);
			}
			
			seqFile.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("start\t:\t" + start);
		System.out.println("end\t:\t" + end);
		
		
	}
/**
 * seek , skip , readline 성능 비교
 * 한줄마다 글씨 넣기(write)
 * seek와 skip은 비슷 readline 은 성능 떨어짐
 * 아마 readline은 \r\n가 있나 없나 하나씩 다 살펴보니 때문아닌가 함
 * 
 */
	public static void write_file(){
		File file;
		String line;
		long start = 0,end = 0;
		long skip_len = 0;
		//file = new File("C:/a.txt");
		//file = new File("L:/Crew 11000 port.txt");
		//file = new File("L:/te_1.txt");
		//file = new File("C:/te_1.txt");
		file = new File("C:/50m.txt");
		
		try {
			start = System.currentTimeMillis();
			seqFile = new RandomAccessFile(file, "rwd");
			
			/*1. seek*/
			long file_len=0;
			file_len = seqFile.length();
			seqFile.writeBytes("vv");
			while((skip_len = skip_len+187) < file_len){
				seqFile.seek(skip_len);
				seqFile.writeBytes("vv");
				
			}
			
			/*2. skip
			seqFile.writeBytes("vv");
			while(seqFile.skipBytes(184)>0){
				
				seqFile.writeBytes("vv");
				//seqFile.seek(186);
				//seqFile.skipBytes(186);
				System.out.println(seqFile.getFilePointer());
				//	
			}
			 */
			
			//System.out.println(seqFile.readBoolean());
			
			
			/*3. readline
			seqFile.writeBytes("--");
			while((line = seqFile.readLine())!= null){
				
				//System.out.println(line);
				seqFile.writeBytes("--");
				
			}
			*/
			end = System.currentTimeMillis();
			seqFile.close();
			

			System.out.println("start\t:\t" + start);
			System.out.println("end\t:\t" + end);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	/**/
	public static void create_sam_file(){
		File file = new File("c://a.txt");
		String sam_data;
		
		sam_data = "--6.104.47.100 - - [24/Jul/2013:09:16:33 +0900] \"GET /pray.zip HTTP/1.1\" 200 138231002 \"-\" \"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Trident/6.0; ; NCLIENT50_AAP73DB3BE57CF)\"";
		try {
			seqFile = new RandomAccessFile(file, "rws");
			/*
			for(int i =0;i<100;i++){
				seqFile.writeBytes(sam_data);
				seqFile.writeBytes("\n");
			}
			
			seqFile.writeBytes(sam_data);
			*/
			seqFile.seek(seqFile.length());
			seqFile.writeBytes("end");
			
			
			
			seqFile.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
