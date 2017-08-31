package com.jorgeacetozi.notepad.unitTests.note.domain.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.jorgeacetozi.notepad.note.domain.model.Note;

public class NoteTest {
	
	@Test
	public void shouldCountWordsFromNoteContent() {
		Note note = new Note("Unit Tests", "Unit tests provide fast feedback, but they test only an isolated unit of code");
		assertThat(note.getWordCount(), is(14));
	}
}
