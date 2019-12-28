package com.jorgeacetozi.notepad.integrationTests.note.domain.service;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.jorgeacetozi.notepad.note.domain.model.Note;
import com.jorgeacetozi.notepad.note.domain.service.NoteService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class NoteServiceTest {

	@Autowired
	private NoteService noteService;

	private Note note;

	@Before
	public void setUp() {
		note = new Note("Kubernetes", "Best container orchestration tool ever");
	}

	@After
	public void destroy() {
		noteService.delete(note);
	}

	@Test
	public void shouldCreateNoteWithTitleAndContent() {
		Note createdNote = noteService.create(note);
		assertThat(createdNote.getId(), notNullValue());
		assertThat(createdNote.getWordCount(), is(5));
	}

	@Test
	public void shouldCreateNoteWithTitleSubtitleAndContent() {
		note = new Note("Kubernetes", "Easy Container Orchestration", "Best container orchestration tool ever");
		Note createdNote = noteService.create(note);
		assertThat(createdNote.getId(), notNullValue());
		assertThat(createdNote.getWordCount(), is(5));
	}
}
