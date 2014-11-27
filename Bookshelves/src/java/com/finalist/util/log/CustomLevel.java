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

import java.util.logging.Level;

/**
 * A class for making custom levels for logging.
 *
 * @author Ronald Kramp - Finalist IT Group
 * @version $Revision: 1.1 $, $Date: 2005/10/13 21:17:51 $
 */
class CustomLevel extends Level {

   /** a Level for DEBUG */
   public static final Level DEBUG = new CustomLevel("DEBUG", Level.INFO.intValue() - 1);

   /** a Level for ERROR */
   public static final Level ERROR = new CustomLevel("ERROR", Level.SEVERE.intValue() - 1);

   /** a Level for FATAL */
   public static final Level FATAL = new CustomLevel("FATAL", Level.SEVERE.intValue() + 1);


   /**
    * Constrcutor for making a custom level.
    * @param name, the name of the Level
    * @param value, the value for the level
    */
   public CustomLevel(String name, int value) {
      super(name, value);
   }


   /**
    * Parse a levelName to a Level object.
    * @param levelName the name of the Level to parse to a Level obhect
    * @return Level the Level object parsed
    */
   public static Level parse(String levelName) {
      if (levelName.equals("DEBUG")) {
         return DEBUG;
      }
      else if (levelName.equals("ERROR")) {
         return ERROR;
      }
      else if (levelName.equals("FATAL")) {
         return FATAL;
      }
      else {
         return Level.parse(levelName);
      }
   }
}
