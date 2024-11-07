package com.naado.cityscapesite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @OneToMany(mappedBy="role", fetch = FetchType.LAZY)
    private List<ServerAccount> serverAccounts;
}