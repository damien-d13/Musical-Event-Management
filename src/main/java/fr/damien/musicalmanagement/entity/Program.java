package fr.damien.musicalmanagement.entity;

import java.sql.Time;
import java.util.Date;

public class Program {

    private int groupId;
    private int songId;
    private int meetId;
    private Date programDate;
    private Time programTimeStart;
    private Time programTimeStop;

    public Program(int groupId, int songId, int meetId, Date programDate, Time programTimeStart, Time programTimeStop) {
        this.groupId = groupId;
        this.songId = songId;
        this.meetId = meetId;
        this.programDate = programDate;
        this.programTimeStart = programTimeStart;
        this.programTimeStop = programTimeStop;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getMeetId() {
        return meetId;
    }

    public void setMeetId(int meetId) {
        this.meetId = meetId;
    }

    public Date getProgramDate() {
        return programDate;
    }

    public void setProgramDate(Date programDate) {
        this.programDate = programDate;
    }

    public Time getProgramTimeStart() {
        return programTimeStart;
    }

    public void setProgramTimeStart(Time programTimeStart) {
        this.programTimeStart = programTimeStart;
    }

    public Time getProgramTimeStop() {
        return programTimeStop;
    }

    public void setProgramTimeStop(Time programTimeStop) {
        this.programTimeStop = programTimeStop;
    }

    @Override
    public String toString() {
        return "Program{" +
                "groupId=" + groupId +
                ", songId=" + songId +
                ", meetId=" + meetId +
                ", programDate=" + programDate +
                ", programTimeStart=" + programTimeStart +
                ", programTimeStop=" + programTimeStop +
                '}';
    }


}
