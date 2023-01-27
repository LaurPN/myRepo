package test2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Worker extends Thread{
    private WebServer webServer;

    public Worker(WebServer webServer) {
        super();
        this.webServer = webServer;
    }

//    @Override
//    public void run() {
//        while (true) {
//            String req = webServer.removeReq();
//            File[] fileList = webServer.getFileList();
//            for (File file : fileList) {
//                if (file.getName().equals(req)) {
//                    webServer.addRes(file);
//                    try {
//                        sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                else {
//                    System.out.println("file not found, 404");
//                    break;
//                }
//            }
//            File res = webServer.removeRes();
//            Scanner scanner = null;
//            try {
//                scanner = new Scanner(res);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            while (true) {
//                assert scanner != null;
//                if (!scanner.hasNext()) break;
//                String st = scanner.nextLine();
//                System.out.println(st);
//            }
//        }
//    }


    @Override
    public void run() {
        while (true) {
            String req = webServer.removeReq();
            File[] fileList = webServer.getFileList();
            for (File file : fileList) {
                if (file.getName().equals(req)) {
                    Scanner scanner = null;
                    try {scanner = new Scanner(file);}
                    catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    while (true) {
                        assert scanner != null;
                        if (!scanner.hasNext()) break;
                        String st = scanner.nextLine();
                        System.out.println(st);
                    }
                }
                else {
                    System.out.println("file not found, 404");
                }
                break;
            }
        }
    }
}
