// Tags: JDK1.4

// Copyright (C) 2004 Michael Koch <konqueror@gmx.de>

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

package gnu.testlet.javax.print.DocFlavor;

import gnu.testlet.Testlet;
import gnu.testlet.TestHarness;

import javax.print.DocFlavor;

/**
 * @author Michael Koch (konqueror@gmx.de)
 */
public class parseMimeType implements Testlet
{
  public void test(TestHarness h)
  {
    DocFlavor flavor = new DocFlavor("text/plain; charset=us-ascii", "java.io.InputStream");

    // Check if mimetype can be correctly decoded.
    h.check(flavor.getMediaType().equals("text"));
    h.check(flavor.getMediaSubtype().equals("plain"));
    h.check(flavor.getParameter("charset").equals("us-ascii"));
    h.check(flavor.getRepresentationClassName().equals("java.io.InputStream"));
    
    // Check if mimetype can be correctly built together again.
    h.check(flavor.getMimeType().equals("text/plain; charset=\"us-ascii\""));    
  }
}
