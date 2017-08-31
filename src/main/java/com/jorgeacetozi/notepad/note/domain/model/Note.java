package com.jorgeacetozi.notepad.note.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Note {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String title;
	private String content;
	
	@Column(name="word_count")
	private Integer wordCount;
	
	private Note () {
		
	}
	
	public Note (String title, String content) {
		this.title = title;
		this.content = content;
		this.wordCount = this.content.split(" ").length;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Integer getWordCount() {
		return wordCount;
	}
}
