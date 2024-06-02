package hus.oop.lab8.countrymanager.countryarraymanager;

import java.util.ArrayList;
import java.util.List;

public class CountryArrayManager {
    private Country[] countries;
    private int length;

    public CountryArrayManager() {
        countries = new Country[1];
        this.length = 0;
    }

    public CountryArrayManager(int maxLength) {
        countries = new Country[maxLength];
        this.length = 0;
    }

    public int getLength() {
        return this.length;
    }

    public Country[] getCountries() {
        return this.countries;
    }

    private void correct() {
        int nullFirstIndex = 0;
        for (int i = 0; i < this.countries.length; i++) {
            if (this.countries[i] == null) {
                nullFirstIndex = i;
                break;
            }
        }

        if (nullFirstIndex > 0) {
            this.length = nullFirstIndex;
            for (int i = nullFirstIndex; i < this.countries.length; i++) {
                this.countries[i] = null;
            }
        }
    }

    private void allocateMore() {
        Country[] newArray = new Country[2 * this.countries.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.countries.length);
        this.countries = newArray;
    }

    public void append(Country country) {
        if (this.length >= this.countries.length) {
            allocateMore();
        }

        this.countries[this.length] = country;
        this.length++;
    }

    public boolean add(Country country, int index) {
        if ((index < 0) || (index > this.countries.length)) {
            return false;
        }

        if (this.length >= this.countries.length) {
            allocateMore();
        }

        for (int i = this.length; i > index; i--) {
            this.countries[i] = this.countries[i - 1];
        }

        this.countries[index] = country;
        this.length++;
        return true;
    }

    public boolean remove(int index) {
        if ((index < 0) || (index >= countries.length)) {
            return false;
        }

        for (int i = index; i < length - 1; i++) {
            this.countries[i] = this.countries[i + 1];
        }

        this.countries[this.length - 1] = null;
        this.length--;
        return true;
    }

    public Country countryAt(int index) {
        if ((index < 0) || (index >= this.length)) {
            return null;
        }

        return this.countries[index];
    }

