# Sistema de Cadastro de Usuários via CLI

## Descrição

Este é um sistema de cadastro de usuários desenvolvido em Java, utilizando o paradigma de Orientação a Objetos (OO). O sistema permite gerenciar um formulário dinâmico, cadastrar usuários, listar informações, realizar buscas por termos específicos e validar os dados inseridos. Todas as informações são armazenadas em arquivos no sistema de arquivos local.

## Funcionalidades

### Cadastro de Usuários:
- Captura respostas para perguntas dinâmicas do formulário;
- Valida nome, email, idade e altura;
- Garante que emails duplicados não sejam cadastrados.
- Salva as informações do usuário em arquivos individuais.

### Gerenciamento do Formulário:
- Adiciona novas perguntas ao formulário.
- Deleta perguntas existentes (exceto as quatro primeiras).

### Listagem de Usuários:
- Lista todos os usuários cadastrados com base nos arquivos salvos.

### Busca de Usuários:
- Permite buscar usuários por nome, email ou idade.
- Exibe todas as correspondências encontradas.

### Validações no Cadastro:
- Nome deve ter no mínimo 10 caracteres.
- Email deve conter o caractere `@`.
- Idade deve ser maior que 18 anos.
- Altura deve ser fornecida no formato numérico com vírgula (ex.: 1,75).
- Não permite emails duplicados.


## Como Executar o Projeto

### Clone o Repositório:
```bash
git clone git@github.com:mariaeac/sistema-cadastro.git
```

### Compile o Código:
Se estiver usando a linha de comando:
```bash
javac Main.java
```

### Execute o Programa:
```bash
java Main.java
```

