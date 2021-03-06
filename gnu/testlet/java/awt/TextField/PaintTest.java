/* PaintTest.java -- 
   Copyright (C) 2006, 2011 Red Hat
This file is part of Mauve.

Mauve is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2, or (at your option)
any later version.

Mauve is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with Mauve; see the file COPYING.  If not, write to the
Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
02110-1301 USA.

*/

// Tags: GUI, JDK 1.0

package gnu.testlet.java.awt.TextField;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.TextField;

public class PaintTest
    extends Panel
    implements Testlet
{

  /**
   * Runs the test using the specified harness. 
   * 
   * @param harness  the test harness (<code>null</code> not permitted).
   */
  public void test(TestHarness harness)
  {
    setBackground(Color.red);
    Frame f = new Frame();
    TextField b = new TextField(10);
    b.setBackground(Color.green);
    add(b);
    f.add(this);
    f.pack();
    f.show();

    // AWT robot is used for reading pixel colors
    // from a screen and also to wait for all
    // widgets to stabilize theirs size and position.
    Robot r = harness.createRobot();

    // we should wait a moment before the computations
    // and pixel checks
    r.waitForIdle();
    r.delay(1000);

    Rectangle bounds = b.getBounds();
    Point loc = f.getLocationOnScreen();
    Insets i = f.getInsets();
    bounds.x += loc.x + i.left;
    bounds.y += loc.y + i.top;
    
    // position of checked pixel
    int checkedPixelX = bounds.x + bounds.width / 2;
    int checkedPixelY = bounds.y + bounds.height / 2;

    // move the mouse cursor to a tested pixel to show users what's checked
    r.mouseMove(checkedPixelX, checkedPixelY);
    r.waitForIdle();

    // check the color of a pixel located in the text center
    Color text = r.getPixelColor(checkedPixelX, checkedPixelY);
    harness.check(text.equals(Color.green));

    // There is a delay to avoid any race conditions    
    // and so user can see frame
    r.waitForIdle();
    r.delay(1000);

    // it's necesarry to clean up the component from desktop
    f.dispose();
  }

  public void paint(Graphics g)
  {
    Image offScr = createImage(getSize().width, getSize().height);
    Graphics offG = offScr.getGraphics();
    offG.setClip(0, 0, getSize().width, getSize().height);

    super.paint(offG);
    g.drawImage(offScr, 0, 0, null);

    offG.dispose();
  }
}

