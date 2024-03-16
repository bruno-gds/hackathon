<a name="readme-top"></a>

# Introdução

O projeto em questão é um Sistema de Hospitalidade, uma plataformas bem simples voltada para pequenos Hotéis e Pousadas.


## Sumário
* [Instruções](#instruções)
* [CRUD de Video](#crud-de-video)
* [Upload de Video](#upload-de-video)
* [Pesquisa Videos](#pesquisa-videos)
* [Obter Url](#obter-url)
* [Favoritar Video](#favoritar-video)
* [Recomendação de Videos](#recomendacao-de-videos)
* [Estatística](#estatistica)
* [Usuário](#usuario)
* [Tecnologias](#tecnologias)
* [Desafios](#desafios)


## Instruções

- Maven: Para build do projeto. **Para buildar:** mvn clean install
- Foi utilizado Lombok, Validation e MongoDB, portanto é necessário adicionar os plugins na IDE

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

<a name="funcionalidades-do-projeto"></a>
## 🔨  Funcionalidades do projeto

### CRUD Cliente

>[ Base URL: http://localhost:8080 ]

### ``POST``  
`*Para cadastrar Cliente`

```
	/clientes
```
<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:8080/clientes' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome": "Pedro Gonçalves Nunes",
    "cpf": "041.276.747-33",
    "dataNascimento": "1990-10-02",
    "telefone": "(27)9999-3333",
    "email": "pedro@gmail.com"
}'
```
</details>


<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para obter Video por id`

```
	/videos/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:8080/videos/65a5b14ba6bf7a1d75bbc83d'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornado o video`

```
{
    "id": "65a5b14ba6bf7a1d75bbc83d",
    "titulo": "Robocop",
    "descricao": "Policial fatalmente ferido é usado como cobaia por uma empresa de tecnologia robótica",
    "dataPublicacao": "2024-01-08",
    "quantidadeVisualizacao": 2,
    "categoria": "FICCAO"
}
```

404 - _Not Found_

```
{
    "code": "tc.videoNaoEncontrado",
    "message": "Video não encontrado."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para obter a lista de videos paginado e ordenado por data publicação`

```
	/videos
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:8080/videos?pagina=0&tamanho=5'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornada a lista de videos`

```
[
    {
        "id": "65b59a22b9009143a85ee07e",
        "titulo": "Nemo",
        "descricao": "A história de um peixe-palhaço aventureiro",
        "dataPublicacao": "2024-01-27",
        "quantidadeVisualizacao": 0,
        "categoria": "ANIMACAO"
    },
    {
        "id": "65b2ca7d0b134c5bdd2bf7c6",
        "titulo": "Lili",
        "descricao": "uma chihuwawa caramelo",
        "dataPublicacao": "2024-01-25",
        "quantidadeVisualizacao": 0,
        "categoria": "ANIMACAO"
    },
    {
        "id": "65b0474705db02742c9d0bba",
        "titulo": "Monstros",
        "descricao": "Pessoas são obrigadas a atravessar o território hostil infectado por aliens.",
        "dataPublicacao": "2024-01-23",
        "quantidadeVisualizacao": 0,
        "categoria": "TERROR"
    },
    {
        "id": "65ac5e6ebc5f92526a7184b8",
        "titulo": "Interestelar",
        "descricao": "Um grupo de astronautas recebe a missão de verificar possíveis planetas para receberem a população mundial",
        "dataPublicacao": "2024-01-20",
        "quantidadeVisualizacao": 1,
        "categoria": "FICCAO"
    },
    {
        "id": "65ac5e17bc5f92526a7184b7",
        "titulo": "A Origem",
        "descricao": "Em um mundo onde é possível entrar na mente humana e roubar segredos valiosos do inconsciente",
        "dataPublicacao": "2024-01-20",
        "quantidadeVisualizacao": 0,
        "categoria": "FICCAO"
    }
]
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``PUT``
`*Para alteração de dados do Video`

```
	/videos/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request PUT 'http://localhost:8080/videos/65a5b14ba6bf7a1d75bbc83d' \
--header 'Content-Type: application/json' \
--data '{
    "titulo": "Robocop - O Policial do Futuro",
    "descricao": "Policial fatalmente ferido é usado como cobaia por uma empresa de tecnologia robótica",
    "categoria": "ACAO"
}'
```
</details>
<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_

```
```
404 - _Not Found_  

```
{
    "code": "tc.videoNaoEncontrado",
    "message": "Video não encontrado."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``DELETE``
`*Para excluir o cadastro do video`

```
	/videos/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request DELETE 'http://localhost:8080/videos/65a5b026ecad581794fcb2d3'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_

```
```

</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
### Upload de Video

>[ Base URL: http://localhost:8080 ]

Após a etapa bem-sucedida de criar/cadastrar um video, é possível realizar o upload do arquivo de video.
Para essa funcionalidade, implementamos uma solução bem simples, armazenando os videos em nosso sistema de arquivos local.
Os arquivos serão salvos com o id do video já cadastrado anteriormente.

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``
`*Para realizar o upload de arquivo de video`

```
	/videos/{id}/upload
```
<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location 'http://localhost:8080/videos/65ac5d60bc5f92526a7184b6/upload' \
--form 'file=@"/home/tati/Vídeos/20240124_184058.mp4"'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_

```
```

</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
### Pesquisa Videos

>[ Base URL: http://localhost:8080 ]

A pesquisa de video por filtros facilita a localização dos videos desejados, permitindo que o usuário refine sua busca por: título, dataPublicacao ou categoria.

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para pesquisar por videos utilizando filtros de busca`

```
	/videos/filtros
```
<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location 'http://localhost:8080/videos/filtros?titulo=robocop&dataPublicacao=2024-01-08&categoria=FICCAO'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Serão retornados os videos desejados`

```
[
    {
        "id": "65a5b14ba6bf7a1d75bbc83d",
        "titulo": "Robocop - O Policial do Futuro",
        "descricao": "Policial fatalmente ferido é usado como cobaia por uma empresa de tecnologia robótica",
        "dataPublicacao": "2024-01-08",
        "quantidadeVisualizacao": 2,
        "categoria": "FICCAO"
    }
]
```
200 - _OK_
`- Caso não tenha encontrado nenhum registro`

```
[]
```
</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
### Obter URL

>[ Base URL: http://localhost:8080 ]

Após o usuário selecionar o video desejado, a aplicação disponibiliza uma URL para download de arquivo do video escolhido, permitindo ao usuário assistir ao conteúdo.

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para obter url para download`

```
	/videos/{id}/url
```
<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location 'http://127.0.0.1:8080/videos/65ac5d60bc5f92526a7184b6/url'
```

</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornada a url de download`

```
http://localhost:8081/65ac5d60bc5f92526a7184b6.mp4
```

</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
### Favoritar Video

>[ Base URL: http://localhost:8080 ]

A funcionalidade de Favoritar Vídeo permite que o usuário marque os vídeos que mais lhe agradaram.

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``
`*Para favoritar o video`

```
	/videos/{id}/favoritos/{usuarioId}
```
<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location --request POST 'http://localhost:8080/videos/65b2ca7d0b134c5bdd2bf7c6/favoritos/65a71b4d2a165a93957d321d'
```

</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornado o id de favorito`

```
65b310dbaf84df654ece47ea
```

422 - _OK_
`- Caso o usuário tente favoritar o mesmo video mais de uma vez`

```
{
    "code": "tc.videoFavoritadoMaisDeUmaVezPeloUsuario",
    "message": "Video não pode ser favoritado mais de uma vez pelo mesmo usuário."
}
```

</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
### Recomendação de Videos

>[ Base URL: http://localhost:8080 ]

Nosso sistema oferece a funcionalidade de recomendar vídeos aos usuários com base em suas listas de favoritos. 

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para recomendação de videos`

```
	/videos/recomendacoes/{usuarioId}
```
<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location 'http://localhost:8080/videos/recomendacoes/65a71b4d2a165a93957d321d'
```

</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornada uma lista com videos recomendados`

```
[
    {
        "id": "65a5b14ba6bf7a1d75bbc83d",
        "titulo": "Robocop - O Policial do Futuro",
        "descricao": "Policial fatalmente ferido é usado como cobaia por uma empresa de tecnologia robótica",
        "dataPublicacao": "2024-01-08",
        "quantidadeVisualizacao": 2,
        "categoria": "FICCAO"
    },
    {
        "id": "65ac5d60bc5f92526a7184b6",
        "titulo": "Distrito 9",
        "descricao": "Há 20 anos uma gigantesca nave espacial pairou sobre a capital da África do Sul",
        "dataPublicacao": "2024-01-20",
        "quantidadeVisualizacao": 6,
        "categoria": "FICCAO"
    },
    {
        "id": "65ac5e17bc5f92526a7184b7",
        "titulo": "A Origem",
        "descricao": "Em um mundo onde é possível entrar na mente humana e roubar segredos valiosos do inconsciente",
        "dataPublicacao": "2024-01-20",
        "quantidadeVisualizacao": 0,
        "categoria": "FICCAO"
    }
]
```

</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
### Estatística

>[ Base URL: http://localhost:8080 ]

Nossa plataforma também oferece funcionalidades de estatísticas, exibindo informações como a quantidade total de vídeos, o número de vídeos favoritados e a média de visualizações. Esses dados permitem aos usuários e administradores compreenderem melhor o uso da plataforma e o envolvimento com o conteúdo. 

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para visualizar estatísticas da plataforma`

```
	/videos/estatisticas
```
<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location 'http://localhost:8080/videos/estatisticas'
```

</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_

```
Total de videos: 7
Total de videos favoritados: 6
Media de visualizacoes: 1.2857142857142858

```

</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
### Usuário

> UsuarioDocument

Na versão atual do sistema, não há um endpoint disponível para o cadastro de usuários. Para garantir o funcionamento adequado do sistema, é essencial realizar uma carga inicial no banco de dados, inserindo os nomes das pessoas para criar os registros de usuário necessários. Isso assegurará que o sistema opere adequadamente. 

<details>
  <summary>Modelo JSON para criar o usuário conforme mencionado:</summary>

```
{
  "nome": "Nome Usuario"
}
```

</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
<a name="tecnologias"></a>
## 📍️ Tecnologias

- As API's foram construídas em Java 17 utilizando Spring Framework 3.2.1
- Padrão REST na construção das rotas e retornos
- SLF4J para registro de logs
- Utilização de código limpo e princípios **SOLID**
- Boas práticas da Linguagem/Framework
- Clean architecture
- Banco de Dados MongoDB
- JUnit e Mockito

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

<a name="desafios"></a>
## 📍️ Desafios

Durante o desenvolvimento do projeto, optamos por não utilizar o WebFlux principalmente devido à predominância do CRUD da aplicação. Além disso, houve uma mudança nos requisitos que permitiu a disponibilização direta do link do vídeo, eliminando a necessidade de recursos avançados fornecidos pelo WebFlux.

No entanto, essa decisão foi tomada um pouco tarde, já que havíamos iniciado o projeto utilizando o MongoDB, que não era nossa primeira escolha de banco de dados. Isso resultou em contratempos adicionais com testes unitários e de integração.

Também reconhecemos a ausência da prática de Desenvolvimento Orientado por Testes (TDD) em nosso fluxo de trabalho diário. Isso impactou a capacidade de antecipar e resolver questões de teste desde o início do desenvolvimento, resultando em uma abordagem mais reativa em relação aos testes.


<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>
