package com.example.itens.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;

@Entity
public class Itens {
        Long id;
        String nome;
        Integer quantidade;
        Double preco;
    
        public Itens(Long id, String nome, Integer quantidade, Double preco) {
            this.id = id;
            this.nome = nome;
            this.quantidade = quantidade;
            this.preco = preco;
        }
        
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public Integer getQuantidade() {
            return quantidade;
        }
        public void setQuantidade(Integer quantidade) {
            this.quantidade = quantidade;
        }
        public Double getPreco() {
            return preco;
        }
        public void setPreco(Double preco) {
            this.preco = preco;
        }
 }
