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
package me.matteomerola.codicefiscale.exceptions;

import me.matteomerola.codicefiscale.City;

public class NotSuchCityException extends Exception {

    public NotSuchCityException() {
        super("The city name you specified is not a valid city name nor a country name.");
    }

    public NotSuchCityException(City city) {
        super("The city name you specified is not a valid city name nor a country named " + city);
    }

    public NotSuchCityException(String city) {
        super("The city name you specified is not a valid city name nor a country named " + city);
    }

    public NotSuchCityException(Exception e) {
        super("Cannot retrieve the city/country's info due to an error: " + e.getMessage());
    }
}
