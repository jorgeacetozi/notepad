package com.jorgeacetozi.notepad.note.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Note {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotEmpty
	private String title;
	@NotEmpty
	private String content;
	
	// Makes Hibernate happy
	private Note () {
		
	}
	
	public Note (String title, String content) {
		this.title = title;
		this.content = content;
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
		return this.content.split(" ").length;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", content=" + content + ", wordCount=" + this.getWordCount() + "]";
	}
}
