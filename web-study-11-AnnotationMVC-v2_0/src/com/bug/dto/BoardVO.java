package com.bug.dto;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	/*
	 * @NotBlank(message = "NotBlank.board.name") -> message/messages.properties 에 정의된 값으로 에러메세지를 보여준다
	 * message/messages.properties 에 정의할때 형식에 맞게 넣어주어야 한다(주의)
	 */
	
	private int num;
	@NotBlank(message = "NotBlank.board.name")
	private String name;
	private String email;
	@NotBlank(message = "NotBlank.board.pass")
	private String pass;
	@NotBlank(message = "NotBlank.board.title")
	private String title;
	private String content;
	private int readcount;
	private Timestamp writedate;
	// 추가되는 컬럼들
	private int bref;
	private int bstep;
	private int blevel;
	private String uploadpath;
	private MultipartFile mfile; // 파일 속성

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public Timestamp getWritedate() {
		return writedate;
	}

	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}

	public int getBref() {
		return bref;
	}

	public void setBref(int bref) {
		this.bref = bref;
	}

	public int getBstep() {
		return bstep;
	}

	public void setBstep(int bstep) {
		this.bstep = bstep;
	}

	public int getBlevel() {
		return blevel;
	}

	public void setBlevel(int blevel) {
		this.blevel = blevel;
	}

	public String getUploadpath() {
		return uploadpath;
	}

	public void setUploadpath(String uploadpath) {
		this.uploadpath = uploadpath;
	}

	public MultipartFile getMfile() {
		return mfile;
	}

	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}

	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", name=" + name + ", email=" + email + ", pass=" + pass + ", title=" + title
				+ ", content=" + content + ", readcount=" + readcount + ", writedate=" + writedate + ", bref=" + bref
				+ ", bstep=" + bstep + ", blevel=" + blevel + ", uploadpath=" + uploadpath + ", mfile=" + mfile + "]";
	}

}
