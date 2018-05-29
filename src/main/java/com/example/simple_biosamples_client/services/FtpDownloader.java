package com.example.simple_biosamples_client.services;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.*;


public class FtpDownloader {

    private String host;


    public FtpDownloader(String host) {
        this.host = host;

    }

    public void download(String filePath, String serverPath, String login, String password) {
        Mono.just(host + serverPath)
                .log()
                .subscribeOn(Schedulers.parallel())
                .map(i -> {
                    try {
                        String[] ftpServerPaths = i.split("/", 2);
                        File target = new File(filePath);
                        boolean fileCreated = target.createNewFile();
                        if (!fileCreated) {
                            return "File creation failed. Download canceled!";
                        }
                        FTPClient client = new FTPClient();
                        client.connect(ftpServerPaths[0]);
                        client.login(login, "password"); // log and pass just for this example impl
                        System.out.println(client.getReplyString());
                        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(target));
                        client.enterLocalPassiveMode();
                        client.setFileType(FTP.ASCII_FILE_TYPE);
                        client.retrieveFile(ftpServerPaths[1], outputStream);
                        outputStream.close();
                        client.disconnect();
                        return i;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .subscribe();
    }
}
