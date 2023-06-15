package org.example;

public  class InputValidation {

    public static String menuValidation(String input, int menuCode){

        switch (menuCode){
            case 1:
                try{
                    int stringToInt = Integer.parseInt(input);
                    if(stringToInt > 3 || stringToInt <= 0){
                        return "";
                    }
                    return input;
                }
                catch (Exception e){
                    return "";
                }

        }


        return "";
    }
}
