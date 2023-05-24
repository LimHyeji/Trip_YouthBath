package com.ssafy.enjoytrip.filter.xss;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.Map;

public class XSSFilterWrapper extends HttpServletRequestWrapper {
    private byte[] rawData;

    public XSSFilterWrapper(HttpServletRequest request) {
        super(request);
        try{
            if("post".equalsIgnoreCase(request.getMethod())
                    && ("application/json;charset=utf-8".equalsIgnoreCase(request.getContentType())
                    || "multipart/form-data".equalsIgnoreCase(request.getContentType()))){
                InputStream is = request.getInputStream();
                ByteArrayOutputStream bao = new ByteArrayOutputStream();

                for(int data = is.read();data!=-1;data = is.read()){
                    bao.write(data);
                }
                String data = bao.toString();
                this.rawData = xssFiltering(data).getBytes();
            }
            else{
                System.out.println("else");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private String xssFiltering(String strData){
        if(strData!=null) {
            strData = strData.replaceAll("\\<", "&lt;").replaceAll("\\>", "&gt;").replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        }
        return strData;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if(this.rawData==null){
            return super.getInputStream();
        }
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.rawData);

        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {

            }

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }

    @Override
    public String getQueryString() {
        return xssFiltering(super.getQueryString());
    }

    @Override
    public String getParameter(String name) {
        return xssFiltering(super.getParameter(name));
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> params = super.getParameterMap();
        if(params!=null){
            params.forEach((key,value)->{
                for(int i=0;i<value.length;i++){
                    value[i] = xssFiltering(value[i]);
                }
            });
        }
        return params;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] params = super.getParameterValues(name);
        if(params!=null){
            for(int i=0;i<params.length;i++){
                params[i]=xssFiltering(params[i]);
            }
        }
        return params;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream(),"UTF_8"));
    }
}