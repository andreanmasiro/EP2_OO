O projeto foi desenvolvido usando a IDE Eclipse.

Para rodar o projeto basta complilá-lo utilizando o Eclipse e a janela principal será aberta, e será atualizada conforme os dados forem obtidos.

A classe MainViewController cuida de todas as views e da comunicação das mesmas com as classes de model. Ela contém um JTextField, que serve para fazer busca nas tabelas de deputados e partidos. Contém, também um JTabbedPane, que contém abas que mostram diferentes JTables com os dados dos Deputados e Partidos, respectivamente.

A classe CamaraModel é responsável por obter todos os dados do servidor, e segue o padrão Singleton, para que a aplicação sempre busque os dados do mesmo lugar e para que não haja redundância de busca de dados.

A classe DeputadosTableModel é uma implementação da interface TableModel, que serve de base de dados para uma JTable. Ela recupera os dados da CamaraModel e retorna para a JTable inicializada na MainViewController.

A classe PartidosTableModel, assim como DeputadosTableModel, é uma implementação da interface TableModel, e serve com o mesmo propósito(com uma JTable diferente).