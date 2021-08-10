package br.com.atlantatecnologia.portal.clientes.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*@Getter@Setter //Com isso, em tempo de compilação, é criado os Getters e Setter das variáveis dessa classe*/

@Entity //Informando que essa classe é uma entidade JPA
@Data //Cria os Getters e Setters, também cria o toString, hashCodeEquals, cria um Construtor sem parâmetros e um construtor com os parâmetros obrigatórios.
@NoArgsConstructor //Serve para manter um construtor sem argumentos, um construtor vazio
@AllArgsConstructor //Serve para que o lombok gere um construtor com todos os argumentos, todas as propriedades
@Builder //Gera um padrão Builder dentro de cliente
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Informando que ficará a cargo do banco criar o ID Auto Incremento
	private Integer id; //Caso não seja anotado o @GeneratedValue, o Hibernate vai exigir que esse valor seja populado para prosseguir
	
	@Column(nullable = false, length = 150) //o nullable = false significa not null no banco, ou seja, sempre o nome deve ser informado, e o lenght nesse caso é pra informar que o nome do cliente vai ter no máximo 150 caracteres
	private String nome;
	
	@Column(nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "data_cadastro")
	@JsonFormat(pattern = "dd/MM/yyyy") //Formata a data retornada automaticamente pelo sistema, para o formato "dd/MM/yyyy"
	private LocalDate dataCadastro;
	
	@PrePersist //Quando a entidade Cliente for persistir no banco de dados, antes de persistir será executado o método a baixo. que no caso seta a data de cadastro atual.
	public void prePersist() { 
		setDataCadastro(LocalDate.now()); //Pega a data de cadastro atual do sistema.
	}
	
}
