package com.notes.service;

import com.notes.entity.Note;
import com.notes.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesRepository  notesRepository;

    @Override
    public List<Note> showNotes() {
        return notesRepository.findAll();
    }

    @Override
    public Note createNotes(Note note) {
        return notesRepository.save(note);
    }

    @Override
    public void DeleteNote(Long id) {
    notesRepository.deleteById(id);
    }

    @Override
    public Note updateNote(Note note, Long id) {
        Note notes = notesRepository.findById(id).orElse(null);
        if(notes == null){
            return null;
        }
        notes.setTitle(note.getTitle());
        notes.setContent(note.getContent());
        return notesRepository.save(notes);
    }

    @Override
    public Optional<Note> findNoteById(Long id) {
        return notesRepository.findById(id);
    }
}
