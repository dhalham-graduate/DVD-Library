package com.mthree.assesment.dvdlibrary.dto;

import java.util.Objects;

/**
 *
 * DVD.java - The data transfer object of the DVD library
 *
 * @author Dhalham Mohamed-Ajaz
 * @version 1.0
 *
 */

public class DVD {
    private String DVDId;
    private String releaseDate;
    private String directorName;
    private float mpaaRating;
    private String studio;
    private String userNote;

    public DVD(String DVDId) {
        this.DVDId = DVDId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDVDId() {
        return DVDId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public float getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(float mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DVD dvd = (DVD) o;
        return Float.compare(dvd.mpaaRating, mpaaRating) == 0 &&
                DVDId.equals(dvd.DVDId) &&
                releaseDate.equals(dvd.releaseDate) &&
                directorName.equals(dvd.directorName) &&
                studio.equals(dvd.studio) &&
                userNote.equals(dvd.userNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DVDId, releaseDate, directorName, mpaaRating, studio, userNote);
    }

    @Override
    public String toString() {
        return "DVD{" +
                "DVDId='" + DVDId + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", directorName='" + directorName + '\'' +
                ", mpaaRating=" + mpaaRating +
                ", studio='" + studio + '\'' +
                ", userNote='" + userNote + '\'' +
                '}';
    }
}
