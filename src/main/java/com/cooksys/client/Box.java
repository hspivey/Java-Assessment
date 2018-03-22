package com.cooksys.client;

import java.io.File;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.DatatypeConfigurationException;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Box {
	@XmlAttribute
	private String senderName;
	@XmlAttribute
	private LocalDate date;
	@XmlElement
	private String fileName;
	@XmlElement
	private File attachedFile;

	public Box() {
	}

	public Box(File file) throws DatatypeConfigurationException {
		this.senderName = "Hamilton Spivey";
		this.date = java.time.LocalDate.now();
		this.attachedFile = file;
		this.fileName = file.getName();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUserName() {
		return senderName;
	}

	public LocalDate getDate() {
		return date;
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