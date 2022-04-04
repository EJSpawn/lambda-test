package br.com.asgardproject;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcessingService {

    public static final String CAN_ONLY_GREET_NICKNAMES = "Can only greet nicknames";

    public OutputObject process(InputObject input) {
        OutputObject out = new OutputObject();
        try {
            if (input.getName().equals("Stuart")) {
                throw new IllegalArgumentException(CAN_ONLY_GREET_NICKNAMES);
            }
            String result = input.getGreeting() + " " + input.getName();            
            out.setResult(result);
            return out;   
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(input == null){
            out.setResult("Input is equals null.");
        } else {
            out.setResult("Process no executed to input: " + input.toString());
        }
        
        return out;
    }
}
