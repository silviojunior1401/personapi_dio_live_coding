<h2>Digital Innovation One: Expert class - Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot</h2>

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/people
```
-------------------------------------------------------------
Alterações realizadas no projeto original:

 - Criação de Model, DTO, Exception, Mapper, Repository, Service e Controller para a Criação, Manutenção e Exclusão de Empresas.
 - Alteração da Entidade "Person", que agora é relacionada a uma empresa cadastrada.

Manutenção das Empresas realizada pelo seguinte endereço:

```
http://localhost:8080/api/v1/company
```
