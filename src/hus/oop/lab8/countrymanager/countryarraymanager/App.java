package hus.oop.lab8.countrymanager.countryarraymanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private static final CountryArrayManager countryManager = new CountryArrayManager();
    static Scanner sc = new Scanner(System.in);
    private static int howMany;

    public static void main(String[] args) {
        init();
        insertInformation();

        System.out.println("Original data:");
        testOriginalData();
        System.out.println();

        System.out.println("\nCountries sorted by increasing population:");
        testSortIncreasingByPopulation();
        System.out.println();

        System.out.println("\nCountries sorted by decreasing population:");
        testSortDecreasingByPopulation();
        System.out.println();

        System.out.println("\nCountries sorted by increasing area:");
        testSortIncreasingByArea();
        System.out.println();

        System.out.println("\nCountries sorted by decreasing area:");
        testSortDecreasingByArea();
        System.out.println();

        System.out.println("\nCountries sorted by increasing GDP:");
        testSortIncreasingByGdp();
        System.out.println();

        System.out.println("\nCountries sorted by decreasing GDP:");
        testSortDecreasingByGdp();
        System.out.println();

        System.out.println("\nFilter Africa countries:");
        testFilterAfricaCountry();
        System.out.println();

        System.out.println("\nFilter Asia countries:");
        testFilterAsiaCountry();
        System.out.println();

        System.out.println("\nFilter Europe countries:");
        testFilterEuropeCountry();
        System.out.println();

        System.out.println("\nFilter North America countries:");
        testFilterNorthAmericaCountry();
        System.out.println();

        System.out.println("\nFilter Oceania countries:");
        testFilterOceaniaCountry();
        System.out.println();

        System.out.println("\nFilter South America countries:");
        testFilterSouthAmericaCountry();
        System.out.println();

        System.out.println("\nFilter most populous countries:");
        testFilterMostPopulousCountries();
        System.out.println();

        System.out.println("\nFilter least populous countries:");
        testFilterLeastPopulousCountries();
        System.out.println();

        System.out.println("\nFilter largest area countries:");
        testFilterLargestAreaCountries();
        System.out.println();

        System.out.println("\nFilter smallest area countries:");
        testFilterSmallestAreaCountries();
        System.out.println();

        System.out.println("\nFilter highest GDP countries:");
        testFilterHighestGdpCountries();
        System.out.println();

        System.out.println("\nFilter lowest GDP countries:");
        testFilterLowestGdpCountries();
        /* TODO: write code to test program */
    }

    public static void insertInformation() {
        System.out.print("Enter number of countries to filter: ");
        howMany = sc.nextInt();
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file in java line by line.
            String line;
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);

                if (dataList.get(0).equals("code")) {
                    continue;
                }

                if (dataList.size() != 6) {
                    continue;
                }

                /*
                 * TODO: create Country and append countries into
                 * CountryArrayManager here.
                 */

                String code = dataList.get(0);
                String name = dataList.get(1);
                int population = Integer.parseInt(dataList.get(2));
                double area = Double.parseDouble(dataList.get(3));
                double gdp = Double.parseDouble(dataList.get(4));
                String continent = dataList.get(5);

                Country country = null;
                switch (continent) {
                    case "Africa":
                        country = new AfricaCountry(code, name, population, area, gdp);
                        break;
                    case "Asia":
                        country = new AsiaCountry(code, name, population, area, gdp);
                        break;
                    case "EuropeC":
                        country = new EuropeCountry(code, name, population, area, gdp);
                        break;
                    case "North America":
                        country = new NorthAmericaCountry(code, name, population, area, gdp);
                        break;
                    case "Oceania":
                        country = new OceaniaCountry(code, name, population, area, gdp);
                        break;
                    case "South AmericaC":
                        country = new SouthAmericaCountry(code, name, population, area, gdp);
                        break;
                }
                if (country != null) {
                    countryManager.append(country);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null) {
                    dataReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }

        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void init() {
        String filePath = "C:\\Users\\Dell\\eclipse-workspace\\OOP_ki_2\\" +
                "src\\hus\\oop\\lab8\\countrymanager\\data\\countries.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        String codesString = CountryArrayManager.codeOfCountriesToString(countryManager.getCountries());
        System.out.print(codesString);
    }

    public static void testSortIncreasingByPopulation() {
        Country[] countries = countryManager.sortByIncreasingPopulation();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.print(codesString);
    }

    public static void testSortDecreasingByPopulation() {
        Country[] countries = countryManager.sortByDecreasingPopulation();
        countryManager.print(countries);
    }

    public static void testSortIncreasingByArea() {
        Country[] countries = countryManager.sortByIncreasingArea();
        countryManager.print(countries);
    }

    public static void testSortDecreasingByArea() {
        Country[] countries = countryManager.sortByDecreasingArea();
        countryManager.print(countries);
    }

    public static void testSortIncreasingByGdp() {
        Country[] countries = countryManager.sortByIncreasingGdp();
        countryManager.print(countries);
    }

    public static void testSortDecreasingByGdp() {
        Country[] countries = countryManager.sortByDecreasingGdp();
        countryManager.print(countries);
    }


    public static void testFilterAfricaCountry() {
        AfricaCountry[] africaCountries = countryManager.filterAfricaCountry();
        countryManager.print(africaCountries);
    }

    public static void testFilterAsiaCountry() {
        AsiaCountry[] asiaCountries = countryManager.filterAsiaCountry();
        countryManager.print(asiaCountries);
    }

    public static void testFilterEuropeCountry() {
        EuropeCountry[] europeCountries = countryManager.filterEuropeCountry();
        countryManager.print(europeCountries);
    }

    public static void testFilterNorthAmericaCountry() {
        NorthAmericaCountry[] northAmericaCountries = countryManager.filterNorthAmericaCountry();
        countryManager.print(northAmericaCountries);
    }

    public static void testFilterOceaniaCountry() {
        OceaniaCountry[] oceaniaCountries = countryManager.filterOceaniaCountry();
        countryManager.print(oceaniaCountries);
    }

    public static void testFilterSouthAmericaCountry() {
        SouthAmericaCountry[] southAmericaCountries = countryManager.filterSouthAmericaCountry();
        countryManager.print(southAmericaCountries);
    }

    public static void testFilterMostPopulousCountries() {
        Country[] countries = countryManager.filterMostPopulousCountries(howMany);
        countryManager.print(countries);
    }

    public static void testFilterLeastPopulousCountries() {
        Country[] countries = countryManager.filterLeastPopulousCountries(howMany);
        countryManager.print(countries);
    }

    public static void testFilterLargestAreaCountries() {
        Country[] countries = countryManager.filterLargestAreaCountries(howMany);
        countryManager.print(countries);
    }

    public static void testFilterSmallestAreaCountries() {
        Country[] countries = countryManager.filterSmallestAreaCountries(howMany);
        countryManager.print(countries);
    }

    public static void testFilterHighestGdpCountries() {
        Country[] countries = countryManager.filterHighestGdpCountries(howMany);
        countryManager.print(countries);
    }

    public static void testFilterLowestGdpCountries() {
        Country[] countries = countryManager.filterLowestGdpCountries(howMany);
        countryManager.print(countries);
    }
}
