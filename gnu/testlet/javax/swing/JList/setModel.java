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
// the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, 
// Boston, MA 02110-1301 USA.

package gnu.testlet.javax.swing.JList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 * Some checks for the setModel() method of the 
 * {@link JList} class.
 */
public class setModel implements Testlet, PropertyChangeListener 
{

  List events = new java.util.ArrayList();
  
  public void propertyChange(PropertyChangeEvent e) 
  {
    events.add(e);
  }

  /**
   * Runs the test using the specified harness.
   * 
   * @param harness  the test harness (<code>null</code> not permitted).
   */
  public void test(TestHarness harness)       
  {
    // make sure we're using the MetalLookAndFeel
    try
    {
      UIManager.setLookAndFeel(new MetalLookAndFeel());
    }
    catch (UnsupportedLookAndFeelException e)
    {
      e.printStackTrace();
    }
    JList list = new JList();
    list.addPropertyChangeListener(this);

    DefaultListModel m = new DefaultListModel();
    list.setModel(m);
    harness.check(list.getModel(), m);
    harness.check(events.size(), 1);

    PropertyChangeEvent e0 = (PropertyChangeEvent) events.get(0);
    harness.check(e0.getPropertyName(), "model");
    harness.check(e0.getOldValue() != null);
    harness.check(e0.getNewValue(), m);
    
    // try null argument
    boolean pass = false;
    try
    {
      list.setModel(null);
    }
    catch (IllegalArgumentException e)
    {
      pass = true;    
    }
    harness.check(pass);
  }

}
