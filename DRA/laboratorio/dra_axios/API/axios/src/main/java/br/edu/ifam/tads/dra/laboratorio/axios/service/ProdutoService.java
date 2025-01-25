package br.edu.ifam.tads.dra.laboratorio.axios.service;

import br.edu.ifam.tads.dra.laboratorio.axios.dto.ProdutoInputDTO;
import br.edu.ifam.tads.dra.laboratorio.axios.dto.ProdutoOutputDTO;
import br.edu.ifam.tads.dra.laboratorio.axios.model.Produto;
import br.edu.ifam.tads.dra.laboratorio.axios.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoOutputDTO> list(){
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoOutputDTO> produtosDTO = new ArrayList<>();
        for(Produto produto: produtos){
            produtosDTO.add(new ProdutoOutputDTO(produto));
        }
        return produtosDTO;
    }

    public ProdutoOutputDTO create(ProdutoInputDTO produtoInputDTO){
        return new ProdutoOutputDTO(produtoRepository.save(produtoInputDTO.build()));
    }

    public ProdutoOutputDTO getById
}