    /**
     * Sort the countries in order of increasing population
     * using selection sort algorithm.
     *
     * @return array of increasing population countries.
     */
    public Country[] sortByIncreasingPopulation() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        /* TODO */
        int newArrayLength = newArray.length;
        for (int i = 0; i < newArrayLength - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < newArrayLength; j++) {
                if (newArray[minIndex].getPopulation() > newArray[j].getPopulation()) {
                    minIndex = j;
                }
            }
            Country temp = newArray[minIndex];
            newArray[minIndex] = newArray[i];
            newArray[i] = temp;
        }

        return newArray;
    }

    /**
     * Sort the countries in order of decreasing population
     * using selection sort algorithm.
     * * @return array of decreasing population countries.
     */
    public Country[] sortByDecreasingPopulation() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        /* TODO */
        int newArrayLength = newArray.length;
        for (int i = 0; i < newArrayLength - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < newArrayLength; j++) {
                if (newArray[maxIndex].getPopulation() < newArray[j].getPopulation()) {
                    maxIndex = j;
                }
            }
            Country temp = newArray[maxIndex];
            newArray[maxIndex] = newArray[i];
            newArray[i] = temp;
        }

        return newArray;
    }

    /**
     * Sort the countries in order of increasing area
     * using bubble sort algorithm.
     *
     * @return array of increasing area countries.
     */
    public Country[] sortByIncreasingArea() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        /* TODO */
        int newArrayLength = newArray.length;
        for (int i = 0; i < newArrayLength - 1; i++) {
            for (int j = 0; j < newArrayLength - i - 1; j++) {
                if (newArray[j].getArea() > newArray[j + 1].getArea()) {
                    Country temp = newArray[j];
                    newArray[j] = newArray[j + 1];
                    newArray[j + 1] = temp;
                }
            }
        }

        return newArray;
    }

    /**
     * Sort the countries in order of decreasing area
     * using bubble sort algorithm.
     *
     * @return array of increasing area countries.
     */
    public Country[] sortByDecreasingArea() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        /* TODO */
        int newArrayLength = newArray.length;
        for (int i = 0; i < newArrayLength - 1; i++) {
            for (int j = 0; j < newArrayLength - i - 1; j++) {
                if (newArray[j].getArea() < newArray[j + 1].getArea()) {
                    Country temp = newArray[j];
                    newArray[j] = newArray[j + 1];
                    newArray[j + 1] = temp;
                }
            }
        }

        return newArray;
    }

    /**
     * Sort the countries in order of increasing GDP
     * using insertion sort algorithm.
     *
     * @return array of increasing GDP countries.
     */
    public Country[] sortByIncreasingGdp() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        /* TODO */
        int newArrayLength = newArray.length;
        for (int i = 1; i < newArrayLength; i++) {
            Country key = newArray[i];
            int index = i - 1;
            while (index >= 0 && key.getGdp() < newArray[index].getGdp()) {
                newArray[index + 1] = newArray[index];
                index--;
            }
            newArray[index + 1] = key;
        }

        return newArray;
    }

    /**
     * Sort the countries in order of increasing GDP
     * sing insertion sort algorithm.
     *
     * @return array of increasing insertion countries.
     */
    public Country[] sortByDecreasingGdp() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        /* TODO */
        int newArrayLength = newArray.length;
        for (int i = 1; i < newArrayLength; i++) {
            Country key = newArray[i];
            int index = i - 1;
            while (index >= 0 && key.getGdp() > newArray[index].getGdp()) {
                newArray[index + 1] = newArray[index];
                index--;
            }
            newArray[index + 1] = key;
        }

        return newArray;
    }

    public AfricaCountry[] filterAfricaCountry() {
        /* TODO */
        List<Country> africaCountries = new ArrayList<>();
        for (Country country : countries) {
            if (country instanceof AfricaCountry) {
                AfricaCountry africaCountry = (AfricaCountry) country;
                africaCountries.add(africaCountry);
            }
        }

        AfricaCountry africaCountry[] = africaCountries.toArray(new AfricaCountry[0]);

        return africaCountry;
    }

    public AsiaCountry[] filterAsiaCountry() {
        /* TODO */
        List<AsiaCountry> asiaCountries = new ArrayList<>();
        for (Country country : countries) {
            if (country instanceof AsiaCountry) {
                asiaCountries.add((AsiaCountry) country);
            }
        }

        AsiaCountry asiaCountry[] = asiaCountries.toArray(new AsiaCountry[0]);

        return asiaCountry;
    }

    public EuropeCountry[] filterEuropeCountry() {
        /* TODO */
        List<EuropeCountry> europeCountries = new ArrayList<>();
        for (Country country : countries) {
            if (country instanceof EuropeCountry) {
                europeCountries.add((EuropeCountry) country);
            }
        }

        EuropeCountry europeCountry[] = europeCountries.toArray(new EuropeCountry[0]);

        return europeCountry;
    }

    public NorthAmericaCountry[] filterNorthAmericaCountry() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        List<NorthAmericaCountry> northAmericaCountry = new ArrayList<>();
        for (Country country : newArray) {
            if (country instanceof NorthAmericaCountry) {
                northAmericaCountry.add((NorthAmericaCountry) country);
            }
        }
        NorthAmericaCountry[] result = new NorthAmericaCountry[northAmericaCountry.size()];
        return northAmericaCountry.toArray(result);
        /* TODO */
    }

    public OceaniaCountry[] filterOceaniaCountry() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        List<OceaniaCountry> oceaniaCountry = new ArrayList<>();
        for (Country country : newArray) {
            if (country instanceof OceaniaCountry) {
                oceaniaCountry.add((OceaniaCountry) country);
            }
        }
        OceaniaCountry[] result = new OceaniaCountry[oceaniaCountry.size()];
        return oceaniaCountry.toArray(result);
        /* TODO */
    }

    public SouthAmericaCountry[] filterSouthAmericaCountry() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        List<SouthAmericaCountry> southAmericaCountry = new ArrayList<>();
        for (Country country : newArray) {
            if (country instanceof SouthAmericaCountry) {
                southAmericaCountry.add((SouthAmericaCountry) country);
            }
        }
        SouthAmericaCountry[] result = new SouthAmericaCountry[southAmericaCountry.size()];
        return southAmericaCountry.toArray(result);
        /* TODO */
    }

    public Country[] filterMostPopulousCountries(int howMany) {
        /* TODO */
        Country sortedDecreasingPopulous[] = sortByDecreasingPopulation();
        Country mostPopulousCountries[] = new Country[Math.min(sortedDecreasingPopulous.length, howMany)];

        for (int i = 0; i < mostPopulousCountries.length; i++) {
            mostPopulousCountries[i] = sortedDecreasingPopulous[i];
        }

        return mostPopulousCountries;
    }

    public Country[] filterLeastPopulousCountries(int howMany) {
        /* TODO */
        Country sortedIncreasingPopulous[] = sortByIncreasingPopulation();
        Country leastPopulousCountries[] = new Country[Math.min(howMany, sortedIncreasingPopulous.length)];

        for (int i = 0; i < leastPopulousCountries.length; i++) {
            leastPopulousCountries[i] = sortedIncreasingPopulous[i];
        }

        return leastPopulousCountries;
    }

    public Country[] filterLargestAreaCountries(int howMany) {
        /* TODO */
        Country sortedDecreasingArea[] = sortByDecreasingArea();
        Country largestAreaCountries[] = new Country[Math.min(howMany, sortedDecreasingArea.length)];

        for (int i = 0; i < largestAreaCountries.length; i++) {
            largestAreaCountries[i] = sortedDecreasingArea[i];
        }

        return largestAreaCountries;
    }

    public Country[] filterSmallestAreaCountries(int howMany) {
        /* TODO */
        Country sortedByIncreasingArea[] = sortByIncreasingArea();
        Country smallestAreaCountries[] = new Country[Math.min(howMany, sortedByIncreasingArea.length)];

        for (int i = 0; i < smallestAreaCountries.length; i++) {
            smallestAreaCountries[i] = sortedByIncreasingArea[i];
        }

        return smallestAreaCountries;
    }

    public Country[] filterHighestGdpCountries(int howMany) {
        /* TODO */
        Country sortedByDecreasingGdp[] = sortByDecreasingGdp();
        Country highestGdpCountries[] = new Country[Math.min(howMany, sortedByDecreasingGdp.length)];

        for (int i = 0; i < highestGdpCountries.length; i++) {
            highestGdpCountries[i] = sortedByDecreasingGdp[i];
        }

        return highestGdpCountries;
    }

    public Country[] filterLowestGdpCountries(int howMany) {
        /* TODO */
        Country sortedByIncreasingGdp[] = sortByIncreasingGdp();
        Country lowestGdpCountries[] = new Country[Math.min(howMany, sortedByIncreasingGdp.length)];

        for (int i = 0; i < lowestGdpCountries.length; i++) {
            lowestGdpCountries[i] = sortedByIncreasingGdp[i];
        }

        return lowestGdpCountries;
    }

    public static String codeOfCountriesToString(Country[] countries) {
        StringBuilder codeOfCountries = new StringBuilder();
        codeOfCountries.append("[");
        for (int i = 0; i < countries.length; i++) {
            Country country = countries[i];
            if (country != null) {
                codeOfCountries.append(country.getCode())
                        .append(" ");
            }
        }

        return codeOfCountries.toString().trim() + "]";
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < length; i++) {
            if (countries[i] != null) {
                result.append(countries[i].getName())
                        .append(", Population: ")
                        .append(countries[i].getPopulation())
                        .append(", Area: ")
                        .append(countries[i].getArea())
                        .append(", GDP: ")
                        .append(countries[i].getGdp())
                        .append("\n");
            }
        }
        if (result.length() > 1) {
            result.deleteCharAt(result.length() - 1);
        }
        result.append("]");
        return String.valueOf(result);
    }

    public static void print(Country[] countries) {
        StringBuilder countriesString = new StringBuilder();
        countriesString.append("[");
        for (int i = 0; i < countries.length; i++) {
            Country country = countries[i];
            if (country != null) {
                countriesString.append(country.toString()).append("\n");
            }
        }
        System.out.print(countriesString.toString().trim() + "]");
    }
}
