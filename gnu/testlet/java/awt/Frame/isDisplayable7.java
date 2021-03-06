// Tags: GUI JDK1.0

// Copyright (C) 2005, 2011 Red Hat

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

package gnu.testlet.java.awt.Frame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import java.awt.*;

/**
 * Tests that adding a not-visible Component to a Frame, then showing
 * the Frame, causes the Component to become displayable.
 */
public class isDisplayable7 implements Testlet
{
  public void test (TestHarness harness)
  {
    Frame f = new Frame ();
    Button b = new Button ();
    Robot r = harness.createRobot ();

    r.waitForIdle ();

    // Hide the button.
    b.setVisible (false);

    // FIXME: this hangs with our Robot implementation:
    //    r.waitForIdle ();

    f.add (b);

    // Check if the button is made visible when it is added.
    harness.check (!b.isVisible ());

    r.waitForIdle ();

    harness.checkPoint ("parent check");
    harness.check (b.getParent(), f);

    harness.checkPoint ("before showing");
    harness.check (f.getPeer (), null);
    harness.check (b.getPeer (), null);
    harness.check (f.isDisplayable (), false);
    harness.check (b.isDisplayable (), false);

    f.show ();

    r.waitForIdle ();

    // Check if showing the parent Frame makes the hidden child Button
    // displayable.
    harness.checkPoint ("after showing frame");
    harness.check (f.getPeer () != null);
    harness.check (b.getPeer () != null);
    harness.check (f.isDisplayable (), true);
    harness.check (b.isDisplayable (), true);

    b.show ();

    r.waitForIdle ();

    harness.checkPoint ("after showing button");
    harness.check (f.getPeer () != null);
    harness.check (b.getPeer () != null);
    harness.check (f.isDisplayable (), true);
    harness.check (b.isDisplayable (), true);

    // time to clean up the frame from desktop
    f.dispose();
  }
}
