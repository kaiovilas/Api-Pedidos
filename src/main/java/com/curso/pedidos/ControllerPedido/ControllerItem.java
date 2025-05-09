package com.curso.pedidos.ControllerPedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.pedidos.ItemService.ItemService;
import com.curso.pedidos.models.Item;

@RestController
public class ControllerItem {

    @Autowired
    ItemService itemService;

    @GetMapping("/item")
    public List<Item> getItem() {
        return itemService.getItems();
    }

    @PostMapping ("/item")
    public Item addItem(@RequestBody Item item) {
        return itemService.insertItem(item);
    }

    @PutMapping("/item/{id}/nome/{nome}")
    public Item atualizarItem(@PathVariable("id") Long id, @PathVariable("nome") String nome){
        return itemService.attItem(id, nome);
    }

    @PutMapping("/item/desativa/{id}")
    public void desativarItem(@PathVariable("id") Long id){
        itemService.deactiveItem(id);
    }

}
