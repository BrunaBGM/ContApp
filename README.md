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
| refeicaoId| Int | Sim | Identificador único da refeição.
| categoria-refeicao | String | Sim | A categoria da  refeição (ex: cafe da manha, almoco, jantar(valor pre-definido).
| nome  | String | Sim | O nome do alimento a ser cadastrado.
| categoria-alimento | String | Sim | A categoria do alimento (ex: Fruta, Legume , Cereais, pães etc ... ).
| descricao | String | Não | Uma descrição opcional do alimento (até 255 caracteres).|
| calorias | Int | Sim | Valor calórico do alimento.
| quantidade | Int | Sim | Quantidade consumida por unidade.

**Exemplo de corpo da requisição**

```js 
{
    "refeicaoId": 1,
    "categoria-refeicao": "cafe da manha",
    "nome": "Banana",
    "categoria-alimento": "fruta",
    "descricao": "Uma fruta rica em potássio e fibras",
    "calorias": 89,
    "quantidade": 1,
    "data": "2023-03-04"
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
| categoria-refeicao | String | Não | Nova categoria da refeição.
| nome  | String | Não | Novo nome para alimento.
| categoria | String | Não | A nova categoria do alimento.
| descricao | String | Não | Uma nova descrição para o alimento.
| calorias | Int | Não | Novo valor para calorias.
| quantidade | Int | Não | Novo valor para quantidade.
| data | Date | Sim | Data em que a refeição foi cadastrada.

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

Para apagar um refeição cadastrada, faça uma requisição do tipo `DELETE` para `/contApp/api/apagar-refeicao/{refeicaoId}`, onde {id} é o identificador único da refeição.

| Código | Descrição
|-|-
| 200 | Refeição apagada com sucesso!
| 404 | Refeição não encontrada.

### Cadastrar Exercicio

Para cadastrar um novo exercício, faça uma requisição do tipo `POST` para `/contApp/api/cadastrar-exercicio`. O corpo da requisição deve incluir os seguintes campos:

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|-----------|
| exercicioId | Int | Sim | Identificador único do exercício |
| nome | String| Sim | Nome do exercício |
| descricao | String | Não | Descrição do exercício (até 255 caracteres)|
| categoria | String | Não | Categoria do exercício (ex: musculação, corrida, natação) |
| duracao | Int | Não | Duração do exercício em minutos |
| distancia | Int | Não | Distância percorrida no exercício |
| peso | Int | Não | Peso utilizado no exercício |
| repeticoes | Int | Não | Número de repetições realizadas |
| data | Date | Sim | Data em que o exercício foi realizado |

**Exemplo de corpo de requisição** 

```js 
{
  "exercicioId": 1,
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
| 201 | Exercicio cadastrado com sucesso!
| 404 | Erro na validação dos dados da requisição.

### Listar Exercicio

Para listar todos os exercicios cadastrados, faça uma requisição do tipo `GET` para `/contApp/api/listar-exercicio`.

**Código de resposta**

| Código | Descricão
|-|-
| 200 | Lista de exercicios retornada com sucesso!

### Editar Exercicio

Para editar um exercicio existente, faça uma requisição do tipo `PUT` para `/contApp/api/editar-exercicio/{exercicioId}`. O {exercicioId} deve ser substituído pelo ID do exercicio a ser editado. O corpo da requisição deve incluir os campos que serão atualizados (os campos que não forem informados serão mantidos com os valores atuais do exercicio):

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|-----------|
| nome | String| Não | Novo exercício.
| descricao | String | Não | Nova descrição do exercício (até 255 caracteres).
| categoria | String | Não | Nova categoria do exercício.
| duracao | Int | Não | Novo valor para duração do exercício.
| distancia | Int | Não | Nova distância percorrida no exercício.
| peso | Int | Não | Novo peso utilizado no exercício.
| repeticoes | Int | Não | Novo número de repetições.

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

Para apagar um exercicio cadastrado, faça uma requisição do tipo `DELETE` para `/contApp/api/apagar-exercicio/{exercicioId}`, onde {id} é o identificador único do exercicio.

| Código | Descricão
|-|-
| 200 | Exercicio apagado com sucesso!
| 404 | Exercicio não encontrado.


### Cadastrar Usuário

Para cadastrar um usuário, faça uma requisição do tipo `POST` para `/contApp/api/cadastrar-usuario`. O corpo da requisição deve incluir os seguintes campos:

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|-----------|
| usuarioId | Int | Sim | Identificador único do usuário.
| nome | String| Sim | Nome do usuário.
| email | String| Sim | Email do usuário.
| senha | String| Sim | A senha do usuário a ser cadastrado (entre 6 e 20 caracteres).
| genero | String | Sim | Gênero do usuário (ex: Feminino, Masculino).
| idade | Int | Não | Uma descrição opcional da idade do usuário em anos.
| peso | Double | Sim | O peso do usuário em quilogramas.
| altura | Double | Sim | A altura do usuário em metros.
| data | Date | Sim | Data de criação do usuario.

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

Para editar um usuário cadastrado, faça uma requisição do tipo `PUT` para `/contApp/api/editar-usuario/{usuarioId}`, onde {usuarioId} é o identificador único do usuário. O corpo da requisição deve incluir os seguintes campos (os campos que não forem informados serão mantidos com os valores atuais do usuário):

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|:-------------:|-----------|
| nome | String| Não | Nome do usuário.
| email | String| Não | Email do usuário.
| senha | String| Não | A senha do usuário a ser cadastrado (entre 6 e 20 caracteres).
| genero | String | Não | Gênero do usuário (ex: Feminino, Masculino).
| idade | Int | Não | Uma descrição opcional da idade do usuário em anos.
| peso | Float | Não | O peso do usuário em quilogramas.
| altura | Float | Não | A altura do usuário em metros.

**Exemplo de corpo da requisição**
| Código | Descricão
|-|-
| 200 | Usuário editado com sucesso!
| 404 | Usuário não encontrado.

### Apagar Usuário

Para apagar um usuário cadastrado, faça uma requisição do tipo `DELETE` para `/contApp/api/apagar-usuario/{usuarioId}`, onde {usuarioId} é o identificador único do usuário.

**Códigos de resposta**
| Código | Descricão
|-|-
| 201 | Usuário apagado com sucesso!
| 404 | Usuário não encontrado.
