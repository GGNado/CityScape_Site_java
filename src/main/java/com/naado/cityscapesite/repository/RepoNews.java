package com.naado.cityscapesite.repository;

import com.naado.cityscapesite.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoNews extends JpaRepository<News, Integer> {
    public RepoNews findById(int id);
    public List<News> findByIsFeatured(boolean isFeatured);
}
