// Tags: JDK1.2

// Uses: ../TestList

// Copyright (C) 2005 Roman Kennke <kennke@aicas.com>

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

package gnu.testlet.javax.swing.JList.AccessibleJList.AccessibleJListChild;

import java.awt.Cursor;

import javax.accessibility.AccessibleComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JList.AccessibleJList.TestList;

/**
 * Checks if the method getCursor works correctly. This should return the
 * cursor set by setCursor, independent of the JList's cursor setting.
 *
 * @author Roman Kennke (kennke@aicas.com)
 */
public class getCursor implements Testlet
{

  public void test(TestHarness harness)
  {
    TestList l = new TestList(new String[]{"item"});
    TestList.AccessibleTestList al =
      (TestList.AccessibleTestList) l.getAccessibleContext();
    Cursor cursor1 = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
    Cursor cursor2 = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    l.setCursor(cursor1);
    harness.check(l.getCursor(), cursor1);
    AccessibleComponent child = (AccessibleComponent) al.getAccessibleChild(0);
    harness.check(child.getCursor(), Cursor.getDefaultCursor());
    l.setCursor(cursor2);
    harness.check(child.getCursor(), Cursor.getDefaultCursor());

    // Try if it reacts to setCursor().
    child.setCursor(cursor1);
    harness.check(child.getCursor(), cursor1);
  }

}
