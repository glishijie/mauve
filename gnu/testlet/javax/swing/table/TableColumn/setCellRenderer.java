// Tags: JDK1.2

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

package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 * Some tests for the setCellRenderer() method in the {@link TableColumn} class.
 */
public class setCellRenderer implements Testlet, PropertyChangeListener
{

  private PropertyChangeEvent event = null;
  
  /**
   * Runs the test using the specified harness.
   * 
   * @param harness  the test harness (<code>null</code> not permitted).
   */
  public void test(TestHarness harness)      
  {
    TableColumn c = new TableColumn();
    TableCellRenderer r1 = new DefaultTableCellRenderer();
    c.setCellRenderer(r1);
    harness.check(c.getCellRenderer(), r1);
  
    // O'Reilly's "Java Swing" (first edition) lists this as a "bound" property
  	c.addPropertyChangeListener(this);
  	TableCellRenderer r2 = new DefaultTableCellRenderer();
  	c.setCellRenderer(r2);
  	harness.check(this.event != null);
  }
  
  public void propertyChange(PropertyChangeEvent e) 
  {
    this.event = e;
  }

}
