package org.example.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a href="https://docs.google.com/presentation/d/1DhgnnylRBVHiYEXfMCTgwxrSmskiS5YInSvREJ50Bqk/edit#slide=id.g2fa66782240_0_0">Google docs reference</a>
 */
public class ExtractRegex {
    public static void extractRegex() {
        String text = "IntrvlMnthDay:01:05";
        Boolean t = text.matches("^((IntrvlMnthDay:(0[1-6]|12|24)):(-0[1-5]|0[1-9]|[12][0-9]|3[01]))$");
        String[] s = text.split("^((IntrvlMnthDay:(0[1-6]|12|24)):(-0[1-5]|0[1-9]|[12][0-9]|3[01]))$");
        for (String r : s) {
            System.out.println(r);
        }

        Pattern pattern = Pattern.compile("^((IntrvlMnthDay:(0[1-6]|12|24)):(-0[1-5]|0[1-9]|[12][0-9]|3[01]))$");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()){
            System.out.println(matcher.group(2));
        }
    }
}
