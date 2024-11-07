package com.naado.cityscapesite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Towns")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrementa
    private int id;

    @Column
    private int idPL;

    @Column(length = 40, nullable = false)
    private String townName;

    @Column(nullable = false)
    private Integer goldBank;

    @Column(nullable = false)
    private Integer regionsCount;

    @Column(length = 40, nullable = false)
    private String mayor;

    @Column(length = 40)
    private String comayor;

    @Column
    private boolean isSpawnOpen;

    @Column
    private Integer spawnCost;

    @Column
    private Integer citizenCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "server_account_nickname", referencedColumnName = "nickname", nullable = false)
    private ServerAccount serverAccount;
}