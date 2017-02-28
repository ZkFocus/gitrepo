package com.xml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ZhouKun on 2016/11/15.
 */
public class Test {
    public static void main(String[] args) {
        User user = new User(1, "Steven", "@sun123", new Date(), 1000.0);
        List<Computer> list = new ArrayList<Computer>();
        list.add(new Computer("xxxMMeedd", "asus", new Date(), 4455.5));
        list.add(new Computer("lenvoXx", "lenvo", new Date(), 4999));
        user.setComputers(list);
        String path = "D:\\user.xml";
        XMLUtil.convertToXml(user, path);

        System.out.println();
        User user2 = (User) XMLUtil.convertXmlFileToObject(User.class, path);
        System.out.println(user2);





    }
}
