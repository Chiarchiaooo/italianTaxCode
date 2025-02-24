/*
Copyright (c) 2017 Matteo Merola
Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:
The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package me.matteomerola.codicefiscale;

import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@UtilityClass
public class CityParser {

    private static final Map<String, City> CITIES = new HashMap<>();

    public static void init() {
        try (final InputStream INPUT = CityParser.class.getClassLoader().getResourceAsStream("gi_comuni.csv");
             final BufferedReader READER = new BufferedReader(new InputStreamReader(INPUT))) {

            List<String> lines = READER.lines().skip(1).toList();
            for (String line : lines) {
                StringTokenizer st = new StringTokenizer(line, ";");

                String name = st.nextToken().replaceAll("\"", "");

                String alias = st.nextToken().replaceAll("\"", "");
                List<String> aliases = List.of(alias.split("\\/"));

                String province = st.nextToken();
                String code = st.nextToken();

                City city = new City(name, aliases, province, code);
                CITIES.put(code, city);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e); // TODO: aggiungere info su errore nel caricamento del city parser
        }
    }

    public City getCity(String code) {
        return CITIES.getOrDefault(code, null);
    }

    public City getByName(final String name) {
        if (name == null) return null;

        for (Map.Entry<String, City> m : CITIES.entrySet())
            if (m.getValue().getName().equalsIgnoreCase(name)) return m.getValue();

        return null;
    }

    public boolean isCityInDB(String name) {
        return CITIES.containsValue(getByName(name));
    }

    public boolean isCityInDB(final City city) {
        return CITIES.containsValue(city);
    }


    public Set<City> getCities() {
        return new HashSet<>(CITIES.values());
    }
}