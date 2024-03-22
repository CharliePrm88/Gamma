# Gamma

## L'architettura prevede principalmente 3 microservizi:

- Un microservizio che prevede la gestione delle PEC. Chiaramente il sistema in questione sarà una versione estremamente semplificata del reale caso. Non è previsto quindi l'invio e la ricezione di PEC (Protocolli imap-Pop3 e SMTP) nè la firma con chiave privata dei messaggi. Questo microservizio ha il solo compito di recuperare gli account di ciascun utente che verrà carpito dal token oauth e i suoi relativi messaggi tramite filtri, come da requisito di sistema.
- un microservizio che riceverà in ingresso uno o più allegati da firmare: tale microservizio avrà il compito di recuperare quindi dal database la chiave privata dell'utente, decriptarla, firmare digitalmente il file e inviarlo quindi a
- un microservizio che riceverà il file firmato, lo cripterà e lo memorizzerà nel database.

La multitenancy verrà implementata tramite ruoli che verranno impostati nell'authorization server.

A supporto di tale architettura, sarà presente:
- Un server MySql per il database
- Un ELK stack per la gestione dei log;
- Un config server per la delivery delle configurazioni
- un server registry per allacciare i microservizi, verificarne lo stato di salute ed eventualmente la replicazione
- un server gateway per reindirizzare verso i microservizi le richieste di frontend
- un server apache kafka (TBD?)
- un authorization server (Spring Authorization server or keycloak? TBD)

## Stack tecnologico:

### Per i microservizi:
- Java 17.0.10
- Spring Boot 3.2.4
- Spring Security 6.2.3
- Spring Data 2023.1.4

### Elk Stack:
Verrà utilizzata la versione 7 perchè ritenuta più affidabile. Inoltre la versione 7 e la versione 8 avranno EOL (End of Life) concorrentemente al rilascio della versione 9 programmata per agosto 2024. [Fonte](https://www.elastic.co/support/eol)
- ElasticSearch 7.17.18
- Logstash 7.17.18
- Kibana 7.17.18

### Altro:
- MySql 8.0.36
- Keycloak 24.0.1
- Docker 24.0.4
- Docker Compose 2.24.7

## Diagrammi ER del database

![ER PEC](/docs/ER-Pec.jpg "ER PEC")


![ER STORE](/docs/ER-signed.jpg "ER STORE")