/* ComparisonFailure.java -- Thrown when a string comparison failed
   Copyright (C) 2006 Roman Kennke (kennke@aicas.com)
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

// Tags: not-a-test

package junit.framework;

/**
 * Thrown when a string comparison failed.
 *
 * @see Assert#assertEquals(String, String, String)
 * @see Assert#assertEquals(String, String)
 */
public class ComparisonFailure extends AssertionFailedError
{

  private static final long serialVersionUID = 2747813684729318422L;

  /**
   * Creates a new ComparisonFailure with an error message.
   *
   * @param message the error message
   * @param expected the expected string
   * @param the actual string value
   */
  public ComparisonFailure(String message, String expected, String value)
  {
    super(message);
  }

}
