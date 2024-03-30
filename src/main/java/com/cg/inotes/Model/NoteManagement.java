package com.cg.inotes.Model;
import com.cg.inotes.DBContext.DBContext;
import com.cg.inotes.Service.NoteService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteManagement {
    private final DBContext dbContext;
    NoteService noteService = new NoteService();
    public NoteManagement(){
        dbContext = DBContext.getInstance();
    }
    public List<Note> getAllNotes() {
        // Lấy danh sách tất cả các Ghi chú từ CSDL
        List<Note> notes = new ArrayList<>();
        List<Note> allNotes = noteService.getAllNotes();
        try{
            Connection connection = dbContext.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Notes");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("context");
                Note note = new Note(id,title,content);
                notes.add(note);
            }
            resultSet.close();
            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return notes;
    }

    public List<Note> searchNotes(String keyword) {
        // Tìm kiếm Ghi chú theo từ khóa từ CSDL
        List<Note> notes = new ArrayList<>();
        List<Note> searchResults = noteService.searchNotes("keyword");
        try {
            Connection connection = dbContext.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Notes WHERE title LIKE ? OR content LIKE ?");
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");

                Note note = new Note(id, title, content);
                notes.add(note);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }

    public void addNote(Note note) {
        // Thêm một Ghi chú mới vào CSDL
        Note newNote = new Note("Title", "Content");
        noteService.addNote(newNote);
        try {
            Connection connection = dbContext.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Notes (title, content) VALUES (?, ?)");
            statement.setString(1, note.getTitle());
            statement.setString(2, note.getContent());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Note added successfully.");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNote(int noteId) {
        // Xóa Ghi chú khỏi CSDL
        try {
            Connection connection = dbContext.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Notes WHERE id = ?");
            statement.setInt(1, noteId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Note deleted successfully.");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}