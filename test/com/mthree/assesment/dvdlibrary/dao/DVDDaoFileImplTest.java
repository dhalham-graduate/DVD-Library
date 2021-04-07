package com.mthree.assesment.dvdlibrary.dao;

import com.mthree.assesment.dvdlibrary.dto.DVD;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DVDDaoFileImplTest {

    DVDDao testDao;

    @BeforeEach
    void setUp() throws Exception{
        String testFile = "testlibrary.txt";
        new FileWriter(testFile);
        testDao = new DVDDaoFileImpl(testFile);
    }

    @Test
    void testAddAndGetDVD() throws Exception{
        //Arrange
        DVD testDVD = new DVD("Test DVD");
        testDVD.setDirectorName("Test Director");
        testDVD.setMpaaRating(10);
        testDVD.setReleaseDate("2020");
        testDVD.setStudio("Test Studio");
        testDVD.setUserNote("note");

        //Act
        testDao.addDVD("Test DVD", testDVD);
        DVD getDVD = testDao.getDVD("Test DVD");

        //Assert
        assertEquals(testDVD.getDVDId(),getDVD.getDVDId());
        assertEquals(testDVD.getDirectorName(),getDVD.getDirectorName());
        assertEquals(testDVD.getMpaaRating(),getDVD.getMpaaRating());
        assertEquals(testDVD.getReleaseDate(),getDVD.getReleaseDate());
        assertEquals(testDVD.getStudio(),getDVD.getStudio());
        assertEquals(testDVD.getUserNote(),getDVD.getUserNote());
    }

    @Test
    void getAllDVDs() throws Exception{
        //Arrange
        DVD testDVD = new DVD("Test DVD");
        testDVD.setDirectorName("Test Director");
        testDVD.setMpaaRating(10);
        testDVD.setReleaseDate("2020");
        testDVD.setStudio("Test Studio");
        testDVD.setUserNote("note");

        DVD secondTestDVD = new DVD("Second DVD");
        secondTestDVD.setDirectorName("Second Director");
        secondTestDVD.setMpaaRating(9);
        secondTestDVD.setReleaseDate("2019");
        secondTestDVD.setStudio("Second Studio");
        secondTestDVD.setUserNote("Second note");

        //Act
        testDao.addDVD("Test DVD", testDVD);
        testDao.addDVD("Second DVD", secondTestDVD);
        List<DVD> testList = testDao.getAllDVD();

        //Assert
        assertNotNull(testList);
        assertEquals(2, testList.size());
        assertTrue(testList.contains(testDVD));
        assertTrue(testList.contains(secondTestDVD));
    }
}