package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.FileHandler;

/**
 * Created by ovr on 04.12.14.
 */
public class Catalog {
    public String path;

    Catalog (String path1) {
        this.path = path1;
    }

    public File[] listFiles()
    {
        ArrayList<String> files = new ArrayList<>();

        File file = new File(this.path);
        return file.listFiles();
    }

    public String getPath() {
        return path;
    }
}
