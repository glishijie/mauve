//Tags: JDK1.0

//Copyright (C) 2004 David Gilbert <david.gilbert@object-refinery.com>

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

package gnu.testlet.java.awt.Rectangle;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * Checks that the add() method works correctly.
 */
public class add implements Testlet {

  /**
   * Runs the test using the specified harness.
   * 
   * @param harness  the test harness (<code>null</code> not permitted).
   */
  public void test(TestHarness harness)  
  {
    Rectangle r = new Rectangle();
    r.add(5, 7);
    harness.check(r.x == 0);
    harness.check(r.y == 0);
    harness.check(r.width == 5);
    harness.check(r.height == 7);
    
    boolean pass = false;
    try {
        r.add((Point) null);
    }
    catch (NullPointerException e) {
        pass = true;
    }
    harness.check(pass);
    
    pass = false;
    try {
        r.add((Rectangle) null);
    }
    catch (NullPointerException e) {
        pass = true;
    }
    harness.check(pass);
  }

}
