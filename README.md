# PetzAPI
Teste prático DESENVOLVEDOR BACKEND

IDE utilizada: Apache NetBens v12
WebServer desenvolvido: GlassFish V5.0.1
Escolhido o Maven para gerenciamento de Compilação e dependências.

Uso:

A API apresenta serviços de CRUD para as entidades Cliente e Pet.
Seguindo o padrão REST, é possível criar, buscar, atualizar e remover uma entidade do sistema chamando os métodos HTTP tendo como base o Prefixo 'PeatzAPI'.

Exemplo:
  Cadastrar Cliente:
    Método: POSTO
    URL: http://root/PetzAPI/cliete
    Content-type: application/json
    Body resquest: {"nome": "Vitor", "email": "teste@teste.com"}

  Buscar Cliente de ID = 17:
    Método: GET
    URL: http://root/PetzAPI/cliete/17
    Body response: {"id": 17, "Nome":"Jair Bolsonaro", "email": "presidente@brasil.gov.br"}
  
  Deletar PET de ID = 13
    Método: DELETE
    URL: http://root/PetzAPI/pet/17
    Body response: {"status": "OK"}  
  
Para implantação, configurar no servidor escolhido a conexão JDBC associando o JNDI 'app/petzJNDI' com o pool 'microsoft_sql_TESTEVitor_saPool'.

O banco de dadods SQL deverá conter as seguintes tabelas:
CREATE TABLE 'cliente'  (
  'ID' int(11) NOT NULL AUTO_INCREMENT,
  'Nome' varchar(300)NOT NULL,
  'Documento' varchar(20)NULL DEFAULT NULL,
  'Telefone' varchar(20)NULL DEFAULT NULL,
  'Email' varchar(100)NULL DEFAULT NULL,
  'DataNascimento' date NULL DEFAULT NULL,
  PRIMARY KEY ('ID') 
) 


CREATE TABLE 'pet'  (
  'ID' int(11) NOT NULL AUTO_INCREMENT,
  'Nome' varchar(300) NOT NULL,
  'Tipo' varchar(100) NULL DEFAULT NULL,
  'Raca' varchar(100) NULL DEFAULT NULL,
  'DataNascimento' varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY ('ID')
)


