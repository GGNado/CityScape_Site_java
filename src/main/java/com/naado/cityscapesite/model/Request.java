package com.naado.cityscapesite.model;

import com.naado.cityscapesite.enums.Problem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "Requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Problem problem;

    @Column(unique = true, nullable = false)
    private String mail;

    @Column(nullable = false)
    @Lob
    private String text;


    public String getProbleName(){
        return problem.name();
    }
}
