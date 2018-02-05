package com.breno.test.undertow;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.RoutingHandler;

import com.breno.test.undertow.request.handler.EmailAllRequestHandler;
import com.breno.test.undertow.request.handler.EmailPathParamsRequestHandler;
import com.breno.test.undertow.request.handler.EmailRequestHandler;
import com.breno.test.undertow.request.handler.ExceptionTestRequestHandler;

public class App {

	public static void main(String[] args) {
		int port = Integer.parseInt(System.getProperty("server.port", "8089"));

		final HttpHandler httpRoutes = new RoutingHandler()
				.get("/emailByType", new EmailRequestHandler())
				.get("/email", new EmailAllRequestHandler())
				.get("/email/{type}", new EmailPathParamsRequestHandler())
				.get("/exception", new ExceptionTestRequestHandler());

		final HttpHandler root = Handlers.exceptionHandler(httpRoutes)
				.addExceptionHandler(IllegalArgumentException.class, exchange -> exchange.setStatusCode(410));
		
		Undertow server = Undertow
				.builder()
				.addHttpListener(port, "0.0.0.0")
				.setHandler(root)
				.setWorkerThreads(20).build();
		server.start();
	}

}
