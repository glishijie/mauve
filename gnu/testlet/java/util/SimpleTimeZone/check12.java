// Test SimpleTimeZone.check12().

// Written by Jerry Quinn <jlquinn@optonline.net>

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

// Tags: JDK1.2

// Test features added by JDK 1.2

package gnu.testlet.java.util.SimpleTimeZone;

import gnu.testlet.Testlet;
import gnu.testlet.TestHarness;
import java.util.*;
import java.text.*;
public class check12 implements Testlet
{
  public void test (TestHarness harness)
  {
    int rawOff = -18000000;	// 5 hours
    int dstOff = 3600000;	// 1 hour

    // Create a timezone for UTC-5 with daylight savings starting on
    // the second Monday, April 10 at 12 noon, ending the second
    // Sunday, September 10, 12 noon in daylight savings, 1 hour
    // shift.

    // All three should represent the same period
    SimpleTimeZone tz =
      new SimpleTimeZone(rawOff, "Z1",
			 Calendar.APRIL, 10, 0, 43200000,
			 Calendar.SEPTEMBER, 10, 0, 43200000,
			 dstOff);

    int off;

    // Test 1/2 hour before dst
    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.APRIL, 10, Calendar.SATURDAY, 41400000);
    harness.check(off, rawOff);
    
    // Test 1/2 hour into dst
    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.APRIL, 10, Calendar.SATURDAY, 45000000);
    harness.check(off, rawOff + dstOff);

    // Test end rule
    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.SEPTEMBER, 10, Calendar.FRIDAY, 41400000);
    harness.check(off, rawOff + dstOff);
    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.SEPTEMBER, 10, Calendar.FRIDAY, 45000000);
    harness.check(off, rawOff);

    // Test that Nth dayofweek works with day of month rules
    tz.setStartRule(Calendar.APRIL, 2, Calendar.SATURDAY, 43200000);

    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.APRIL, 10, Calendar.SATURDAY, 41400000);
    harness.check(off, rawOff);
    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.APRIL, 10, Calendar.SATURDAY, 45000000);
    harness.check(off, rawOff + dstOff);

    tz.setEndRule(Calendar.SEPTEMBER, 2, Calendar.FRIDAY, 43200000);

    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.SEPTEMBER, 10, Calendar.FRIDAY, 41400000);
    harness.check(off, rawOff + dstOff);
    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.SEPTEMBER, 10, Calendar.FRIDAY, 45000000);
    harness.check(off, rawOff);

    // Test that -Nth dayofweek works with day of month rules
    tz.setStartRule(Calendar.APRIL, -3, Calendar.SATURDAY, 43200000);

    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.APRIL, 10, Calendar.SATURDAY, 41400000);
    harness.check(off, rawOff);
    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.APRIL, 10, Calendar.SATURDAY, 45000000);
    harness.check(off, rawOff + dstOff);

    tz.setEndRule(Calendar.SEPTEMBER, -3, Calendar.FRIDAY, 43200000);

    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.SEPTEMBER, 10, Calendar.FRIDAY, 41400000);
    harness.check(off, rawOff + dstOff);
    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.SEPTEMBER, 10, Calendar.FRIDAY, 45000000);
    harness.check(off, rawOff);

    // Friday on or before April 5, 2004 is April 2
    // Test arguments get overidden and perform correctly
    tz.setStartRule(Calendar.APRIL, -5, -Calendar.FRIDAY, 43200000, false);

    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.APRIL, 2, Calendar.FRIDAY, 41400000);
    harness.check(off, rawOff);
    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.APRIL, 2, Calendar.FRIDAY, 45000000);
    harness.check(off, rawOff + dstOff);
    
    tz.setEndRule(Calendar.SEPTEMBER, -15, -Calendar.FRIDAY, 43200000);

    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.SEPTEMBER, 10, Calendar.FRIDAY, 41400000);
    harness.check(off, rawOff + dstOff);
    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.SEPTEMBER, 10, Calendar.FRIDAY, 45000000);
    harness.check(off, rawOff);

    // Sunday on or after April 5, 2004 is April 11
    // Test arguments get overidden and perform correctly
    tz.setStartRule(Calendar.APRIL, 5, -Calendar.SATURDAY, 43200000, true);

    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.APRIL, 11, Calendar.SATURDAY, 41400000);
    harness.check(off, rawOff);
    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.APRIL, 11, Calendar.SATURDAY, 45000000);
    harness.check(off, rawOff + dstOff);

    tz.setEndRule(Calendar.SEPTEMBER, 6, -Calendar.FRIDAY, 43200000);

    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.SEPTEMBER, 10, Calendar.FRIDAY, 41400000);
    harness.check(off, rawOff + dstOff);
    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.SEPTEMBER, 10, Calendar.FRIDAY, 45000000);
    harness.check(off, rawOff);

    // Currently broken in GCJ
    tz.setEndRule(Calendar.SEPTEMBER, -6, -Calendar.TUESDAY, 43200000);

    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.AUGUST, 31, Calendar.TUESDAY, 41400000);
    harness.check(off, rawOff + dstOff);
    off = tz.getOffset(GregorianCalendar.AD, 2004, Calendar.AUGUST, 31, Calendar.TUESDAY, 45000000);
    harness.check(off, rawOff);

    // This looks like a Date or DateFormat test, but is here because there was a bug in SimpleTimeZone
    // PR libgcj/8321
    Date date = new Date(1034705556525l);
    TimeZone zone  = TimeZone.getTimeZone("EST");
    DateFormat dateFormat = DateFormat.getDateTimeInstance(
                        DateFormat.SHORT,
                        DateFormat.LONG,
                        Locale.getDefault());
    dateFormat.setTimeZone(zone);
    harness.check("10/15/2002 2:12:36 PM EDT", dateFormat.format(date));
  }
}
