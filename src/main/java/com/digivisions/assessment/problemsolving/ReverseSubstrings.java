package com.digivisions.assessment.problemsolving;

import java.util.Stack;

import static com.digivisions.assessment.utils.Constants.CLOSED_BRACKET;
import static com.digivisions.assessment.utils.Constants.OPENED_BRACKET;
import static com.digivisions.assessment.utils.StringUtils.isBlank;
import static com.digivisions.assessment.utils.StringUtils.reverseString;

public class ReverseSubstrings {

    public String doReverseSubstrings(String text) {

        if (isBlank(text)) return text;

        StringBuilder reversedString = new StringBuilder();
        StringBuilder tempSubstring = new StringBuilder();
        Stack<Character> brackets = new Stack<>();


        for (char item : text.toCharArray()) {

            if (item == OPENED_BRACKET) {
                brackets.push(item);
                reversedString.append(item);
                continue;

            } else if (item == CLOSED_BRACKET) {
                brackets.pop();
                reversedString.append(reverseString(tempSubstring.toString()));
                reversedString.append(item);

                tempSubstring.setLength(0);

            } else {
                if (brackets.contains(OPENED_BRACKET)) {
                    tempSubstring.append(item);
                } else {
                    reversedString.append(item);
                }
            }
        }

        return reversedString.toString();
    }
}
