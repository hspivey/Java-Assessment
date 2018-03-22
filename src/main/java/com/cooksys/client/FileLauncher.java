package com.cooksys.client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class FileLauncher {
	public static void main(String[] args) throws IOException {
		File f = null;
		String[] paths;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		Socket sock = null;

		try {

			f = new File("C:\\Users\\ftd-09\\eclipse-workspace\\JavaAssessment\\Test files");

			paths = f.list();

			for (String path : paths) {
				File toSend = new File(path + "");
				BufferedReader inputfromFile = new BufferedReader(new FileReader(path + ".txt"));
				String firstLine = inputfromFile.readLine();

				bos.writeUTF(firstLine);
				DataOutputStream fos = new DataOutputStream(new FileOutputStream(toSend));
				// ToXML.begin(path);
				// fos.writeChars(ToXML.begin(path + ""));
				Box sendThis = new Box(toSend);
				JAXBContext jc = JAXBContext.newInstance(Box.class);
				Marshaller marshaller = jc.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshaller.marshal(sendThis, System.out);
				marshaller.marshal(sendThis, new FileOutputStream(path + ".xml"));
				sock = new Socket("127.0.0.1", 10501);
				File myFile = new File(path + ".xml");
				byte[] mybytearray = new byte[(int) myFile.length()];
				fis = new FileInputStream(myFile);
				bis = new BufferedInputStream(fis);
				bis.read(mybytearray, 0, mybytearray.length);
				os = sock.getOutputStream();
				os.write(mybytearray, 0, mybytearray.length);
				os.flush();
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (bis != null)
				bis.close();
			if (os != null)
				os.close();
			if (sock != null)
				sock.close();
		}

	}
}
