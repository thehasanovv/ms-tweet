package com.example.ms.tweet.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String title;

    @OneToOne(
            mappedBy = "post",
            cascade = ALL,
            fetch = LAZY
    )
    @ToString.Exclude
    private PostDetailEntity detail;

    @OneToMany(
            mappedBy = "post",
            cascade = ALL
    )
    @ToString.Exclude
    private List<CommentEntity> comments;

    @ManyToMany(cascade = ALL)
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @ToString.Exclude
    private List<TagEntity> tags;


}
