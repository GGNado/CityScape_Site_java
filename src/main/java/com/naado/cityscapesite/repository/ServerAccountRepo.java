package com.naado.cityscapesite.repository;

import com.naado.cityscapesite.model.ServerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerAccountRepo extends JpaRepository<ServerAccount, Integer> {
    ServerAccount findById(int id);
    ServerAccount findByNickname(String username);
}
