package br.com.itilh.bdpedidos.sistemaspedidos.model;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "tb_estados")
public class Estado {
    

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seqEstado", sequenceName="tb_estados_id_seq")
    private BigInteger id;

    @Column(name="tx_nome")
    private String nome;
    
    
    
}
