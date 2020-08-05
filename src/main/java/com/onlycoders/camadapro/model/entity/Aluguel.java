package com.onlycoders.camadapro.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Usuario locatario;
    @ManyToOne
    private Produto produto;
    @Column
    private Date dataInicio;
    @Column
    private Date dataFim;
    @Column
    private Date dataSaque;

}
