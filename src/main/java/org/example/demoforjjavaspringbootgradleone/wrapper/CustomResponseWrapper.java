package org.example.demoforjjavaspringbootgradleone.wrapper;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CustomResponseWrapper extends HttpServletResponseWrapper {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintWriter writer = new PrintWriter(outputStream);

    public CustomResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return writer;
    }

    public String getCaptureResponse() throws UnsupportedEncodingException {
        writer.flush();
        return outputStream.toString("UTF-8");

    }

    public void writeModifiedResponse(String modifResponse) throws IOException {
        getResponse().getWriter().write(modifResponse);
    }
}
