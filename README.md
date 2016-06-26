# Projeto Desafio Hackerrank

<H2>Base de Dados</H2>
Uma base de dados é carregada automaticamente durante inicialização do sistema. Para isso foi utilizado o H2 que é um banco de dados inicializado em memória e incorporado (Embedded) ao sistema. Para acessá-lo basta adicionar <b>/console</b> a URL raíz do sistema.
<p><b>Configurações de acesso:</b>
- <b>Driver Classe:</b> org.h2.Driver
- <b>JDBC URL:</b> jdbc:h2:mem:testdb
- <b>User Name:</b> sa
- <b>Password:</b> (Vazio)

<H2>Endpoints</H2>
<p><b>CEP</b>
<ul>
<li><b>/buscarCep</b> (Método de requisição POST)</li>
  <ul>
    <li>Serviço de busca de CEP onde, dado um CEP válido, retorna as informações da RUA, BAIRRO, CIDADE E ESTADO. Caso o CEP seja inválido, ou seja, não exista na base de dados, será retornada mensagem "CEP inválido".</li>
  </ul>
<li><b>/listarCeps</b> (Método de requisição GET)</li>
  <ul>
    <li>Serviço de listagem de todos os CEP's cadastrados na base de dados.</li>
  </ul>
</ul>

<p><b>Endereço dos Usuários</b>
<ul>
<li><b>/create</b> (Método de requisição POST)</li>
  <ul>
    <li>Serviço responsável pela criação do endereço de usuário.</li>
  </ul>
<li><b>/read</b> (Método de requisição POST)</li>
  <ul>
    <li>Serviço responsável por buscar um endereço pelo ID.</li>
  </ul>
<li><b>/update</b> (Método de requisição POST)</li>
  <ul>
    <li>Serviço responsável por atualizar um endereço existente.</li>
  </ul>
<li><b>/delete</b> (Método de requisição DELETE)</li>
  <ul>
    <li>Serviço responsável por deletar um endereço de usuário pelo ID.</li>
  </ul>
<li><b>/listarEnderecos</b> (Método de requisição GET)</li>
  <ul>
    <li>Serviço de listagem de todos os endereços cadastrados na base de dados.</li>
  </ul>
</ul>

<B>Advanced REST Client:</B> Foi utilizado essa extensão do Google Chrome para os testes das requisições https://goo.gl/kBqdTK

<H2>Stream</H2>

Disponível no pacote <b>br.com.hack.stream</b> está a lógica solicitada para encontrar, dado um stream, o primeiro caracter que não se repede. Criada uma classe main (StreanMain) apenas para demonstrar o uso do StreamUtil. Também está disponível a classe de teste StreamTest. 
