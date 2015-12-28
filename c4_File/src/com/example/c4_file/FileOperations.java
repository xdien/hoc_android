package com.example.c4_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileOperations {
	public Boolean write(String fname, String fcontent) {
		try {
			String fpath = "/sdcard/" + fname + ".txt";
			File file = new File(fpath);
			// If file does not exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			Writer bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file.getAbsolutePath()), "UTF-16LE"));
			bw.write(fcontent);
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String read(String fname) {
		BufferedReader br = null;
		String response = null;
		try {
			StringBuffer output = new StringBuffer();
			String fpath = "/sdcard/" + fname;
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					fpath), "UTF-16LE"));
			String line = "";
			while ((line = br.readLine()) != null) {
				output.append(line + "\n");
			}
			response = output.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return response;
	}

}
