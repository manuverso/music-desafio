## 🔨 Objetivos do projeto

- O objetivo do projeto é praticar a modelagem de classes e relacionamentos utilizando o Spring Data JPA;
- Implementação da relação entre Artista e Música, visto que um artista pode estar associado a mais de uma música;
- Uma música só deve ser salva no banco de dados, caso o Artista tenha sido previamente cadastrado;
- Utilizar *derived queries* e *JPQL* para verificar se o artista já está cadastrado e buscar músicas por um determinado artista;
- Fiz a integração com a API do GEMINI para buscar informações sobre um determinado artista.


<h2 id="tecnologias">🛠 Tecnologias</h2>
<ul>
  <li>Java: Linguagem de programação utilizada para desenvolver as funções da aplicação.</li>
  <li>Spring: Criei o projeto através do site do <a href=https://start.spring.io/>Spring Initializr</a>, onde já adicionei as dependências do Spring Data JPA e do PostgreSQL.</li>
  <li>PostgreSQL: Banco de dados escolhido para fazer a persistência dos dados, bem como as outras operações envolvendo o CRUD.</li>
  <li>API GEMINI: Serviço da google que utilizei para fazer a busca de dados sobre os artistas.</li>
</ul>
