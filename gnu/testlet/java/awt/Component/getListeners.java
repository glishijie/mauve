// Tags: JDK1.3

// Copyright (C) 2005 David Gilbert  <david.gilbert@object-refinery.com>

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

package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusListener;
import java.util.EventListener;

/**
 * Some tests for the <code>getListeners(Class)</code> method in the 
 * {@link Component} class.
 */
public class getListeners implements Testlet, ComponentListener {

  class TestComponent extends Component
  {
  }

  /**
   * Runs the test using the specified harness.
   * 
   * @param harness  the test harness (<code>null</code> not permitted).
   */
  public void test(TestHarness harness)      
  {
    TestComponent c = new TestComponent();
    c.addComponentListener(this);
    EventListener[] listeners = c.getListeners(ComponentListener.class);
    harness.check(listeners.length, 1);
    harness.check(listeners[0], this);
    // try a listener type that isn't registered
    listeners = c.getListeners(FocusListener.class);
    harness.check(listeners.length, 0);
    c.removeComponentListener(this);
    listeners = c.getListeners(ComponentListener.class);
    harness.check(listeners.length, 0);
    
    // try a null argument
    boolean pass = false;
    try
    {
      listeners = c.getListeners(null);
    }
    catch (NullPointerException e) 
    {
      pass = true;    
    }
    harness.check(pass);
    
  /* Doesn't compile with 1.5
    // try a class that isn't a listener
    pass = false;
    try
    {
      listeners = c.getListeners(Integer.class);
    }
    catch (ClassCastException e) 
    {
      pass = true;
    }
    harness.check(pass);
  */
  }
  
  public void componentResized(ComponentEvent e) 
  {
    // ignore   
  }
  
  public void componentShown(ComponentEvent e) 
  {
    // ignore
  }
  
  public void componentMoved(ComponentEvent e) 
  {
    // ignore
  }
  
  public void componentHidden(ComponentEvent e) 
  {
    // ignore
  }
}
