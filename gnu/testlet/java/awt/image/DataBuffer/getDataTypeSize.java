//Tags: JDK1.2

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

package gnu.testlet.java.awt.image.DataBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import java.awt.image.DataBuffer;

/**
 * Verifies the getDataTypeSize() method in the {@link DataBuffer} class.
 */
public class getDataTypeSize implements Testlet {

  /**
   * Runs the test using the specified harness.
   * 
   * @param harness  the test harness (<code>null</code> not permitted).
   */
  public void test(TestHarness harness)      
  {
    harness.check(DataBuffer.getDataTypeSize(DataBuffer.TYPE_BYTE) == 8);
    harness.check(DataBuffer.getDataTypeSize(DataBuffer.TYPE_DOUBLE) == 64);
    harness.check(DataBuffer.getDataTypeSize(DataBuffer.TYPE_FLOAT) == 32);
    harness.check(DataBuffer.getDataTypeSize(DataBuffer.TYPE_INT) == 32);
    harness.check(DataBuffer.getDataTypeSize(DataBuffer.TYPE_SHORT) == 16);
    harness.check(DataBuffer.getDataTypeSize(DataBuffer.TYPE_USHORT) == 16);

    boolean pass = false;
    try
    {
      DataBuffer.getDataTypeSize(DataBuffer.TYPE_UNDEFINED);
    }
    catch (IllegalArgumentException e) 
    {
      pass = true;
    }
    harness.check(pass);
    
    pass = false;
    try
    {
      DataBuffer.getDataTypeSize(-1);
    }
    catch (IllegalArgumentException e) 
    {
      pass = true;
    }
    harness.check(pass);

  }

}
