package com.jorgeacetozi.notepad.note.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgeacetozi.notepad.note.domain.model.Note;
import com.jorgeacetozi.notepad.note.domain.repository.NoteRepository;

@Service
public class DefaultNoteService implements NoteService {
	
	@Autowired
	private NoteRepository noteRepository;

	@Override
	public Note create(Note note) {
		return noteRepository.save(note);
	}

	@Override
	public void delete(Note note) {
		noteRepository.delete(note);
	}

	@Override
	public List<Note> findAll() {
		return noteRepository.findAll();
	}
}
