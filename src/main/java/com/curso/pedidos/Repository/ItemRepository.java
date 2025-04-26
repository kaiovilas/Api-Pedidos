package com.curso.pedidos.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.curso.pedidos.models.Item;

@Repository
public interface ItemRepository extends JpaRepository <Item, Long> {

}
