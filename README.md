# **TODO List APP**

## **Sobre o Projeto**

Este é um aplicativo simples de TODO List desenvolvido em Java puro, sem o uso de frameworks. Ele permite que os usuários gerenciem tarefas de forma eficiente por meio de uma interface de linha de comando. O sistema suporta a criação, listagem, remoção de tarefas e persiste os dados em um arquivo JSON.

### **Funcionalidades**

- Adicionar tarefas com nome, descrição, data de término, nível de prioridade, categoria e status.
- Listar tarefas por categoria, prioridade ou status.
- Remover tarefas.
- Manter a ordenação das tarefas com base na prioridade.
- Persistência automática das tarefas em um arquivo JSON.
- Menu interativo com opções de navegação.
- Filtragem de tarefas por data de término.
- Consulta do número de tarefas por status (ToDo, Doing, Done).
- Atualização de tarefas existentes.

### **Como Executar**

Clone o repositório:

```sh
git clone https://github.com/seu-usuario/TodoListApp.git
cd TodoListApp
```

#### **Executando o Backend**

Compile e execute o projeto:

```sh
javac -d out src/**/*.java
java -cp out ui.TodoListApp
```

### **Executando o Frontend**

#### **Opção 1: Usando Live Server (Recomendado)**
Se ainda não tiver o `live-server` instalado, instale com:

```sh
npm install -g live-server ou npx live-server
```

Depois, dentro da pasta `front-end`, execute:

```sh
live-server
```

Isso abrirá automaticamente o navegador no `index.html`.

#### **Opção 2: Abrindo Manualmente no Navegador**
Caso prefira, basta abrir o arquivo `front-end/index.html` diretamente no seu navegador.

### **Configuração da Persistência JSON**

Certifique-se de que o arquivo `tarefas.json` existe na raiz do projeto.
Se o arquivo não existir, o aplicativo irá criá-lo automaticamente.

---

**Autor: Jenyffer Sacramento**
