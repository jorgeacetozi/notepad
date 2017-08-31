package com.jorgeacetozi.notepad.note.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorgeacetozi.notepad.note.domain.model.Note;

public interface NoteRepository extends JpaRepository<Note, String> {

}
