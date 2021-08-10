## Forecast APIs and additional info:

##### FORECA - with API usage monitoring, no info about pricing:```https://developer.foreca.com/```

##### WEATHER API (using) - info about pricing is present (more cheap), free - 1,000,000 Calls per month:```https://www.weatherapi.com/```

##### WEATHER STACK API - info about pricing is present, free - 250 Calls / mo: ```https://weatherstack.com/```

##### OPEN WEATHER MAP API - info about pricing is present (more expensive), free - 1,000,000 Calls / month: ```https://openweathermap.org/api```

##### VISUAL CROSSING WEATHER: ```https://www.visualcrossing.com/resources/documentation/weather-api/timeline-weather-api/```

##### Top 8 Best Weather APIs for 2021: ```https://rapidapi.com/blog/access-global-weather-data-with-these-weather-apis/```

##### Search lat, lon by city

```https://positionstack.com/documentation```
```https://developer.here.com/blog/how-to-use-geocoding-in-java-with-the-here-geocoding-search-api```

##### Search city by lat, lon

```https://www.bigdatacloud.com/geocoding-apis/free-reverse-geocode-to-city-api```

##### Get data about user by user IP

```https://ipstack.com/documentation```

## Setup Vault
Run vault for development: ```dev/vault/docker-compose.yml```
Then go to container bash 

```docker exec -it dvault sh```

and run follow commands

- ```vault login root```

- ```vault kv put secret/w-api-vault-config weather-api.key={api_key}``` (set your entry with key:value)

And then, configure Vault for Spring Boot. Enjoy :)
You can use Vault UI for clarity (see port mapping in the docker-compose.yml)

From more details see guides and Vault docs:
```https://spring.io/guides/gs/vault-config/```

```https://github.com/spring-guides/gs-vault-config```

```https://hub.docker.com/_/vault```

```https://www.vaultproject.io/docs```