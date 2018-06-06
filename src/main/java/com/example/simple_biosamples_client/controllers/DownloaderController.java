package com.example.simple_biosamples_client.controllers;

import com.example.simple_biosamples_client.ga4gh_services.FtpDownloader;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@EnableAutoConfiguration
public class DownloaderController {

    @RequestMapping("/download")
    String downloadFile() throws IOException {
        FtpDownloader downloader = new FtpDownloader("test.rebex.net");
        downloader.download("readme.txt", "/pub/example/readme.txt", "demo", "password");
        return "File will be downloaded";
    }

}
