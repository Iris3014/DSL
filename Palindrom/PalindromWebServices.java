/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Shruti
 */
@WebService(serviceName = "PalindromWebServices")
public class PalindromWebServices {

    /**
     * This is a sample web service operation
     */
      

    /**
     * Web service operation
     */
     @WebMethod(operationName = "checkPalindrome")
    public String checkPalindrome(@WebParam(name = "input") String input) {
        if (input == null || input.isEmpty()) {
            return "Invalid Input";
        }

        String reversed = new StringBuilder(input).reverse().toString();
        if (input.equals(reversed)) {
            return "Palindrome";
        } else {
            return "Not a Palindrome";
        }
    }
}
                        

