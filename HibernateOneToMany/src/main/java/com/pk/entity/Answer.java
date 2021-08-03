package com.pk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AnswerTable")
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String answername;
	private String postedBy;
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(int id, String answername, String postedBy) {
		super();
		this.id = id;
		this.answername = answername;
		this.postedBy = postedBy;
	}
	public int getAid() {
		return id;
	}
	public void setAid(int id) {
		this.id = id;
	}
	public String getAnswername() {
		return answername;
	}
	public void setAnswername(String answername) {
		this.answername = answername;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	@Override
	public String toString() {
		return "Answer [aid=" + id + ", answername=" + answername + ", postedBy=" + postedBy + "]";
	}

	
}
