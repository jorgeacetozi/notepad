package com.jorgeacetozi.notepad.unitTests.note.domain.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jorgeacetozi.notepad.note.domain.model.Note;

public class NoteTest {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void shouldNotRaiseViolationWhenTitleAndContentAreFilled() {
		Note note = new Note("Unit Tests", "Unit tests provide fast feedback");
		Set<ConstraintViolation<Note>> constraintViolations = validator.validate(note);
		assertThat(constraintViolations.size(), is(0));
	}

	@Test
	public void shouldNotRaiseViolationWhenTitleSubtitleAndContentAreFilled() {
		Note note = new Note("Unit Tests", "JUnit Framekwork", "Unit tests provide fast feedback");
		Set<ConstraintViolation<Note>> constraintViolations = validator.validate(note);
		assertThat(constraintViolations.size(), is(0));
	}

	@Test
	public void shouldRaiseViolationWhenTitleIsEmpty() {
		Note note = new Note("", "Unit tests provide fast feedback");
		Set<ConstraintViolation<Note>> constraintViolations = validator.validate(note);
		assertThat(constraintViolations.size(), is(1));
	}

	@Test
	public void shouldRaiseViolationWhenContentIsEmpty() {
		Note note = new Note("Unit Tests", "");
		Set<ConstraintViolation<Note>> constraintViolations = validator.validate(note);
		assertThat(constraintViolations.size(), is(1));
	}

	@Test
	public void shouldCountOneForContentWithSingleWord() {
		Note note = new Note("Unit Tests", "Xuxa");
		assertThat(note.getWordCount(), is(1));
	}

	@Test
	public void shouldCountWordsFromNoteContent() {
		Note note = new Note("Unit Tests",
				"Unit tests provide fast feedback, but they test only an isolated unit of code");
		assertThat(note.getWordCount(), is(14));
	}
}
