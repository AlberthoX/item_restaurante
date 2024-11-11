package com.example.itens.service;

import java.util.List;

import com.example.itens.model.Item;

import com.example.itens.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public void createItem(Item request){
        if(request.getNome() == null || request.getNome().isBlank()) throw new RuntimeException("O nome do Item deve ser diferente de vazio");
        if(request.getPreco() == null || request.getPreco() <= 0) throw new RuntimeException("Preço inválido");
        
        itemRepository.save(request);
    }

    public Item getItemById(Long id){
        if(id == null) throw new RuntimeException("id não válido");
        return itemRepository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException("Item Não encontrado")
                );
    }

    public void updateItemById(Long id, Item update){
        if(update.getNome() == null || update.getNome().isBlank()) throw new RuntimeException("O nome do Item deve ser diferente de vazio");
        if(update.getPreco() == null || update.getPreco() <= 0) throw new RuntimeException("Preço inválido");
        Item item = itemRepository.findById(id)
            .orElseThrow(
                () -> new RuntimeException("Item Não encontrado")
            );
        item.setNome(update.getNome());
        item.setPreco(update.getPreco());
        itemRepository.save(item); 
    }

    public void deleteItemById(Long id){
        if(id == null) throw new RuntimeException("id não válido");
        itemRepository.deleteById(id);
    }
}
