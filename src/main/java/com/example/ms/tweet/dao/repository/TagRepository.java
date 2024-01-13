package com.example.ms.tweet.dao.repository;


import com.example.ms.tweet.dao.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
}
