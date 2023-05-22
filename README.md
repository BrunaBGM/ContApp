# ContApp
Contador de calorias

## Endpoints
- Refeicoes
    - [Cadastrar](#cadastrar-refeicao)
    - [Listar](#listar-refeicao)
    - [Editar](#editar-refeicao)
    - [Apagar](#apagar-refeicao)
- Exercicios
    - [Cadastrar](#cadastrar-exercicio)
    - [Listar](#listar-exercicio)
    - [Editar](#editar-exercicio)
    - [Apagar](#apagar-exercicio)
- Usuarios
    - [Cadastrar](#cadastrar-usuario)
    - [Listar](#listar-usuario)
    - [Editar](#editar-usuario)
    - [Apagar](#apagar-usuario)
    
### Cadastrar Refeição

Para cadastrar uma nova refeição, faça uma requisição do tipo `POST` para `/contApp/api/cadastrar-refeicao`. O corpo da requisição deve incluir os seguintes campos:

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|-----------|
| ID | Int | Sim | Identificador único da refeição.
| Categoria-Refeicao | String | Sim | A categoria da  refeição (ex: cafe da manha, almoco, jantar(valor pre-definido).
| Nome  | String | Sim | O nome do alimento a ser cadastrado.
| Categoria-Alimento | String | Sim | A categoria do alimento (ex: Fruta, Legume , Cereais, pães etc ... ).
| Descricao | String | Não | Uma descrição opcional do alimento (até 255 caracteres).|
| Calorias | Int | Sim | Valor calórico do alimento.
| Quantidade | Int | Sim | Quantidade consumida por unidade.

**Exemplo de corpo da requisição**

```js 
{
    "id": 1,
    "categoria_refeicao": "cafe da manha",
    "nome": "Banana",
    "categoria_alimento": "fruta",
    "descricao": "Uma fruta rica em potássio e fibras",
    "calorias": 89,
    "quantidade": 1
}
```
**Códigos de resposta**

|Código | Descrição
|-|-
|201 | Refeição cadastrada com sucesso!
|404 | Erro na validação dos dados da requisição.

### Listar Refeição

Para listar todas as  refeições cadastradas, faça uma requisição do tipo `GET` para `/contApp/api/listar-refeicao`.

**Código de resposta**

| Código | Descrição
|-|-
| 200 | Lista de refeições retornada com sucesso!


### Editar Refeição

Para editar uma refeição existente, faça uma requisição do tipo `PUT` para `/contApp/api/editar-refeicao/{id}`. O {id} deve ser substituído pelo ID da refeição a ser editado. O corpo da requisição deve incluir os campos que serão atualizados:

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|-----------|
| Categoria-Refeicao | String | Não | Nova categoria da refeição.
| Nome  | String | Não | Novo nome para alimento.
| Categoria | String | Não | A nova categoria do alimento.
| Descricao | String | Não | Uma nova descrição para o alimento.
| Calorias | Int | Não | Novo valor para calorias.
| Quantidade | Int | Não | Novo valor para quantidade.

**Exemplo de corpo da requisição**

```js
{
    "nome": "Manga",
    "calorias": 204,
    "quantidade": 1
}
```

**Códigos de resposta**

| Código | Descricão
|-|-
| 200 | Refeição editada com sucesso!
| 404 | Refeição não encontrada.


### Apagar Alimento

Para apagar um refeição cadastrada, faça uma requisição do tipo `DELETE` para `/contApp/api/apagar-refeicao/{id}`, onde {id} é o identificador único da refeição.

| Código | Descrição
|-|-
| 200 | Refeição apagada com sucesso!
| 404 | Refeição não encontrada.

### Cadastrar Exercicio

Para cadastrar um novo exercício, faça uma requisição do tipo `POST` para `/contApp/api/cadastrar-exercicio`. O corpo da requisição deve incluir os seguintes campos:

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|-----------|
| ID | Int | Sim | Identificador único do exercício |
| Nome | String| Sim | Nome do exercício |
| Descricao | String | Não | Descrição do exercício (até 255 caracteres)|
| Categoria | String | Não | Categoria do exercício (ex: musculação, corrida, natação) |
| Duracao | Int | Não | Duração do exercício em minutos |
| Distancia | Int | Não | Distância percorrida no exercício |
| Peso | Int | Não | Peso utilizado no exercício |
| Repeticoes | Int | Não | Número de repetições realizadas |
| Data | Date | Sim | Data em que o exercício foi realizado |

**Exemplo de corpo de requisição** 

```js 
{
  "id": 1,
  "nome": "Supino reto",
  "descricao": "Exercício para peitoral e tríceps",
  "categoria": "Musculação",
  "duracao": 45,
  "distancia": null,
  "peso": 60,
  "repeticoes": 10,
  "data": "2023-03-04"
}

```
**Códigos de resposta**

| Código | Descricão
|-|-
| 201 | Alimento cadastrado com sucesso!
| 404 | Erro na validação dos dados da requisição.

### Listar Exercicio

Para listar todos os exercicios cadastrados, faça uma requisição do tipo `GET` para `/contApp/api/listar-exercicio`.

**Código de resposta**

| Código | Descricão
|-|-
| 200 | Lista de exercicios retornada com sucesso!

### Editar Exercicio

Para editar um exercicio existente, faça uma requisição do tipo `PUT` para `/contApp/api/editar-exercicio/{id}`. O {id} deve ser substituído pelo ID do exercicio a ser editado. O corpo da requisição deve incluir os campos que serão atualizados (os campos que não forem informados serão mantidos com os valores atuais do exercicio):

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|-----------|
| Nome | String| Não | Novo exercício.
| Descricao | String | Não | Nova descrição do exercício (até 255 caracteres).
| Categoria | String | Não | Nova categoria do exercício.
| Duracao | Int | Não | Novo valor para duração do exercício.
| Distancia | Int | Não | Nova distância percorrida no exercício.
| Peso | Int | Não | Novo peso utilizado no exercício.
| Repeticoes | Int | Não | Novo número de repetições.

**Exemplo de corpo da requisição**

```js
{
    "nome": "Esteira",
    "duracao": 30,
    "distancia": 9
}
```

**Códigos de resposta**

| Código | Descricão
|-|-
| 200 | Exercicio editado com sucesso!
| 404 | Exercicio não encontrado.


### Apagar Exercicio

Para apagar um exercicio cadastrado, faça uma requisição do tipo `DELETE` para `/contApp/api/apagar-exercicio/{id}`, onde {id} é o identificador único do exercicio.

| Código | Descricão
|-|-
| 200 | Exercicio apagado com sucesso!
| 404 | Exercicio não encontrado.


### Cadastrar Usuário

Para cadastrar um usuário, faça uma requisição do tipo `POST` para `/contApp/api/cadastrar-usuario`. O corpo da requisição deve incluir os seguintes campos:

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|-----------|
| ID | Int | Sim | Identificador único do usuário.
| Nome | String| Sim | Nome do usuário.
| Email | String| Sim | Email do usuário.
| Senha | String| Sim | A senha do usuário a ser cadastrado (entre 6 e 20 caracteres).
| Genero | String | Sim | Gênero do usuário (ex: Feminino, Masculino).
| Idade | Int | Não | Uma descrição opcional da idade do usuário em anos.
| Peso | Float | Sim | O peso do usuário em quilogramas.
| Altura | Float | Sim | A altura do usuário em metros.
| Data | Date | Sim | Data de criação do usuario.

**Exemplo de corpo da requisição**

```js
{
    "nome": "Maria da Silva",
    "email": "maria.silva@gmail.com",
    "senha": "123456",
    "genero": "Feminino",
    "idade": 30,
    "peso": 50,
    "altura": 1.6,
    "data": "2023-03-04"
}
```

**Códigos de resposta**

| Código | Descricão
|-|-
| 201 | Usuário cadastrado com sucesso!
| 404 | Erro na validação dos dados da requisição.

### Listar Usuário

Para listar todos os usuários cadastrados, faça uma requisição do tipo `GET` para `/contApp/api/listar-usuário`.

**Código de resposta**

| Código | Descricão
|-|-
| 200 | Lista de usuários retornada com sucesso!

### Editar Usuário

Para editar um usuário cadastrado, faça uma requisição do tipo `PUT` para `/contApp/api/editar-usuario/{id}`, onde {id} é o identificador único do usuário. O corpo da requisição deve incluir os seguintes campos (os campos que não forem informados serão mantidos com os valores atuais do usuário):

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|-----------|
| Nome | String| Não | Nome do usuário.
| Email | String| Não | Email do usuário.
| Senha | String| Não | A senha do usuário a ser cadastrado (entre 6 e 20 caracteres).
| Genero | String | Não | Gênero do usuário (ex: Feminino, Masculino).
| Idade | Int | Não | Uma descrição opcional da idade do usuário em anos.
| Peso | Float | Não | O peso do usuário em quilogramas.
| Altura | Float | Não | A altura do usuário em metros.

**Exemplo de corpo da requisição**
| Código | Descricão
|-|-
| 200 | Usuário editado com sucesso!
| 404 | Usuário não encontrado.

### Apagar Usuário

Para apagar um usuário cadastrado, faça uma requisição do tipo `DELETE` para `/contApp/api/apagar-usuario/{id}`, onde {id} é o identificador único do usuário.

**Códigos de resposta**
| Código | Descricão
|-|-
| 201 | Usuário apagado com sucesso!
| 404 | Usuário não encontrado.
