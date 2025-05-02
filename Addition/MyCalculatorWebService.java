/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Shruti
 */
@WebService(serviceName = "MyCalculatorWebService")
public class MyCalculatorWebService {

    /**
     * This is a sample web service operation
     */
   

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Addition")
    public double Addition(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        //TODO write your implementation code here:
        return num1 + num2;
    }
}
