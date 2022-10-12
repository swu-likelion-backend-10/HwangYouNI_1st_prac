

package session_2.Assignment.Post.dto;

import lombok.*;
import session_2.Assignment.Post.domain.Board;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;


@Getter
public class BoardDto {
    private Long id;
    private String name;
    private String depart;
    private String age;
    private String introduction;

    private String title;

    private String contents;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .name(name)
                .depart(depart)
                .age(age)
                .introduction(introduction)
                .title(title)
                .contents(contents)
                .build();
        return  build;
    }

    @Builder
    public BoardDto(Long id,String name,String depart,String age,String introduction,String contents, String title, LocalDateTime createdTime,LocalDateTime modifiedTime){
        this.id = id;
        this.name = name;
        this.depart = depart;
        this.age = age;
        this.introduction = introduction;
        this.title = title;
        this.contents = contents;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }
}
