package br.com.atlantatecnologia.portal.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.atlantatecnologia.portal.clientes.model.entity.Cliente;
import br.com.atlantatecnologia.portal.clientes.model.repository.ClienteRepository;

@SpringBootApplication //Essa anotação informa para o Spring Boot que essa classe deve inicializar a aplicação, e também configura todo o escaneamento de dependencias
public class ClientesApplication {
	
	/*
	 * @Bean //Adicionando um registro no banco TESTE public CommandLineRunner
	 * run(@Autowired ClienteRepository repository){ //Todo o comando
	 * CommandLineRunner com a anotação Bean, é rodado toda vez que a aplicação é
	 * inicializada. return args -> { Cliente cliente =
	 * Cliente.builder().cpf("00233566799").nome("Maria").build(); //No Builder
	 * vamos preenchendo as informações como se fosse um formulário, e no final o
	 * build vai gerar uma instância de cliente com os dados que foram populados
	 * repository.save(cliente); //Serve para que possa persistir/salvar o cliente
	 * no banco de dados. System.out.println(repository.count()); }; }
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args); //Comando para inicializar a aplicação, essa é a classe Main onde toda a aplicação é inicializada.
	}

}
