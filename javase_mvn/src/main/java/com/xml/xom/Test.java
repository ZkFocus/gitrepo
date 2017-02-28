package com.xml.xom;

import nu.xom.*;

import java.math.BigInteger;

/**
 * Created by ZhouKun on 2016/11/15.
 */
public class Test {
    public static void main(String[] args) {
        BigInteger high=new BigInteger("1");
        BigInteger low=new BigInteger("1");
        Element root=new Element("Fibonacci_Numbers");

        for(int i=1;i<11;i++){
            Element element=new Element("fibonacci");
            element.appendChild(low.toString());
            Attribute attribute=new Attribute("index",String.valueOf(i));
            element.addAttribute(attribute);
            BigInteger temp = high;
            high = high.add(low);
            low = temp;
            root.appendChild(element);
        }
        Document document=new Document(root);
        DocType doctype = new DocType("Fibonacci_Numbers", "fibonacci.dtd");
        document.insertChild(doctype, 0);
//        System.out.println(document.toXML());
        try {
            Serializer serializer=new Serializer(System.out,"UTF-8");
            serializer.setIndent(1);
            serializer.setMaxLength(60);
            serializer.write(document);
        }catch (Exception e){

        }
    }
}
