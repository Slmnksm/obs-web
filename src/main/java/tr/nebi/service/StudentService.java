/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.nebi.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author S.KasımYurtaslan
 */
@WebService(name = "studentService")
public class StudentService {

    @WebMethod
    public String hello(String text) {
        return "Merhaba " + text;
    }

}
