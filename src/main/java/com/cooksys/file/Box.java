package com.cooksys.file;

import java.io.File;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Box {
	@XmlAttribute
	private String senderName;
	//@XmlAttribute
	//private GregorianCalendar date;
	@XmlAttribute
	private String date;
	@XmlElement
	private String fileName;
	@XmlElement
	private File attachedFile;


	public Box() {
	}

	public Box(File file) throws DatatypeConfigurationException {
	this.senderName = "Hamilton Spivey";
	this.date = "2018, 03, 22";
	//this.date = setTheDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar(2018, 03, 22)));
	this.attachedFile = file;
	this.fileName = file.getName();
}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/*public GregorianCalendar getTheDate() {
		return date;
	}

	public GregorianCalendar setTheDate(XMLGregorianCalendar newXMLGregorianCalendar) {
		 //TODO Auto-generated method stub
		return null;
	}
*/
	public String getUserName() {
		return senderName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setUserName(String userName) {
		this.senderName = userName;
	}

	public File getFile() {
		return attachedFile;
	}

	public void setFile(File file) {
		this.attachedFile = file;
	}
}