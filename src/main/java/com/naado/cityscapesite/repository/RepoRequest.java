package com.naado.cityscapesite.repository;

import com.naado.cityscapesite.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoRequest extends JpaRepository<Request, Integer> {
    public RepoTown findById(int id);
}
