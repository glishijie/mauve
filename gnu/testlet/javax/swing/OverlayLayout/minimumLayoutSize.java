//Tags: JDK1.2

//Copyright (C) 2005 Roman Kennke (kennke@aicas.com)

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
//Boston, MA 02111-1307, USA.

package gnu.testlet.javax.swing.OverlayLayout;

import java.awt.AWTError;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

/**
* Tests if the method minimumLayoutSize of OverlayLayout works correctly.
*
* @author Roman Kennke (kennke@aicas.com)
*/
public class minimumLayoutSize implements Testlet
{

  /**
   * Starts the test run.
   *
   * @param harness the test harness to use
   */
  public void test(TestHarness harness)
  {
    testWithoutChildren(harness);
    testWithOneChild(harness);
    testWithTwoChildren(harness);
    testWithAlignment(harness);
    testWrongContainer(harness);
  }

  /**
   * Tests this method without any child components.
   *
   * @param h the test harness to use
   */
  void testWithoutChildren(TestHarness h)
  {
    h.checkPoint("withoutChildren");
    JPanel c = new JPanel();
    OverlayLayout l = new OverlayLayout(c);
    h.check(l.minimumLayoutSize(c).width, 0);
    h.check(l.minimumLayoutSize(c).height, 0);
  }

  /**
   * Tests this method with one child component.
   *
   * @param h the test harness to use
   */
  void testWithOneChild(TestHarness h)
  {
    h.checkPoint("withOneChild");
    JPanel c = new JPanel();
    JPanel c1 = new JPanel();
    c1.setMinimumSize(new Dimension(10, 10));
    c1.setPreferredSize(new Dimension(20, 20));
    c1.setMaximumSize(new Dimension(30, 30));
    c.add(c1);
    OverlayLayout l = new OverlayLayout(c);
    h.check(l.minimumLayoutSize(c).width, 10);
    h.check(l.minimumLayoutSize(c).height, 10);
  }

  /**
   * Tests this method with two child components.
   *
   * @param h the test harness to use
   */
  void testWithTwoChildren(TestHarness h)
  {
    h.checkPoint("withTwoChildren");
    JPanel c = new JPanel();
    JPanel c1 = new JPanel();
    c1.setMinimumSize(new Dimension(10, 10));
    c1.setPreferredSize(new Dimension(20, 20));
    c1.setMaximumSize(new Dimension(30, 30));
    c.add(c1);
    JPanel c2 = new JPanel();
    c2.setMinimumSize(new Dimension(40, 40));
    c2.setPreferredSize(new Dimension(50, 50));
    c2.setMaximumSize(new Dimension(60, 60));
    c.add(c2);
    OverlayLayout l = new OverlayLayout(c);
    h.check(l.minimumLayoutSize(c).width, 40);
    h.check(l.minimumLayoutSize(c).height, 40);
  }

  /**
   * Tests this method with 3 children with differen alignment values.
   *
   * @param h the test harness to use
   */
  void testWithAlignment(TestHarness h)
  {
    h.checkPoint("withAlignment");
    JPanel c = new JPanel();
    JPanel c1 = new JPanel();
    c1.setMinimumSize(new Dimension(10, 10));
    c1.setPreferredSize(new Dimension(20, 20));
    c1.setMaximumSize(new Dimension(30, 30));
    c1.setAlignmentX(0.0F);
    c.add(c1);
    JPanel c2 = new JPanel();
    c2.setMinimumSize(new Dimension(40, 40));
    c2.setPreferredSize(new Dimension(50, 50));
    c2.setMaximumSize(new Dimension(60, 60));
    c2.setAlignmentX(0.5F);
    c.add(c2);
    JPanel c3 = new JPanel();
    c3.setMinimumSize(new Dimension(40, 40));
    c3.setPreferredSize(new Dimension(50, 50));
    c3.setMaximumSize(new Dimension(60, 60));
    c3.setAlignmentX(1.0F);
    c.add(c3);
    OverlayLayout l = new OverlayLayout(c);
    h.check(l.minimumLayoutSize(c).width, 60);
    h.check(l.minimumLayoutSize(c).height, 40);
  }

  /**
   * Tests this method with the wrong container.
   *
   * @param h the test harness to use
   */
  void testWrongContainer(TestHarness h)
  {
    h.checkPoint("wrongContainer");
    JPanel c1 = new JPanel();
    JPanel c2 = new JPanel();
    OverlayLayout l = new OverlayLayout(c1);
    try
      {
        h.check(l.minimumLayoutSize(c2).width, 30);
        h.fail("minimumLayoutSize must throw AWTError when "
               + "called with wrong container.");
      }
    catch (AWTError ex)
      {
        h.check(true);
      }
  }
}
