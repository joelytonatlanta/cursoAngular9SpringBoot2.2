package br.com.atlantatecnologia.portal.clientes.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity //Classe responsável pelos serviços
@Data
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 150)
	private String descricao;
	
	@ManyToOne //São muitos serviços para um cliente
	@JoinColumn(name = "id_cliente") //Significa que a tabela serviço, vai ter uma chave estrangeira para a tabela de clientes.
	private Cliente cliente;
	
	@Column // quando o column não tem (name = ) significa que o nome da coluna no BD será o nome do atributo, no caso o nome do atributo é valor  
	private BigDecimal valor;

}
