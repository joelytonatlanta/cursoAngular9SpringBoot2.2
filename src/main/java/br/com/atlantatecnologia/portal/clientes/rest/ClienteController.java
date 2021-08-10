package br.com.atlantatecnologia.portal.clientes.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.atlantatecnologia.portal.clientes.model.entity.Cliente;
import br.com.atlantatecnologia.portal.clientes.model.repository.ClienteRepository;

@RestController //Classe reconhecida no contexto da aplicação como controlador rest, ou seja, vai ser a classe que vai criar a API de clientes que vai receber as requisições e enviar as respostas HTTP Rest para os Clients
@RequestMapping("/clientes") //Mapear qual será a URL base que será tratada dentro desse controller
public class ClienteController {
	
	//A anotação ResponseBody que está dentro da anotação RestController significa que o que for retornado nos métodos nas requisições vai ser o corpo da resposta, não e necessário realizar nenhuma conversão pra transformar no corpo da requisição.
	
	private final ClienteRepository repository; // (O final é para que nesse caso a criação da classe comece pelo construtor) => É uma dependência obrigatória para que a classe funcione

	@Autowired //Realizando injeção de dependências, nesse caso na construção da classe é obrigatório repassar o ClienteRepository
	public ClienteController(ClienteRepository repository) {
		this.repository = repository;
	}
	
	//Será recebido um cliente via JSON, será feito uma requisição JSON pela aplicação ANGULAR, que repassará as propriedades como nome e CPF, a data de cadastro é automática, e o ID é gerado automaticamente pelo banco, será acionado o repositório para salvar o cliente no banco de dados, e será retornado um OK de cliente salvo em HTTP.
	@PostMapping //Quando for feito um POST para o endereço /api/clientes passando um cliente JSON automaticamente entrará no método salvar
	@ResponseStatus(HttpStatus.CREATED) //Essa anotation retorna código Status CREATED (201) informando que o cadastro foi realizado com sucesso
	public Cliente salvar(@RequestBody Cliente cliente){ // O @RequestBody indica que esses valores vão vir no corpo da requisição POST, então será feito a conversão do OBJETO que vai vir do tipo JSON, e vai converter para o tipo Cliente
		return repository.save(cliente);
	} //Método para salvar um cliente
	
	//Quando a Anotation @ResponseStatus não for declarada o retorno será o padrão, retorno 200 ("ok")
	@GetMapping("{codigo}") //Quando for feito um GET para o endereço /api/clientes passando um ID, será retornado as informações do cliente em JSON
	public Cliente acharPorId(@PathVariable("codigo") Integer id){ //Na Anotation @PathVariable indica que a variável id receberá o valor do PATH {id}
		return repository
				.findById(id) //Vai lá no repositório, obter um cliente por esse ID, a chamada a esse método retorna um Objeto do tipo Optional => É um objeto que vai receber o retorno do método e dentro da variável Optional vai guardar um Objeto ou não, se não tiver nenhum Cliente com esse ID ele retornará um Objeto vazio, se tiver um cliente com esse ID, será retornado as informações do cliente normalmente.
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND)); //Na expressão ao lado caso não seja encontrado um objeto com esse ID, será retornado uma Exception (Erro) com o Status HTTP Not_Found (Erro 404)	
	}
	
	@DeleteMapping("{id}")
	public void deletar( @PathVariable Integer id) {
		repository
			.findById(id) //Vai lá no repositório, obter um cliente por esse ID, a chamada a esse método retorna um Objeto do tipo Optional => É um objeto que vai receber o retorno do método e dentro da variável Optional vai guardar um Objeto ou não, se não tiver nenhum Cliente com esse ID ele retornará um Objeto vazio, se tiver um cliente com esse ID, será retornado as informações do cliente normalmente.
			.map( cliente -> {
				
			})
			.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND)); //Na expressão ao lado caso não seja encontrado um objeto com esse ID, será retornado uma Exception (Erro) com o Status HTTP Not_Found (Erro 404)		
	}
	
}
