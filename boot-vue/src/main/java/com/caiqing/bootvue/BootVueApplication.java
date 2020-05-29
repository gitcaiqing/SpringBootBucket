package com.caiqing.bootvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

@SpringBootApplication
public class BootVueApplication {

    public static void main(String[] args) {
        // 为了让SpringBoot支持jsp，在jar包环境下需要把jsp解压到src/main/webapp/目录下
        boolean override = "true".equals(System.getProperty("cleanOnstart", "true"));
        Class<?> bootClass = BootVueApplication.class;// main()方法所在的类
        copyResourceIfInJar(bootClass, "META-INF/resources", "src/main/webapp", override);
        SpringApplication.run(bootClass, args);
    }

    private static void copyResourceIfInJar(Class<?> clazz, String resPreffix, String targetDir, boolean override) {
        String cls = clazz.getSimpleName() + ".class";
        URL url = clazz.getResource(cls);
        if (url == null) {
            System.err.println("不可思议的可能.");
            return;
        }
        if ("file".equals(url.getProtocol())) {
            // 本地开发环境，忽略
            System.out.println("ignore when local dev.");
            return;
        }
        File webRootFile = new File(targetDir);
        if (webRootFile.exists()) {
            File oldFolder;
            if (!webRootFile.isDirectory()) {
                webRootFile.delete();
                webRootFile.mkdir();
            } else if (override && webRootFile.renameTo(oldFolder = new File(targetDir + "-" + UUID.randomUUID()))) {
                webRootFile.mkdirs();
                oldFolder.deleteOnExit();
            } else if (!override) {
                System.out.println("lazy return when not override.");
                return;
            }
        } else {
            webRootFile.mkdirs();
        }
        // 目录准备完毕，开始解压和复制
        PathMatchingResourcePatternResolver searcher = new PathMatchingResourcePatternResolver(clazz.getClassLoader());
        try {
            Resource[] webResources = searcher.getResources(resPreffix + (resPreffix.endsWith("/") ? "**" : "/**"));
            if (webResources != null && webResources.length > 0) {
                for (Resource resource : webResources) {
                    String desc = resource.getDescription();
                    String uri = desc.substring(desc.indexOf(resPreffix) + resPreffix.length(), desc.lastIndexOf(']'));
                    File tar = new File(targetDir, uri);
                    if (uri.endsWith("/")) {
                        tar.mkdirs();
                        continue;
                    }
                    if (!tar.getParentFile().exists()) {
                        tar.getParentFile().mkdirs();
                    }
                    FileCopyUtils.copy(resource.getInputStream(), new FileOutputStream(tar));
                }
            } else {
                System.err.println("Resource Not Found in path:" + resPreffix);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
