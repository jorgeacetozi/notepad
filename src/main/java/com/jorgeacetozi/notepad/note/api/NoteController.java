package com.jorgeacetozi.notepad.note.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jorgeacetozi.notepad.note.domain.model.Note;
import com.jorgeacetozi.notepad.note.domain.service.NoteService;

@RestController("/notes")
public class NoteController {
	
	@Autowired
	private NoteService noteService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Note create(@RequestBody Note note) {
		return noteService.create(note);
	}
}
