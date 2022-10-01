

package session_2.Assignment.Post.dto;

import lombok.Builder;
import lombok.Getter;
import session_2.Assignment.Post.domain.Board;

import java.time.LocalDateTime;
@Getter
public class BoardDto {
    private Long id;
    private String title;
    private String contents;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .title(title)
                .contents(contents)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String title, String contents, LocalDateTime createdTime, LocalDateTime modifiedTime){
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }
}
