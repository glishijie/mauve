// Test for method java.lang.Double.getClass().getDeclaredFields()

// Copyright (C) 2012, 2013, 2014, 2015 Pavel Tisnovsky <ptisnovs@redhat.com>

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
// the Free Software Foundation, Inc., 51 Franklin Street,
// Fifth Floor, Boston, MA 02110-1301 USA.

// Tags: JDK1.5

package gnu.testlet.java.lang.Double.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

import java.lang.Double;
import java.util.Map;
import java.util.HashMap;



/**
 * Test for method java.lang.Double.getClass().getDeclaredFields()
 */
public class getDeclaredFields implements Testlet
{

    /**
     * Runs the test using the specified harness.
     *
     * @param harness  the test harness (<code>null</code> not permitted).
     */
    public void test(TestHarness harness)
    {
        // map of declared fields which should exists
        Map<String, String> testedDeclaredFields = null;

        // map of declared fields for (Open)JDK6
        Map<String, String> testedDeclaredFields_jdk6 = new HashMap<String, String>();

        // map of declared fields for (Open)JDK7
        Map<String, String> testedDeclaredFields_jdk7 = new HashMap<String, String>();

        // map for fields declared in (Open)JDK6
        testedDeclaredFields_jdk6.put("public static final double java.lang.Double.POSITIVE_INFINITY", "POSITIVE_INFINITY");
        testedDeclaredFields_jdk6.put("public static final double java.lang.Double.NEGATIVE_INFINITY", "NEGATIVE_INFINITY");
        testedDeclaredFields_jdk6.put("public static final double java.lang.Double.NaN", "NaN");
        testedDeclaredFields_jdk6.put("public static final double java.lang.Double.MAX_VALUE", "MAX_VALUE");
        testedDeclaredFields_jdk6.put("public static final double java.lang.Double.MIN_NORMAL", "MIN_NORMAL");
        testedDeclaredFields_jdk6.put("public static final double java.lang.Double.MIN_VALUE", "MIN_VALUE");
        testedDeclaredFields_jdk6.put("public static final int java.lang.Double.MAX_EXPONENT", "MAX_EXPONENT");
        testedDeclaredFields_jdk6.put("public static final int java.lang.Double.MIN_EXPONENT", "MIN_EXPONENT");
        testedDeclaredFields_jdk6.put("public static final int java.lang.Double.SIZE", "SIZE");
        testedDeclaredFields_jdk6.put("public static final java.lang.Class java.lang.Double.TYPE", "TYPE");
        testedDeclaredFields_jdk6.put("private final double java.lang.Double.value", "value");
        testedDeclaredFields_jdk6.put("private static final long java.lang.Double.serialVersionUID", "serialVersionUID");

        // map for fields declared in (Open)JDK7
        testedDeclaredFields_jdk7.put("public static final double java.lang.Double.POSITIVE_INFINITY", "POSITIVE_INFINITY");
        testedDeclaredFields_jdk7.put("public static final double java.lang.Double.NEGATIVE_INFINITY", "NEGATIVE_INFINITY");
        testedDeclaredFields_jdk7.put("public static final double java.lang.Double.NaN", "NaN");
        testedDeclaredFields_jdk7.put("public static final double java.lang.Double.MAX_VALUE", "MAX_VALUE");
        testedDeclaredFields_jdk7.put("public static final double java.lang.Double.MIN_NORMAL", "MIN_NORMAL");
        testedDeclaredFields_jdk7.put("public static final double java.lang.Double.MIN_VALUE", "MIN_VALUE");
        testedDeclaredFields_jdk7.put("public static final int java.lang.Double.MAX_EXPONENT", "MAX_EXPONENT");
        testedDeclaredFields_jdk7.put("public static final int java.lang.Double.MIN_EXPONENT", "MIN_EXPONENT");
        testedDeclaredFields_jdk7.put("public static final int java.lang.Double.SIZE", "SIZE");
        testedDeclaredFields_jdk7.put("public static final java.lang.Class java.lang.Double.TYPE", "TYPE");
        testedDeclaredFields_jdk7.put("private final double java.lang.Double.value", "value");
        testedDeclaredFields_jdk7.put("private static final long java.lang.Double.serialVersionUID", "serialVersionUID");

        // create instance of a class Double
        final Object o = new Double(42.0);

        // get a runtime class of an object "o"
        final Class c = o.getClass();

        // get the right map containing declared field signatures
        testedDeclaredFields = getJavaVersion() < 7 ? testedDeclaredFields_jdk6 : testedDeclaredFields_jdk7;

        // get all declared fields for this class
        java.lang.reflect.Field[] declaredFields = c.getDeclaredFields();

        // expected number of declared fields
        final int expectedNumberOfDeclaredFields = testedDeclaredFields.size();

        // basic check for a number of declared fields
        harness.check(declaredFields.length, expectedNumberOfDeclaredFields);

        // check if all fields exist
        for (java.lang.reflect.Field declaredField: declaredFields) {
            String fieldName = declaredField.getName();
            String fieldString = declaredField.toString();
            harness.check(testedDeclaredFields.containsKey(fieldString));
            harness.check(testedDeclaredFields.get(fieldString), fieldName);
        }
    }

    /**
     * Returns version of Java. The input could have the following form: "1.7.0_06"
     * and we are interested only in "7" in this case.
     * 
     * @return Java version
     */
    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

