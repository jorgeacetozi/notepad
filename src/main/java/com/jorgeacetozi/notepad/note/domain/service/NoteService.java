package com.jorgeacetozi.notepad.note.domain.service;

import com.jorgeacetozi.notepad.note.domain.model.Note;

public interface NoteService {

	Note create(Note note);
	void delete(Note note);
}
