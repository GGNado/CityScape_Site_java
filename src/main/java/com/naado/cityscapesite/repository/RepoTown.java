package com.naado.cityscapesite.repository;

import com.naado.cityscapesite.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoTown extends JpaRepository<Town, Integer> {
    public Town findById(int id);
}
