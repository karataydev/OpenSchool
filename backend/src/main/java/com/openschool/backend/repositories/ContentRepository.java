package com.openschool.backend.repositories;

import com.openschool.backend.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content,Long> {

    List<Content> getContentByCourse_IdOrderByDate(Long id);
}
