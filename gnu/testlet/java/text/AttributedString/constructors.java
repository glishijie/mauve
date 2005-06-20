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

package gnu.testlet.java.text.AttributedString;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.HashMap;

/**
 * Some checks for the constructors in the {@link AttributedString} class.  
 */
public class constructors implements Testlet
{

  /**
   * Runs the test using the specified harness.
   * 
   * @param harness  the test harness (<code>null</code> not allowed).
   */
  public void test(TestHarness harness) 
  {
    testConstructor1(harness);
    testConstructor2(harness);
    testConstructor3(harness);
    testConstructor4(harness);
    testConstructor5(harness);
  }

  private void testConstructor1(TestHarness harness) 
  {
    harness.checkPoint("AttributedString(AttributedCharacterIterator);"); 
  }

  private void testConstructor2(TestHarness harness) 
  {
    harness.checkPoint("AttributedString(AttributedCharacterIterator, int, int);"); 
  }

  private void testConstructor3(TestHarness harness) 
  {
    harness.checkPoint("AttributedString(AttributedCharacterIterator, int, int, AttributedCharacterIterator.Attribute[]);"); 
  }

  private void testConstructor4(TestHarness harness) 
  {
    harness.checkPoint("AttributedString(String);");
    
    // try null argument - the API spec doesn't say what happens.
    boolean pass = false;
    try
    {
      /* AttributedString as = */ new AttributedString((String) null);   
    }
    catch (NullPointerException e) 
    {
      pass = true;   
    }
    harness.check(pass);
  }

  private void testConstructor5(TestHarness harness) 
  {
    harness.checkPoint("AttributedString(String, map);");
    HashMap map = new HashMap();
    map.put(AttributedCharacterIterator.Attribute.LANGUAGE, "English");    
    AttributedString as = new AttributedString("ABC", map);
    AttributedCharacterIterator aci = as.getIterator();
    harness.check(aci.first() == 'A');
    harness.check(aci.getAttribute(AttributedCharacterIterator.Attribute.LANGUAGE).equals("English"));
    harness.check(aci.getRunLimit() == 3);
    harness.check(aci.getRunStart() == 0);
    
    // test null string - not specified, assuming NullPointerException
    boolean pass = false;
    try 
    {
      /* AttributedString as = */ new AttributedString(null, new HashMap());   
    }
    catch (NullPointerException e) 
    {
      pass = true;   
    }
    harness.check(pass);
    
    // test null map - not specified, assuming NullPointerException.
    pass = false;
    try
    {
      /* AttributedString as = */ new AttributedString("ABC", null);
    }
    catch (NullPointerException e)
    {
      pass = true;   
    }
    harness.check(true);
    
    // test empty string with non-empty map
    pass = false;
    try
    {
      /* AttributedString as = */ new AttributedString("", map);   
    }
    catch (IllegalArgumentException e)
    {
      pass = true;   
    }
    
  }

}