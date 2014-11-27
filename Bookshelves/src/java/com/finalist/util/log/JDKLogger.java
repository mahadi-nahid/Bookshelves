package com.finalist.util.log;

import java.util.logging.Level;
/**
 * This class is wil log messages to the log file using the jdk logging framework.
 * @author  Jan  Finalist IT Group
 * @version $Revision: 1.1.1.1 $, $Date: 2009/05/27 10:34:57 $
 */
public final class JDKLogger implements Logger {
   
   /**
    * the log object to log to.
    */
   private java.util.logging.Logger logger = null;
   
   /**
    * Constructor for creating a logger object using jdk 1.4 or higher logging.
    *
    * @param cls the class which wants to log
    */
   public JDKLogger(Class cls) {
      logger = java.util.logging.Logger.getLogger(JDKLogger.class.getPackage().getName());
   }

   /**
    * Logging a finest message.
    * @param message the message to log
    */
   public void finest(String message) {
      logger.finest(message);
   }

   /**
    * Logging a finer message.
    * @param message the message to log
    */
   public void finer(String message) {
      logger.finer(message);
   }

   /**
    * Logging a fine message.
    * @param message the message to log
    */
   public void fine(String message) {
      logger.fine(message);
   }

   /**
    * Logging a config message.
    * @param message the message to log
    */
   public void config(String message) {
      logger.config(message);
   }

   /**
    * Logging an info message.
    * @param message the message to log
    */
   public void info(String message) {
      logger.info(message);
   }

   /**
    * Logging a warning message.
    * @param message the message to log
    */
   public void warning(String message) {
      logger.warning(message);
   }

   /**
    * Logging a severe message.
    * @param message the message to log
    */
   public void severe(String message) {
      logger.severe(message);
   }

   //****************************************************
   //*  The methods from log4j also implemented below   *
   //****************************************************

   /**
    * Logging a debug message.
    * @param message the message to log
    */
   public void debug(String message) {
      logger.log(CustomLevel.DEBUG, message);
   }

   /**
    * Logging a debug message with the throwable message.
    * @param message the message to log
    * @param t the exception
    */
   public void debug(String message, Throwable t) {
      logger.log(CustomLevel.DEBUG, message, t);
   }

   /**
    * Logging an info message with the throwable message.
    * @param message the message to log
    * @param t the exception
    */
   public void info(String message, Throwable t) {
      logger.log(Level.INFO, message, t);
   }

   /**
    * Logging a warning message.
    * @param message the message to log
    */
   public void warn(String message) {
      logger.log(Level.WARNING, message);
   }

   /**
    * Logging a warning message with the throwable message.
    * @param message the message to log
    * @param t the exception
    */
   public void warn(String message, Throwable t) {
      logger.log(Level.WARNING, message, t);
   }

   /**
    * Logging an error message.
    * @param message the message to log
    */
   public void error(String message) {
      logger.log(CustomLevel.ERROR, message);
   }

   /**
    * Logging an error message with the throwable message.
    * @param message the message to log
    * @param t the exception
    */
   public void error(String message, Throwable t) {
      logger.log(CustomLevel.ERROR, message, t);
   }

   /**
    * Logging a fatal message.
    * @param message the message to log
    */
   public void fatal(String message) {
      logger.log(CustomLevel.FATAL, message);
   }

   /**
    * Logging a fatal message with the throwable message.
    * @param message the message to log
    * @param t the exception
    */
   public void fatal(String message, Throwable t) {
      logger.log(CustomLevel.FATAL, message, t);
   }

}
