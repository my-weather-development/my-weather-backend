## Forecast APIs and additional info:

##### FORECA - with API usage monitoring, no info about pricing:```https://developer.foreca.com/```

##### WEATHER API (using) - info about pricing is present (more cheap), free - 1,000,000 Calls per month:```https://www.weatherapi.com/```

##### WEATHER STACK API - info about pricing is present, free - 250 Calls / mo: ```https://weatherstack.com/```

##### OPEN WEATHER MAP API - info about pricing is present (more expensive), free - 1,000,000 Calls / month: ```https://openweathermap.org/api```

##### VISUAL CROSSING WEATHER: ```https://www.visualcrossing.com/resources/documentation/weather-api/timeline-weather-api/```

##### Top 8 Best Weather APIs for 2021: ```https://rapidapi.com/blog/access-global-weather-data-with-these-weather-apis/```

##### Search lat, lon by city

```https://positionstack.com/documentation```
```https://developer.here.com/blog/how-to-use-geocoding-in-java-with-the-here-geocoding-search-api``` (using)

##### Search city by lat, lon

```https://www.bigdatacloud.com/geocoding-apis/free-reverse-geocode-to-city-api```

##### Get data about user by user IP

```https://ipstack.com/documentation```

##### Country codes

```https://countrycode.org/```

## Setup Vault
Run vault for development: ```dev/vault/docker-compose.yml```
Then go to container bash 

```docker exec -it dvault sh```

and run follow commands

- ```vault login root```

- ```vault kv put secret/w-api-vault-config weather-api.key={api_key}``` (set your entry with key:value)

And then, configure Vault for Spring Boot. Enjoy :)
You can use Vault UI for clarity (see port mapping in the docker-compose.yml)

For more details see guides and Vault docs:

```https://spring.io/guides/gs/vault-config/```

```https://github.com/spring-guides/gs-vault-config```

```https://hub.docker.com/_/vault```

```https://www.vaultproject.io/docs```

```https://cloud.spring.io/spring-cloud-vault/reference/html/#_quick_start```

## Spring with dockerized Vault in PROD mode:

- Write docker-compose file for starting Vault (you can use our dc file as example or use ```https://hub.docker.com/_/vault```)
- Start dc with ```docker-compose up```
- Go to sh with ```docker exec -it mw_vault sh```. Vault is seal by default, see the next steps
- Run ```vault operator init``` (For details read the next docs: ```https://cloud.spring.io/spring-cloud-vault/reference/html/#_quick_start```)
- Then you got 5 unseal keys & INITIAL ROOT TOKEN (use for your app or generate the new!)
- Take 3 unseal keys and make the same for each key ```vault operator unseal ${ONE_OF_5_KEYS}``` (it's security, babe :D)
- Then ```vault login```. Use INITIAL ROOT TOKEN when Vault asks you for a token 
- Okay, let's write our keys. See Vault secrets list ```vault secrets list -detailed```
- Create kv if you need it ```vault secrets enable -path=secret kv``` (For details see: ```https://learn.hashicorp.com/tutorials/vault/getting-started-secrets-engines```)
- Write your keys ```vault kv put secret/${VAULT_CONFIG_NAME} ${YOUR_API_OR_SMTH_ELSE_NAME}.${KEY_NAME}=${KEY_VALUE}```

##### What about Spring: use bootstrap.properties/yaml
```spring.application.name=${VAULT_CONFIG_NAME}```

```spring.cloud.vault.token={VAULT_TOKEN} (it can be an INITIAL ROOT TOKEN)```

```spring.cloud.vault.scheme=http (it can be https. For more details see: https://cloud.spring.io/spring-cloud-vault/reference/html/#_quick_start)```

```spring.cloud.vault.kv.enabled=true```

##### Note that ```VAULT_DEV_ROOT_TOKEN_ID``` (in docker-compose) is REDUNDANT for PROD mode and will be ignored by Vault during starting.

##### Additional different info:

- ###### Package org.hibernate.dialect

```https://docs.jboss.org/hibernate/orm/current/javadocs/org/hibernate/dialect/package-summary.html```

- ###### Initialize a Database Using Hibernate

```https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.data-initialization```

- ###### Ping IPv6

```http://www.ipv6now.com.au/pingme.php```

- ###### UK, RU, BY (regions)

```https://maps.vlasenko.net/list/ukraine/cherkaska/```
