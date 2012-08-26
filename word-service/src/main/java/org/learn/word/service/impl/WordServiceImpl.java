/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.learn.word.service.impl;

import java.text.DecimalFormat;
import org.learn.word.service.WordService;
import org.springframework.stereotype.Component;

@Component
public class WordServiceImpl implements WordService {

    private static final String[] tensNames = {
        " ",
        " ten",
        " twenty",
        " thirty",
        " forty",
        " fifty",
        " sixty",
        " seventy",
        " eighty",
        " ninety"
    };
    private static final String[] numNames = {
        " ",
        " one",
        " two",
        " three",
        " four",
        " five",
        " six",
        " seven",
        " eight",
        " nine",
        " ten",
        " eleven",
        " twelve",
        " thirteen",
        " fourteen",
        " fifteen",
        " sixteen",
        " seventeen",
        " eighteen",
        " nineteen"
    };

    public String getWord(int number) {
        // 0 to 999 999 999
        if (number == 0) {
            return "zero";
        }
        // pad with "0"
        String mask = "000000000";
        DecimalFormat df = new DecimalFormat(mask);
        String snumber = df.format(number);
        // nnnXXXnnnnnn
        int millions = Integer.parseInt(snumber.substring(0, 3));
        // nnnXXXnnn
        int hundredThousands = Integer.parseInt(snumber.substring(3, 6));
        // nnnnnnXXX
        int thousands = Integer.parseInt(snumber.substring(6, 9));

        StringBuilder builder = new StringBuilder();
        builder.append(getMoreThanThousandValue(millions, "million"));
        builder.append(getMoreThanThousandValue(hundredThousands, "thousand"));
        String tradThousand = convertLessThanOneThousand(thousands);
        builder.append(tradThousand);

        // remove extra spaces
        return builder.toString().replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }

    private String getMoreThanThousandValue(int value, String unit) {
        String returnValue = null;
        switch (value) {
            case 0:
                returnValue = "";
                break;
            default:
                returnValue = convertLessThanOneThousand(value) + " " + unit;
        }
        return returnValue;
    }

    private String convertLessThanOneThousand(int number) {//999 to 0
        String soFar;
        int hundreds = 0;
        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            hundreds = number / 100;//will be always less than 10
        } else {
            soFar = numNames[number % 10];
            number = number / 10;
            soFar = tensNames[number % 10] + soFar;
            hundreds = number / 10;
        }
        if (hundreds == 0) {
            return soFar;
        }
        return numNames[hundreds] + " hundred" + (soFar.equals(" ") ? soFar : " and" + soFar);
    }
}
