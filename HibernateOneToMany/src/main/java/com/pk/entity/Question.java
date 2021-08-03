package com.pk.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="QuestionTable")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String qname;
	
	@OneToMany(targetEntity=Answer.class,cascade=CascadeType.ALL)
	@JoinColumn(name="did")
	@OrderColumn(name="type")
	private List<Answer> answer;


	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Question(int id, String qname, List<Answer> answer) {
		super();
		this.id = id;
		this.qname = qname;
		this.answer = answer;
	}

	public Question(int id, String qname) {
		super();
		this.id = id;
		this.qname = qname;
	}

	public int getQid() {
		return id;
	}

	public void setQid(int id) {
		this.id = id;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [qid=" + id + ", qname=" + qname + ", answer=" + answer + "]";
	}

	


	
	
}
