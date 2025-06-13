package org.lcr;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Solution122 {
    public String pathEncryption(String path) {
        String[] split = path.split("");
        StringJoiner stringJoiner = new StringJoiner("");
        for (int i = 0; i < split.length; i++) {
            if (Objects.equals(split[i], ".")) {
                split[i] = " ";
            }
            stringJoiner.add(split[i]);
        }
        return stringJoiner.toString();
    }

    public String v2(String path){
        return  path.replaceAll("\\."," ");
    }
}
