package br.com.atlantatecnologia.portal.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atlantatecnologia.portal.clientes.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
		
}
