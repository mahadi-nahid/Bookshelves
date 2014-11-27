/*   Copyright (C) 2003 Finalist IT Group
 *
 *   This file is part of JAG - the Java J2EE Application Generator
 *
 *   JAG is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *   JAG is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *   You should have received a copy of the GNU General Public License
 *   along with JAG; if not, write to the Free Software
 *   Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.finalist.util.log;

/**
 * Interface for the logger object, for logging messages to a logfile
 * @author Ronald Kramp - Finalist IT Group
 * @version $Revision: 1.1 $, $Date: 2005/10/13 21:17:51 $
 */
public interface Logger {

   /**
    * Logging a finest message
    * @param message the message to log
    */
   void finest(String message);

   /**
    * Logging a finer message
    * @param message the message to log
    */
   void finer(String message);

   /**
    * Logging a fine message
    * @param message the message to log
    */
   void fine(String message);

   /**
    * Logging a config message
    * @param message the message to log
    */
   void config(String message);

   /**
    * Logging an info message
    * @param message the message to log
    */
   void info(String message);


   /**
    * Logging a warning message
    * @param message the message to log
    */
   void warning(String message);

   /**
    * Logging a severe message
    * @param message the message to log
    */
   void severe(String message);

   //****************************************************
   //*  The methods from log4j also implemented below   *
   //****************************************************

   /**
    * Logging a debug message
    * @param message the message to log
    */
   void debug(String message);

   /**
    * Logging a debug message with the throwable message
    * @param message the message to log
    * @param t the exception
    */
   void debug(String message, Throwable t);

   /**
    * Logging an info message with the throwable message
    * @param message the message to log
    * @param t the exception
    */
   void info(String message, Throwable t);

   /**
    * Logging a warning message
    * @param message the message to log
    */
   void warn(String message);

   /**
    * Logging a warning message with the throwable message
    * @param message the message to log
    * @param t the exception
    */
   void warn(String message, Throwable t);

   /**
    * Logging an error message
    * @param message the message to log
    */
   void error(String message);

   /**
    * Logging an error message with the throwable message
    * @param message the message to log
    * @param t the exception
    */
   void error(String message, Throwable t);

   /**
    * Logging a fatal message
    * @param message the message to log
    */
   void fatal(String message);

   /**
    * Logging a fatal message with the throwable message
    * @param message the message to log
    * @param t the exception
    */
   void fatal(String message, Throwable t);
}
