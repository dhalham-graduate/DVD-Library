package com.mthree.assesment.dvdlibrary.dao;

import com.mthree.assesment.dvdlibrary.dto.DVD;

import java.io.*;
import java.util.*;

/**
 *
 * DVDDaoFileImplementation.java - File implementation of dao, reads and stores DVDs from a text file
 *
 * @author Dhalham Mohamed-Ajaz
 * @version 1.0
 *
 */

public class DVDDaoFileImpl implements com.mthree.assesment.dvdlibrary.dao.DVDDao {

    private final String ROSTER_FILE;
    public static final String DELIMITER = "::";
    private Map<String, DVD> dvds = new HashMap<>();

    public DVDDaoFileImpl (){
        ROSTER_FILE = "library.txt";
    }

    public DVDDaoFileImpl (String file) {
        ROSTER_FILE = file;
    }

    @Override
    public DVD addDVD(String dvdId, DVD dvd) throws com.mthree.assesment.dvdlibrary.dao.DVDDaoException {
        loadLibrary();
        DVD prevDVD = dvds.put(dvdId, dvd);
        writeLibrary();
        return prevDVD;
    }

    @Override
    public List<DVD> getAllDVD() throws com.mthree.assesment.dvdlibrary.dao.DVDDaoException {
        loadLibrary();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String dvdId) throws com.mthree.assesment.dvdlibrary.dao.DVDDaoException {
        loadLibrary();
        return dvds.get(dvdId);
    }

    @Override
    public DVD removeDVD(String dvdId) throws com.mthree.assesment.dvdlibrary.dao.DVDDaoException {
        loadLibrary();
        DVD removedDVD = dvds.remove(dvdId);
        writeLibrary();
        return removedDVD;
    }

    @Override
    public DVD editDVD(String dvdId) throws com.mthree.assesment.dvdlibrary.dao.DVDDaoException {
        loadLibrary();
        DVD editedDVD = dvds.remove(dvdId);
        writeLibrary();
        return editedDVD;
    }

    @Override
    public void addEditedDVD(String dvdId, DVD newDVD) throws com.mthree.assesment.dvdlibrary.dao.DVDDaoException {
        loadLibrary();
        if (newDVD != null) {
            DVD editedDVD = dvds.put(dvdId, newDVD);
        }
        writeLibrary();
    }

    private DVD unmarshallDVD(String dvdAsText){

        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String title = dvdTokens[0];

        DVD dvdFromFile = new DVD(title);

        dvdFromFile.setReleaseDate(dvdTokens[1]);
        dvdFromFile.setDirectorName(dvdTokens[2]);
        dvdFromFile.setMpaaRating(Float.parseFloat(dvdTokens[3]));
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setUserNote(dvdTokens[5]);

        return dvdFromFile;
    }

    private void loadLibrary() throws com.mthree.assesment.dvdlibrary.dao.DVDDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        }
        catch (FileNotFoundException e) {
            throw new com.mthree.assesment.dvdlibrary.dao.DVDDaoException(
                    "Could not load library data into memory.", e);
        }

        String currentLine;

        DVD currentDVD;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            dvds.put(currentDVD.getDVDId(), currentDVD);
        }

        // close the scanner
        scanner.close();
    }

    private String marshallDVD(DVD aDVD){

        String dvdAsText = aDVD.getDVDId() + DELIMITER;
        dvdAsText += aDVD.getReleaseDate() + DELIMITER;
        dvdAsText += aDVD.getDirectorName() + DELIMITER;
        dvdAsText += aDVD.getMpaaRating() + DELIMITER;
        dvdAsText += aDVD.getStudio() + DELIMITER;
        dvdAsText += aDVD.getUserNote();

        // Return marshalled dvd string
        return dvdAsText;
    }

    private void writeLibrary() throws com.mthree.assesment.dvdlibrary.dao.DVDDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new com.mthree.assesment.dvdlibrary.dao.DVDDaoException("Could not save DVD data.", e);
        }

        List<DVD> dvdList = new ArrayList(dvds.values());

        for (DVD currentDVD : dvdList) {
            out.println(marshallDVD(currentDVD));
            out.flush();
        }
        out.close();
    }

}
