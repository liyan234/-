package HTTPV3;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

//回应
public class HttpResponse {

    //首行  版本号 状态码  描述信息
    //header “: 和=”
    //空行
    //body “&和=”

    private String version = "HTTP/1.1";
    private int status;//就是 404 200 303 之类的,状态码的描述信息
    private String message;// 状态码的描述信息
    private Map<String, String> headers = new HashMap<>();
    private StringBuilder body = new StringBuilder();//方便body中信息的拼接
    private OutputStream outputStream = null;

    public static HttpResponse build(OutputStream outputStream) {
        HttpResponse response = new HttpResponse();
        response.outputStream = outputStream;

        return response;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeader(String key, String value) {
        this.headers.put(key, value);
    }

    public void setBody(String content) {
        this.body.append(content);//这就是将body写出StringBuilder的原因
    }

    public void flush() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(version + " " + status + " " + message + "\n");
        headers.put("Content-Length", body.toString().getBytes().length + " ");
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            bufferedWriter.write(entry.getKey() + ": " + entry.getValue());
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString());
        bufferedWriter.flush();//将缓冲区中的信息刷新到内存中
    }

}
