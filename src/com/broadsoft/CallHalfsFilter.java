package com.broadsoft;

import java.io.*;
import java.util.regex.*;
import java.util.*;

public class CallHalfsFilter {

    public static void main(String[] args) throws IOException{

        Set<String> callHalfs = new HashSet<>();
        for ( int i = 0; i < args.length; i++) {
            callHalfs.add( args[i] );
        }

        String CALL_HALF_REGEX = "\\| callhalf-(\\d+)";
        Pattern pattern = Pattern.compile(CALL_HALF_REGEX);

        boolean filter = true;

        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in) );

        String line;
        while ( (line = reader.readLine()) != null ) {
            Matcher matcher = pattern.matcher(line);
            if ( matcher.find() ) {
                String callHalf = matcher.group(1);
                filter = callHalfs.contains( callHalf ) ? false : true;
            }

            if ( filter ) {
                continue;
            } else {
                System.out.println( line );
            }
        }
    }
}
