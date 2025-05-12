package com.curso.pedidos.ItemService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.pedidos.DTO.PedidoDTO;
import com.curso.pedidos.DTO.PedidodetailDTO;
import com.curso.pedidos.Repository.PedidoRepository;
import com.curso.pedidos.models.Item;
import com.curso.pedidos.models.Pedido;
import com.curso.pedidos.models.PedidoItem;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PedidoItemService pedidoItemService;

    @Autowired
    ItemService itemService;

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Pedido criarPedido(PedidoDTO pedido) {
        Pedido savedPedido = pedidoRepository.save(pedido.toEntity());
        for(Long item : pedido.getItens()){
            PedidoItem pedidoItem = new PedidoItem();
            pedidoItem.setIdItem(item);
            pedidoItem.setIdPedido(savedPedido.getId());
            pedidoItemService.insert(pedidoItem);
        }
        return savedPedido;
    }

    public PedidodetailDTO buscarPedidoId(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            List<PedidoItem> listaPedidosItens =  pedidoItemService.getPedidoItemBypedidoId(id);
            PedidodetailDTO pedidodetailDTO = new PedidodetailDTO();
            List<Item> listaItens = itemService.listaItem(listaPedidosItens);
            pedidodetailDTO.setItens(listaItens);
            pedidodetailDTO.setPedido(pedido.get());
            return pedidodetailDTO;
        }
        return null;
    }

    public void deactivePedido(Long id) {
        Optional<Pedido> pedidoExistente = pedidoRepository.findById(id);
        if (pedidoExistente.isPresent()) {
            pedidoExistente.get().setAtivado(false);
            pedidoRepository.save(pedidoExistente.get());
        }
    }
}
