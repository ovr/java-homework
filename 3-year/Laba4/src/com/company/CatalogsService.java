package com.company;

import jdk.internal.org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by ovr on 04.12.14.
 */
public class CatalogsService {
    protected ArrayList<Catalog> catalogs = new ArrayList<>();

    private StreamResult out;
    private AttributesImpl atts;
    private TransformerHandler th;

    public void initCatalogsFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader in = new BufferedReader(new FileReader(file));

        String path;
        while((path = in.readLine()) != null) {
            Catalog catalog = new Catalog(path);
            this.catalogs.add(catalog);

            System.out.println("Path: " + path);
        }

        in.close();
    }


    public void writeToXml() throws TransformerException, org.xml.sax.SAXException, SAXException, ParserConfigurationException {
        out = new StreamResult("dir.xml");

        initXML();

        for (Catalog catalog : this.catalogs) {
            process(catalog);
        }

        closeXML();
    }

    public void initXML() throws ParserConfigurationException, TransformerConfigurationException, SAXException, org.xml.sax.SAXException, TransformerException {

        // JAXP + SAX
        SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();

        th = tf.newTransformerHandler();

        Transformer serializer = TransformerFactory.newInstance().newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");

        th.setResult(out);
        th.startDocument();
        atts = new AttributesImpl();
    }

    public void process(Catalog catalog) throws SAXException, org.xml.sax.SAXException {
        atts.clear();

        File[] elements = catalog.listFiles();

        atts.addAttribute("", "", "path", "", catalog.getPath());
        th.startElement("", "", "catalog", atts);

        for (File tmp : elements) {
            System.out.println("File path " + tmp.getAbsolutePath());

            atts.addAttribute("", "", "path", "", tmp.getPath());
            th.startElement("", "", "file", atts);
            th.endElement("", "", "file");
        }

        th.endElement("", "", "catalog");
    }

    public void closeXML() throws SAXException, org.xml.sax.SAXException {
        th.endDocument();
    }

    public void clear()
    {
        this.catalogs = new ArrayList<>();
    }
}
