/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTException;

/**
 *
 * @author LouiseB
 */
public class FlightException extends Exception
{

    public FlightException()
    {
    }

    public FlightException(String msg)
    {
        super(msg);
    }
}
