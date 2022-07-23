package webserver.Request;

import webserver.Header;

public class Request {

    private final RequestLine requestLine;
    private final Header headers;
    private final RequestParams params;

    private Request(RequestLine requestLine, Header headers, RequestParams params) {
        this.requestLine = requestLine;
        this.headers = headers;
        this.params = params;
    }

    public static Request get(RequestLine requestLine, Header headers) {
        return new Request(requestLine, headers, new RequestParams(requestLine.getUri().getQuery()));
    }

    public static Request post(RequestLine requestLine, Header headers, String requestBody) {
        return new Request(requestLine, headers, new RequestParams(requestBody));
    }

    public RequestLine getRequestLine() {
        return requestLine;
    }

    public Header getHeaders() {
        return headers;
    }

    public HttpMethod getHttpMethod() {
        return requestLine.getHttpMethod();
    }

    public String getUriPath() {
        return requestLine.getUri().getPath();
    }

    public String getProtocol() {
        return requestLine.getProtocol();
    }

    public boolean isResourceRequest() {
        return requestLine.getUri().isResourcePath();
    }

    public RequestParams getParams() {
        return params;
    }
}
