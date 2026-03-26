package com.notes.service;

import com.notes.entity.Note;

import java.util.List;
import java.util.Optional;

public interface NotesService {

    public List<Note> showNotes();

    Optional<Note> findNoteById(Long id);

    public Note createNotes (Note note);

    public void DeleteNote(Long id);

    public Note updateNote(Note note, Long id);
}
