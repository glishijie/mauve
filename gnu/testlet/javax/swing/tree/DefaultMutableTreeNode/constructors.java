// Tags: JDK1.2

// Copyright (C) 2004  Michael Koch <konqueror@gmx.de>

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

package gnu.testlet.javax.swing.tree.DefaultMutableTreeNode;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import javax.swing.tree.*;

public class constructors implements Testlet
{
  private void check(TestHarness h, DefaultMutableTreeNode node,
                     Object userObject, boolean allowsChildren)
  {
    h.check(node.getUserObject(), userObject, "userObject");
    h.check(node.getAllowsChildren(), allowsChildren, "allowsChildren");
  }
  
  public void test(TestHarness h)
  {
    Object userObject = new Object();
    
    check(h, new DefaultMutableTreeNode(),
          null, true);
    check(h, new DefaultMutableTreeNode(userObject),
          userObject, true);
    check(h, new DefaultMutableTreeNode(userObject, true),
          userObject, true);
    check(h, new DefaultMutableTreeNode(userObject, false),
          userObject, false);
  }
}