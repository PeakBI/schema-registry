/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.confluent.connect.json.data;

import org.apache.kafka.connect.errors.DataException;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Schema;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.text.ParseException;

/**
 * <p>
 *     A date representing a calendar day with no time of day or timezone. The corresponding Java type is a java.util.Date
 *     with hours, minutes, seconds, milliseconds set to 0. The underlying representation is an integer representing the
 *     number of standardized days (based on a number of milliseconds with 24 hours/day, 60 minutes/hour, 60 seconds/minute,
 *     1000 milliseconds/second with n) since Unix epoch.
 * </p>
 */
public class Date {
    public static final String LOGICAL_NAME = "org.apache.kafka.connect.data.Date";
    /**
     * Returns a SchemaBuilder for a Date. By returning a SchemaBuilder you can override additional schema settings such
     * as required/optional, default value, and documentation.
     * @return a SchemaBuilder
     */
    public static SchemaBuilder builder() {
      return SchemaBuilder.string()
                .name(LOGICAL_NAME)
                .version(1);
    }

    public static final Schema SCHEMA = builder().schema();

    /**
     * Convert a value from its logical format (Date) to it's encoded format.
     * @param value the logical value
     * @return the encoded value
     */
    public static String fromLogical(Schema schema, java.util.Date value) {
        if (!(LOGICAL_NAME.equals(schema.name())))
            throw new DataException("Requested conversion of Date object but the schema does not match.");
        return value.toString();
    }

    public static String toLogical(Schema schema, String value) {
        if (!(LOGICAL_NAME.equals(schema.name())))
            throw new DataException("Requested conversion of Date object but the schema does not match.");
        return value;
    }
}
