// Tags: JDK1.2

// Copyright (C) 2004 Sascha Brawer <brawer@dandelis.ch>

// This file is part of Mauve.

// Mauve is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2, or (at your option)
// any later version.

// Mauve is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with Mauve; see the file COPYING.  If not, write to
// the Free Software Foundation, 59 Temple Place - Suite 330,
// Boston, MA 02111-1307, USA.

package gnu.testlet.java.awt.image.DataBufferFloat;

import gnu.testlet.Testlet;
import gnu.testlet.TestHarness;

import java.awt.image.DataBuffer;
import java.awt.image.DataBufferFloat;


/**
 * @author <a href="mailto:brawer@dandelis.ch">Sascha Brawer</a>
 */
public class getElem
  implements Testlet
{
  public void test(TestHarness h)
  {
    DataBuffer buf;
    float[] data = new float[] { 1.1f, -2.2f, 3.3f, -4.4f };
    
    buf = new DataBufferFloat(new float[][] { data, data }, 2,
                              new int[] { 2, 0 });

    h.check(buf.getElem(0), 3);     // Check #1.
    h.check(buf.getElem(1), -4);    // Check #2.
    h.check(buf.getElem(0, 0), 3);  // Check #3.
    h.check(buf.getElem(0, 1), -4); // Check #4.
    h.check(buf.getElem(1, 0), 1);  // Check #5.
    h.check(buf.getElem(1, 1), -2); // Check #6.
  }
}
