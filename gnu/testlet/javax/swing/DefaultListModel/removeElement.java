// Tags: JDK1.2

// Copyright (C) 2005 David Gilbert <david.gilbert@object-refinery.com>

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
// Boston, MA 02111-1307, USA.  */

package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;

/**
 * Some tests for the removeElement() method in the {@link DefaultListModel} class.
 */
public class removeElement implements Testlet 
{

  /**
   * Runs the test using the specified harness.
   * 
   * @param harness  the test harness (<code>null</code> not permitted).
   */
  public void test(TestHarness harness)      
  {
    harness.checkPoint("removeElement(Object)");
    DefaultListModel m1 = new DefaultListModel();
    MyListDataListener listener = new MyListDataListener();
    m1.addListDataListener(listener);
    m1.addElement("A");
    m1.addElement("B");
    m1.addElement("C");
    m1.addElement("D");
    m1.addElement("D");
    m1.addElement("C");
    m1.addElement("B");
    m1.addElement("A");
    
    boolean removed = m1.removeElement("A");
    harness.check(m1.lastElement(), "A");
    harness.check(m1.size(), 7);
    harness.check(removed);
    ListDataEvent event = listener.getEvent();
    harness.check(event.getType(), ListDataEvent.INTERVAL_REMOVED);
    harness.check(event.getIndex0(), 0);
    harness.check(event.getIndex1(), 0);
    listener.setListDataEvent(null);
    
    removed = m1.removeElement(null);
    harness.check(m1.size(), 7);
    harness.check(!removed);
    harness.check(listener.getEvent(), null);
  
  }

}
