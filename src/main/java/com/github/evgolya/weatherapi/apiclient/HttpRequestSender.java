package com.github.evgolya.weatherapi.apiclient;

import com.github.evgolya.weatherapi.apiclient.urlbuilder.UrlBuilder;
import com.github.evgolya.weatherapi.apiclient.urlbuilder.UrlParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class HttpRequestSender {

    private static final Logger logger = LoggerFactory.getLogger(HttpRequestSender.class);
    private final HttpClient httpClient;

    public HttpRequestSender() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public HttpResponse<String> send(String apiMethod, UrlParameter... parameters) {
        final UrlBuilder urlBuilder = new UrlBuilder(apiMethod);
        for (UrlParameter parameter : parameters) {
            urlBuilder.addParameter(parameter);
        }
        return sendHttpRequest(urlBuilder.buildUrl());
    }

    private HttpResponse<String> sendHttpRequest(String url) {
        try {
            final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            logger.error("Cannot send the next request: {}", url);
            throw new HttpRequestException("Cannot send http request", e);
        }
    }

    private static final class HttpRequestException extends RuntimeException {

        public HttpRequestException(String message, Exception exception) {
            super(message, exception);
        }
    }
}
