package test2;

public class Client extends Thread{
    private WebServer webServer;
    private String request;

    public Client(WebServer webServer, String request) {
        super();
        this.webServer = webServer;
        this.request = request;
    }

    @Override
    public void run() {
        webServer.addReq(this.request);
    }
}
