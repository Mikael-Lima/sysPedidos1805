package br.com.itilh.bdpedidos.sistemaspedidos.model;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "tb_municipios")
public class Municipio {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqMunicipio")
    @SequenceGenerator(name = "seqMunicipio", sequenceName="tb_municipios_id_seq", allocationSize= 1)
    private BigInteger id;

    @Column(name="tx_nome")
    private String nome;
    
    @Column(name="bo_entrega")
    private Boolean entrega;

    @ManyToOne
    @JoinColumn(name="id_estado")
    private Estado estado;
    
}
