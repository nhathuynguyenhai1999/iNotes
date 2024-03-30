package com.cg.inotes.Service;
import com.cg.inotes.Model.Note;
import com.cg.inotes.Model.NoteManagement;
import java.util.List;
public class NoteService {
    private final NoteManagement noteManagement;

    public NoteService() {
        noteManagement = new NoteManagement();
    }

    public List<Note> getAllNotes() {
        return noteManagement.getAllNotes();
    }

    public List<Note> searchNotes(String keyword) {
        return noteManagement.searchNotes(keyword);
    }

    public void addNote(Note note) {
        noteManagement.addNote(note);
    }

    public void deleteNote(int noteId) {
        noteManagement.deleteNote(noteId);
    }
}
