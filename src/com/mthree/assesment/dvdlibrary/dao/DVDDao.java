package com.mthree.assesment.dvdlibrary.dao;

import com.mthree.assesment.dvdlibrary.dto.DVD;

import java.util.List;

/**
 *
 * DVDDao.java - Data access object interface
 *
 * @author Dhalham Mohamed-Ajaz
 * @version 1.0
 *
 */

public interface DVDDao {

    DVD addDVD(String dvdId, DVD dvd) throws com.mthree.assesment.dvdlibrary.dao.DVDDaoException;

    // Returns a list of all the DVD's in the library
    List<DVD> getAllDVD() throws com.mthree.assesment.dvdlibrary.dao.DVDDaoException;

    // Returns DVD object for a given title, returns null if DVD does not exist
    DVD getDVD(String dvdId) throws com.mthree.assesment.dvdlibrary.dao.DVDDaoException;

    // Removes a DVD from library when given title
    DVD removeDVD(String dvdId) throws com.mthree.assesment.dvdlibrary.dao.DVDDaoException;

    // Edits a DVD when given title
    DVD editDVD(String dvdId) throws com.mthree.assesment.dvdlibrary.dao.DVDDaoException;

    // Adds an edited DVD to the library
    void addEditedDVD(String dvdId, DVD newDVD) throws com.mthree.assesment.dvdlibrary.dao.DVDDaoException;
}

