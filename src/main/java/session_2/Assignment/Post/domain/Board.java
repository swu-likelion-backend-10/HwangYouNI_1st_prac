package session_2.Assignment.Post.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import session_2.Assignment.Post.dto.BoardDto;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private String contents;


    @Builder
    public Board(Long id, String title, String contents){
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;


    public void update(BoardDto boardDto){
        this.title = boardDto.getTitle();
        this.contents = boardDto.getContents();
    }
}

