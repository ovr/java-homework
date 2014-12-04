package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, jdk.internal.org.xml.sax.SAXException, TransformerException {
        CatalogsService service = new CatalogsService();
        service.initCatalogsFromFile(System.getProperty("user.dir") + "/path.txt");
        service.writeToXml();
    }
}
