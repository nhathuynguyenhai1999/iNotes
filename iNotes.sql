CREATE DATABASE iNotes;
USE iNotes;
CREATE TABLE Notes (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255),
  content TEXT,
  type_id INT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (type_id) REFERENCES Types(id)
);
CREATE TABLE Types (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255)
);
INSERT INTO Types (name) VALUES
  ('Personal'),
  ('Work'),
  ('Study');
INSERT INTO Notes (title, content, type_id) VALUES ('Ghi chú 1', 'Nội dung ghi chú 1', 1);
SELECT * FROM Notes;
SELECT * FROM Notes WHERE title LIKE '%keyword%' OR content LIKE '%keyword%';
UPDATE Notes SET title = 'Ghi chú mới', content = 'Nội dung mới' WHERE id = 1;
