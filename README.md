# biblioteca-avaliacao-acelera
Projeto para avaliação 0.1 

<h3>Sobre: </h3>

Esse projeto foi feito na inteção de ser uma api rest, onde podemos cadastrar, buscar e alterar altores e livros, além de poder excluir o livro e buscar todos os livros de um determinado autor.

<h3>Tecnologias utilizadas: </h3>

<ul>
  <li>Spring boot, Hibernate, MySql e Java.</li>
</ul>

<h3>Baixando o projeto: </h3>

<ul>
  <li>Baixar o zip do projeto.</li>
  <li>Descompactar a pasta baixada.</li>
</ul>

<h3>Configurando o projeto: </h3>

<ul>
  <li>Criar as seguintes variáveis de ambiente com seus devidos valores, como no exemplo: NOME_DA_VARIAVEL = VALOR</li>
</ul>

    BIBLIOTECA_AVALIACAO_HOST=localhost
    BIBLIOTECA_AVALIACAO_PORT=3306
    BIBLIOTECA_AVALIACAO_NAME=biblioteca
    BIBLIOTECA_AVALIACAO_USER=root
    BIBLIOTECA_AVALIACAO_PASSWORD=root
    BIBLIOTECA_AVALIACAO_HBM2DDL=update

<h3>Executando o projeto: </h3>

<ul>
  <li>Importar o projeto no Spring Tool Suite.</li>
  <li>Executar o projeto.</li>
</ul>

<h3>Testando o projeto: </h3>

  <h4>Endpoints:</h4>

    AUTORES:

    =>POST: localhost:8080/autores = Insere autor.
      Exemplo do Body: 
      {
           "nome":"J. K. Rowling",
            "biografia":"Criadora do Harry Potter"
      }

    =>GET: localhost:8080/autores = Lista autores.

    =>GET: localhost:8080/autores/{id} = Busca autor por id.

    =>PUT: localhost:8080/autores/{id} = Altera autor.
      Exemplo do Body: 
      {
           "nome":"Rick Riordan",
            "biografia":"Professor de Inglês e História"
      }

    LIVROS:

    =>POST: localhost:8080/livros = Insere livro.
      Exemplo do Body: 
      {
          "titulo":"Harry Potter e a Pedra Filosofal",
          "anoLancamento":"2002",
          "autores":[1]
      }

    =>GET: localhost:8080/livros = Lista livros.

    =>GET: localhost:8080/livros/{id} = Busca livro por id.

    =>DELETE: localhost:8080/livros/{id} = Deleta livro a partir do id.

    =>PUT: localhost:8080/livros/{id} = Altera livro.
      Exemplo do Body: 
      {
          "titulo":"Percy Jackson e o Ladrão de Raios",
          "anoLancamento":"2002",
          "autores":[1]
      }

    =>GET: localhost:8080/livros/busca-por-autor/{id} = Busca todos os livros do autor com o id especificado no caminho.

Desenvolvido por: Leonardo Pavani

Fontes de pesquisa: 

<ul>
  <li> https://cursos.alura.com.br/course/spring-boot-api-rest</li>
</ul>
  
