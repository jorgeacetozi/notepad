package com.jorgeacetozi.notepad.note.domain.service;

import java.util.List;

import com.jorgeacetozi.notepad.note.domain.model.Note;

public interface NoteService {

	Note create(Note note);
	void delete(Note note);
	List<Note> findAll();
}
