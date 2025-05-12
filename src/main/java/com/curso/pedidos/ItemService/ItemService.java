package com.curso.pedidos.ItemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.pedidos.Repository.ItemRepository;
import com.curso.pedidos.models.Item;
import com.curso.pedidos.models.PedidoItem;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public Optional<Item> getItemsById(Long id){
        return itemRepository.findById(id);
    }

    public Item insertItem(Item item){
        return itemRepository.save(item);
    }

    public Item attItem(Long id, String nome){
        Optional<Item> itemQuePodeExistir = itemRepository.findById(id);
        if(itemQuePodeExistir.isPresent()){
            Item itemSlavo = itemQuePodeExistir.get();
            itemSlavo.setNome(nome);
            return itemRepository.save(itemSlavo);
        }else{
            return null;
        }
    }

    public void deactiveItem(Long id){
        Optional<Item> itemExistente = itemRepository.findById(id);
        if(itemExistente.isPresent()){
            itemExistente.get().setAtivado(false);
            itemRepository.save(itemExistente.get());
        }
    }

    public List<Item> listaItem(List<PedidoItem> allPedidoItems){
        List<Item> resultado = new ArrayList<>();
        for(PedidoItem item : allPedidoItems){
            Item itemOptional = itemRepository.findById(item.getIdItem()).orElse(null);
            resultado.add(itemOptional);
        }
        return resultado;
    }
}
