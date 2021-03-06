// Copyright (c) 2000, 2001 NEC Corporation.

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

// C
package gnu.testlet.org.omg.CORBA.ORB.RF11;

public final class C_struct
  implements org.omg.CORBA.portable.IDLEntity
{
  public short e_short = (short) 0;
  public short e_ushort = (short) 0;
  public int e_long = (int) 0;
  public int e_ulong = (int) 0;
  public float e_float = (float) 0;
  public double e_double = (double) 0;
  public char e_char = (char) 0;
  public boolean e_boolean = false;
  public byte e_octet = (byte) 0;
  public org.omg.CORBA.Any e_any = null;
  public String e_string = null;
  public org.omg.CORBA.Object e_Object = null;

  public C_struct()
  {
  } // ctor

  public C_struct(short _e_short, short _e_ushort, int _e_long, int _e_ulong,
                  float _e_float, double _e_double, char _e_char,
                  boolean _e_boolean, byte _e_octet, org.omg.CORBA.Any _e_any,
                  String _e_string, org.omg.CORBA.Object _e_Object
                 )
  {
    e_short = _e_short;
    e_ushort = _e_ushort;
    e_long = _e_long;
    e_ulong = _e_ulong;
    e_float = _e_float;
    e_double = _e_double;
    e_char = _e_char;
    e_boolean = _e_boolean;
    e_octet = _e_octet;
    e_any = _e_any;
    e_string = _e_string;
    e_Object = _e_Object;
  } // ctor
} // class C_struct
