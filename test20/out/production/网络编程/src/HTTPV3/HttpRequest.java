package HTTPV3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//请求
public class HttpRequest {

    //首行  方法 url(“&和=”)  版本号
    //header “: 和=”
    //空行
    //body （“&和=”）

    private String method;
    private String url;//url解析后放入parameters
    private String version;
    //headers是一个个键值对
    private Map<String, String> headers = new HashMap<>();
    //url 和 body 中的参数都放到这个中
    private Map<String, String> parameters = new HashMap<>();
    private Map<String, String> cookies = new HashMap<>();
    private String body;//body解析后放入parameters中

    public static HttpRequest build(InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        //1.处理首行
        String fistLine = bufferedReader.readLine();
        //这个首行 方法 url 以及version（版本号）都是由" "分隔开
        String[] fistLineTokens = fistLine.split(" ");
        request.method = fistLineTokens[0];
        request.url = fistLineTokens[1];
        request.version = fistLineTokens[2];
        //然后我们需要解析url 我们知道有时候有些信息是放在url中的
        //并且若是有"?"就表示是有这些信息的
        //并且后面的信息是以键值对的形式存在的
        int pos = request.url.indexOf("?");//若是不存在则返回-1；
        if (pos != -1) {
            // =-1的话就没有这些信息，就不用解析了
            String str = request.url.substring(pos + 1);
            parseKV(str, request.parameters);//解析这些信息，并存放入parameters
        }

        //首行解析完，我们需要解析headers
        //循环处理headers
        //header的结束标志是一个空行，可以用while中处理
        String line = "";
        while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
            String[] headersTokens = line.split(": ");//headers是键值对 用": "拆开
            //然后将这个键值对放入headers这个map中
            request.headers.put(headersTokens[0], headersTokens[1]);
        }
        //解析cookie cookie是header中特殊的头部，我们来特殊解析
        String cookie = request.headers.get("Cookie");
        if (cookie != null) {
            parseCookie(cookie, request.cookies);
        }

        //解析 body
        //用不区分大小写的比较
        if ( "POST".equalsIgnoreCase(request.method) ||
             "PUT".equalsIgnoreCase(request.method) ) {
            //我们需要解析body的长度，以字节为单位,并且body的长度是存在于header中的
            int contentLength = Integer.parseInt(request.headers.get("Content-Length"));
            //但是我们创建缓冲区是以char为单位，我们不需要纠结
            //缓冲区的大小 大于body的长度是可以，但是不能小于
            char[] buffer = new char[contentLength];
            int len = bufferedReader.read(buffer);
            request.body = new String(buffer, 0, len);
            //我们知道body的解析其实和url中信息解析式一样
            //都是由“&”拆开键值对。“=”拆开键和值
            //也将其解析到parameters中
            parseKV(request.body, request.parameters);
        }

        //这就逐步解析完了
        return request;
    }

    private static void parseCookie(String cookie, Map<String, String> cookies) {
        //"; "拆开cookie信息组
        String[] cookieTokens = cookie.split("; ");
        for (String kv : cookieTokens) {
            String[] ret = kv.split("=");
            cookies.put(ret[0], ret[1]);
        }
    }

    private static void parseKV(String str, Map<String, String> parameters) {
        // "&"拆开信息组
        String[] kvTokens = str.split("&");
        // "="拆开键和值
        for (String kv : kvTokens) {
            String[] ret = kv.split("=");
            parameters.put(ret[0], ret[1]);
        }

    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public String getBody() {
        return body;
    }

    public String getHeader(String key) {
        return headers.get(key);
    }

    public String getParameter(String key) {
        return parameters.get(key);
    }

    public String getCookie(String key) {
        return cookies.get(key);
    }
}
