package com.cg.inotes.Controller;
import com.cg.inotes.Model.Note;
import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import com.cg.inotes.Model.NoteManagement;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class NoteServlet extends HttpServlet {
    private NoteManagement noteManagement;

    public void init() {
        noteManagement = new NoteManagement();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                List<Note> allNotes = noteManagement.getAllNotes();
                // Gửi danh sách Ghi chú tới trang JSP để hiển thị
                request.setAttribute("notes", allNotes);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            case "search":
                String keyword = request.getParameter("keyword");
                List<Note> searchResults = noteManagement.searchNotes(keyword);
                // Gửi kết quả tìm kiếm tới trang JSP để hiển thị
                request.setAttribute("notes", searchResults);
                request.getRequestDispatcher("searchNotes.jsp").forward(request, response);
                break;

            case "add":
                // Hiển thị trang JSP để thêm Ghi chú mới
                request.getRequestDispatcher("addNote.jsp").forward(request, response);
                break;

            case "delete":
                int noteId = Integer.parseInt(request.getParameter("id"));
                noteManagement.deleteNote(noteId);
                // Chuyển hướng về trang danh sách Ghi chú sau khi xóa
                response.sendRedirect(request.getContextPath() + "/notes");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                String title = request.getParameter("title");
                String content = request.getParameter("content");
                int typeId = Integer.parseInt(request.getParameter("typeId"));

                Note newNote = new Note(title,content,typeId);
                newNote.setTitle(title);
                newNote.setContent(content);
                newNote.setTypeId(typeId);

                noteManagement.addNote(newNote);
                // Chuyển hướng về trang danh sách Ghi chú sau khi thêm
                response.sendRedirect(request.getContextPath() + "/notes");
                break;
        }
    }
}