// Tags: JDK1.4
// Uses: MyListener

// Copyright (C) 2005 David Gilbert <david.gilbert@object-refinery.com>

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

package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import java.util.Arrays;
import java.util.List;

import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableColumnModel;

/**
* Some tests for the getColumnModelListeners() method in the 
* {@link DefaultTableColumnModel} class.
*/
public class getColumnModelListeners implements Testlet
{

  /**
   * Runs the test using the specified harness. #
   * 
   * @param harness  the test harness (<code>null</code> not permitted).
   */
  public void test(TestHarness harness)      
  {
    DefaultTableColumnModel m1 = new DefaultTableColumnModel();
    TableColumnModelListener[] listeners = m1.getColumnModelListeners();
    harness.check(listeners.length, 0);
    
    TableColumnModelListener listener = new MyListener();
    m1.addColumnModelListener(listener);
    listeners = m1.getColumnModelListeners();
    harness.check(listeners[0], listener);
    
    TableColumnModelListener listener2 = new MyListener();
    m1.addColumnModelListener(listener2);
    listeners = m1.getColumnModelListeners();
    // convert to a list, because the spec doesn't say anything about the
    // order of the listeners
    List list = Arrays.asList(listeners);
    harness.check(list.contains(listener));
    harness.check(list.contains(listener2)); 
  }

}
