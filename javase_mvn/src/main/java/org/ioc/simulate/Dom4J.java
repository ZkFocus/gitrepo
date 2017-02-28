package org.ioc.simulate;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;

/**
 * Created by ZhouKun on 2016/11/11.
 */
public class Dom4J {
    public Document parse(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }
    public Document parse(String xml) throws DocumentException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream ins = classLoader.getResourceAsStream(xml);
        SAXReader reader =new SAXReader();
        Document document=reader.read(ins);
        return document;
    }


    public static void main(String[] args) throws DocumentException {
        Dom4J dom4J=new Dom4J();
        Document document=dom4J.parse("config.xml");
        Element root = document.getRootElement();
        for(Iterator it=root.attributeIterator(); it.hasNext();){
            Attribute element=(Attribute) it.next();
            System.out.println(element.getName());
        }


    }
}
