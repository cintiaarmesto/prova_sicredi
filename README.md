# prova_sicredi 
Instruções:
Projeto criado em Java com Maven para gerenciar Dependências (Selenium e TesteNG), assim se faz necessario o uso do maven para uma melhor utilização do Projeto.
Basta instalar o pacote, baixar o projeto e digitar: # mvn clean install, isso fará com que as dependencias sejam baixadas.  
Para executar os testes é necessário ajustar o path do chrome drive de acordo com o path do seu driver.
# considerações
Há uma mensagem de sucesso que está especificada de uma forma na documentação, e o que a pagina informa é outra.
Os testes foram escritos com a mensagem informada na pagina, pois se fosse usar a mensagem da documentação os testes falhariam.  
Mensagem esperada: "Your data has been successfully stored into the database."  
Mensagem encontrada: "Your data has been successfully stored into the database. Edit Customer or Go back to list"
