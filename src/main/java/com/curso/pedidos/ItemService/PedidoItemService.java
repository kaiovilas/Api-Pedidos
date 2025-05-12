package com.curso.pedidos.ItemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.pedidos.Repository.PedidoItemRepository;
import com.curso.pedidos.models.PedidoItem;

@Service
public class PedidoItemService {

    @Autowired
    PedidoItemRepository pedidoItemRepository;

    public List<PedidoItem> listarTodos(){
        return pedidoItemRepository.findAll();
    }

    public Optional<PedidoItem> listarId(Long id){
        return pedidoItemRepository.findById(id);
    }

    public void insert(PedidoItem pedidoItem){
        pedidoItemRepository.save(pedidoItem);
    }

    public List<PedidoItem> getPedidoItemBypedidoId(Long pedidoId){
        List<PedidoItem> allPedidoItems = pedidoItemRepository.findAll();
        List<PedidoItem> resultado = new ArrayList<>();
        for(PedidoItem pedidoItem : allPedidoItems){
            if(pedidoItem.getIdPedido().equals(pedidoId)){
                resultado.add(pedidoItem);
            }
        }
        return resultado;
    }
}
