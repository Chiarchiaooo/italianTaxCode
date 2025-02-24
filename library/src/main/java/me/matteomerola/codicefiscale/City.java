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


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class City {

    private final String code;

    private String name;
    private List<String> alias;
    private String prov;

    public City(String name, List<String> alias, String prov, String code) {
        this.name = (name == null) ? "" : name;
        this.alias = (alias == null) ? new ArrayList<>() : alias.stream().filter(a -> a != null && !a.isEmpty() && !a.equals(name)).toList();
        this.prov = (prov == null) ? "" : prov;
        this.code = (code == null) ? "" : code;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;

        return Objects.equals(name, city.name) && Objects.equals(prov, city.prov) && Objects.equals(code, city.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prov, code);
    }

    @Override
    public String toString() {

        final String aliases = alias.isEmpty() ? "" : "/" + String.join("/", alias);
        return name + aliases + " (" + prov + ") " + code;
    }

}
