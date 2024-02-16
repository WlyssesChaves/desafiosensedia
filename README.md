# Testes de API para TheCatAPI

Este projeto contém uma suíte de testes automatizados para o endpoint "Votes" da TheCatAPI. Os testes são escritos em Java usando a biblioteca RestAssured com TestNG.

## Cenários de Teste

Os cenários de teste incluem:

1. **Criação de Voto com Sucesso**: Verifica se um voto pode ser criado com sucesso usando um `image_id` e um `value` válidos.
2. **Falha na Criação de Voto com `image_id` Inválido**: Testa a resposta da API ao tentar criar um voto com um `image_id` inválido.
3. **Listagem de Votos com Sucesso**: Confirma se a listagem de votos é bem-sucedida e se os votos estão sendo retornados.
4. **Deletar Voto com Sucesso**: Garante que um voto possa ser excluído com sucesso.
5. **Falha ao Deletar Voto com ID Inválido**: Verifica a resposta da API ao tentar excluir um voto com um ID inválido.
6. **Criação de Voto com Valor Inválido**: Testa a criação de um voto com um valor inválido.
7. **Verificação da Persistência de Votos**: Após a criação de um voto, verifica se ele persiste corretamente ao listar todos os votos.

## Execução dos Testes

Para executar os testes, siga estas etapas:

1. Clone o repositório do projeto para sua máquina local.
2. Certifique-se de que o Java e o Maven estão instalados em sua máquina.
3. Configure a chave de API como uma variável de ambiente chamada `THE_CAT_API_KEY`.
4. Abra o terminal na raiz do projeto.
5. Execute os testes com o seguinte comando Maven:

```shell
mvn clean test
```
Os resultados dos testes serão exibidos no terminal após a conclusão da execução.

## Melhorias para Conformidade RESTful
Para melhorar a conformidade com os padrões RESTful, as seguintes melhorias podem ser consideradas para a API:

1. Códigos de Status HTTP: Usar códigos de status mais específicos, como 201 Created para criações bem-sucedidas e 422 Unprocessable Entity para erros de validação.
2. Padrão de Respostas: Implementar um padrão consistente nas respostas da API para sucesso e erros.
