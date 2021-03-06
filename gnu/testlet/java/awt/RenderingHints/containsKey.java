//Tags: JDK1.2

//Copyright (C) 2004 David Gilbert <david.gilbert@object-refinery.com>

//This file is part of Mauve.

//Mauve is free software; you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation; either version 2, or (at your option)
//any later version.

//Mauve is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.

//You should have received a copy of the GNU General Public License
//along with Mauve; see the file COPYING.  If not, write to
//the Free Software Foundation, 59 Temple Place - Suite 330,
//Boston, MA 02111-1307, USA.  */

package gnu.testlet.java.awt.RenderingHints;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import java.awt.RenderingHints;

/**
 * Some checks for the containsKey() method in the {@link RenderingHints}
 * class.
 */
public class containsKey implements Testlet {

  /**
   * Runs the test using the specified harness.
   * 
   * @param harness  the test harness (<code>null</code> not permitted).
   */
  public void test(TestHarness harness) {
  
    RenderingHints h = new RenderingHints(
      RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF
    );
    harness.check(h.containsKey(RenderingHints.KEY_TEXT_ANTIALIASING));
    harness.check(!h.containsKey(RenderingHints.KEY_ANTIALIASING));
    
    // an argument that is not a RenderingHint.Key should generate
    // a ClassCastException...
    boolean pass = false;
    try
    {
      h.containsKey(new Integer(1));
    }
    catch (ClassCastException e)  
    {
      pass = true;
    }
    harness.check(pass);
    
    // the API spec clearly states that a null argument should generate a
    // NullPointerException...
    pass = false;
    try
    {
      h.containsKey(null);
    }
    catch (NullPointerException e) 
    {
      pass = true;
    }
    harness.check(pass);
  }

}
