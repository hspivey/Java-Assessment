package com.cooksys.server;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.cooksys.file.Box;

public class ClientHandler implements Runnable {

	Socket client;

	public ClientHandler(Socket client) {
		this.client = client;
	}

	public void run() {

		try {
			while (true) {

				JAXBContext jaxbContext = JAXBContext.newInstance(Box.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Box box = (Box) jaxbUnmarshaller.unmarshal(client.getInputStream());
				System.out.println(box);
				File dir = new File("C:/Users/ftd-09/Received");
				boolean successfuldir = dir.mkdir();
				if (successfuldir) {
					System.out.println("master directory was created successfully");
				}
				File dirname = new File("C:/Users/ftd-09/Received/"+box.getUserName()+"/");
				boolean successfulname = dirname.mkdir();
				if (successfulname) {
					System.out.println("new user directory created");
				}
				File dirdate = new File("C:/Users/ftd-09/Received/"+box.getUserName()+"/"+box.getDate()+"/");
				boolean successfuldate = dirdate.mkdir();
				if (successfuldate) {
					System.out.println("new date subdirectory created");
				}
				File receivedfile = new File("C:/Users/ftd-09/Received/"+box.getUserName()+"/"+box.getDate()+"/"+box.getFileName()+"/");
				String value = box.getFile()+"";
			    FileOutputStream fos = new FileOutputStream(receivedfile);
			    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
			    outStream.writeUTF(value);
			    outStream.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
