package com.jorgeacetozi.notepad.acceptanceTests.note.pageObject;

import static java.lang.Thread.sleep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jorgeacetozi.notepad.note.domain.model.Note;

public class NewNotePage {

	@FindBy(id = "newNote")
	private WebElement newNoteModal;

	@FindBy(id = "newNoteTitle")
	private WebElement title;

	@FindBy(id = "newNoteSubtitle")
	private WebElement subtitle;

	@FindBy(id = "newNoteContent")
	private WebElement content;

	@FindBy(id = "btnCreateNewNote")
	private WebElement createNoteButton;

	private Long sleep = 2000l;

	private WebDriver driver;

	public NewNotePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void create(Note newNote) throws InterruptedException {
		newNoteModal.click();
		sleep(sleep);

		title.sendKeys(newNote.getTitle());
		if (newNote.getSubtitle() != null) {
			subtitle.sendKeys(newNote.getSubtitle());
		}
		content.sendKeys(newNote.getContent());
		createNoteButton.click();
		sleep(sleep);
	}

	public String getMessage() {
		return driver.findElement(By.className("noty_text")).getText();
	}
}
