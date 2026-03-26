package com.notes.controller;

import com.notes.entity.Note;
import com.notes.service.NotesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesServiceImpl notesServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<Note> createNote (@RequestBody Note note){
    try {
        Note savedNote = notesServiceImpl.createNotes(note);
        return new ResponseEntity<> (savedNote,HttpStatus.CREATED);
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Note());
    }
    }

    @GetMapping("/all_notes")
    public List<Note> getNotes(){
        return notesServiceImpl.showNotes();
    }

    @PutMapping("/update_note/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note) {
        try{
            Optional<Note> existingNote = notesServiceImpl.findNoteById(id);
            if(existingNote.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            Note updatedNote = notesServiceImpl.updateNote(note, id);
            return ResponseEntity.ok(updatedNote);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id) {
        try{
            Optional<Note> existingNote = notesServiceImpl.findNoteById(id);
            if(existingNote.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            notesServiceImpl.DeleteNote(id);
            return ResponseEntity.ok(existingNote.get());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
