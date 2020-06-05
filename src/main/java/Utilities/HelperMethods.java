package Utilities;      //A class that is meant to provide additional methods to use for supporting tests,
                        // such as generating random user names, read from a configuration file, counting and
                        // storing data in variables etc. Inherits from CommonOps class

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class HelperMethods extends CommonOps {

    //GENERAL METHODS

    public static String getDataFromXML(String nodeName) {                  //Reading configuration data from the Config.xml file under Configuration directory
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;

        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        } finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    //DATA GENERATORS - Reading String variables from DataGenerators class

    public static String returnRandomDate() {
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String newDateFormat = dateFormat.format(new Date());
        return newDateFormat;
    }

    public static String returnRandomName() {
        String[] _names = DataGenerators.names.split(" ");
        int randomNum = ThreadLocalRandom.current().nextInt(0, _names.length - 1);
        return _names[randomNum];
    }

    public static String returnRandomFullName() {
        String randomFullName = returnRandomName() + " " + returnRandomName();
        _userName = randomFullName;
        return randomFullName;
    }

    public static String randomEmailGenerator() {
        String randomEmail = returnRandomName() + returnRandomDate() + "@" +
                DataGenerators.emailProviders[ThreadLocalRandom.current().nextInt
                        (0, DataGenerators.emailProviders.length - 1)] + ".com";
        _userEmail = randomEmail;
        return randomEmail;
    }

    public static String returnRandomPassword() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, DataGenerators.numbersAndSymbols.length-1);
            sb.append(DataGenerators.numbersAndSymbols[randomNum]);
        }
        String fullPassword = sb.toString();
        _password = fullPassword;
        return fullPassword;
    }

    public static String returnRandomCompanyName() {
        String[] _companyNames = DataGenerators.companyNames.split(",");
        int randomNum = ThreadLocalRandom.current().nextInt(0, _companyNames.length - 1);
        _companyName = _companyNames[randomNum];
        return _companyNames[randomNum];
    }

    public static String returnRandomThreeDigitNumber() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 9);
            sb.append(DataGenerators.numbersAndSymbols[randomNum]);
        }
        String threeDigitNumber = sb.toString();
        return threeDigitNumber;
    }

}


