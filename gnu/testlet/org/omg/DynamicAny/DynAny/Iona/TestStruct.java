// Copyright (c) IONA Technologies, 2001.

// Adapted for Mauve by Audrius Meskauskas <audriusa@bluewin.ch>

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

/*
This code originally came from the OMG's CORBA Open Source Testing project,
which lived at cost.omg.org. That site no longer exists.

All the contributing companies agreed to release their tests under the
terms of the GNU Lesser General Public License, available in the file
COPYING.LIB.

The code has been modified integrating into Mauve test environment and
removing tests that are not yet supported by Suns jre 1.4. Hence the license
is now GPL.

We downloaded the code from http://sourceforge.net/projects/corba-cost/,
administrated by Duncan Grisby.
*/

package gnu.testlet.org.omg.DynamicAny.DynAny.Iona;

public final class TestStruct
  implements org.omg.CORBA.portable.IDLEntity
{
  public org.omg.CORBA.Any anyVal;
  public org.omg.CORBA.Object objectVal;
  public String stringVal;
  public String wstringVal;
  public org.omg.CORBA.TypeCode tcVal;
  public boolean boolVal;
  public byte octetVal;
  public char charVal;
  public char wcharVal;
  public double doubleVal;
  public float floatVal;
  public int longVal;
  public int ulongVal;
  public long longlongVal;
  public long ulonglongVal;
  public short shortVal;
  public short ushortVal;
}