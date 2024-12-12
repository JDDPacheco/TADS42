package msf.avaliacao1.model;

import java.util.ArrayList;
import java.util.List;

public class Cidade {
    private Long id;
    private String nome;
    private Pais pais;
    private List<Voluntario> voluntarios = new ArrayList<>();
}
