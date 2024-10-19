package model;

import javax.persistence.*;

@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 7)
    private String ibge;

    @Column(nullable = true, length = 2)
    private String estado;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getIbge() {return ibge;}

    public void setIbge(String ibge) {this.ibge = ibge;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    public Cidade(String nome, String ibge, String estado) {
        this.nome = nome;
        this.ibge = ibge;
        this.estado = estado;
    }

    public Cidade() {}
}
