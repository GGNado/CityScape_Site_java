package com.naado.cityscapesite.repository;

import com.naado.cityscapesite.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoRole extends JpaRepository<Role, Integer> {
    public Role findById(int id);
}
