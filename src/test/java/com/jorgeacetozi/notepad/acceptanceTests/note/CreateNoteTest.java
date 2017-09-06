package com.jorgeacetozi.notepad.acceptanceTests.note;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jorgeacetozi.notepad.acceptanceTests.configuration.AcceptanceTestsConfiguration;
import com.jorgeacetozi.notepad.acceptanceTests.note.pageObject.NewNotePage;
import com.jorgeacetozi.notepad.note.domain.model.Note;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AcceptanceTestsConfiguration.class })
public class CreateNoteTest {

	@Autowired
	private WebDriver driver;

	@Autowired
	private URI notepadBaseUri;

	private NewNotePage newNotePage;
	private String newNoteSuccessMessage = "Your note was successfully saved!";

	@Before
	public void setUp() {
		driver.get(notepadBaseUri.toString());
		newNotePage = new NewNotePage(driver);
	}

	@Test
	public void shouldCreateNewNote() throws InterruptedException {
		Note newNote = new Note("Acceptance Test", "Creating note from the acceptance test");
		newNotePage.create(newNote);
		assertThat(newNotePage.getMessage(), equalTo(newNoteSuccessMessage));
	}
}
