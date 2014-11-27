package com.finalist.util.log;

/**
 * A class to get an instance for a logger object.
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.1 $, $Date: 2005/10/13 21:17:51 $
 */
public final class LogService {
   
   /**
    * Get an instance of a logger object.
    * @param cls the Class to log from
    * @return Logger the logger instance
    */
   public static Logger getLogger(Class cls) {
      return new JDKLogger(cls);
   }
}
