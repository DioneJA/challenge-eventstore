/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeImp;

/**
 *
 * @author bruno
 */
public class EventException extends RuntimeException{
	//An exception that extends the RuntimeException to not force program termination, and to be more standardized
	private static final long serialVersionUID = 1L;

    public EventException(String string) {
    	super(string);
    }
}
