package com.example.jchat;

public class Room {

    private String room_id;
    private String roomname;
    private String king_id;
    private String create_time;
    private String capacity;

    public Room(String room_id, String roomname, String king_id, String create_time, String capacity) {
        this.room_id = room_id;
        this.roomname = roomname;
        this.king_id = king_id;
        this.create_time = create_time;
        this.capacity = capacity;
    }

    public Room(String roomname, String create_time, String capacity) {
        this.roomname = roomname;
        this.create_time = create_time;
        this.capacity = capacity;
    }

    public String getRoomId() {
        return this.room_id;
    }

    public String getRoomName() {
        return this.roomname;
    }

    public String getKingId() {
        return this.king_id;
    }

    public String getCreateTime() {
        return this.create_time;
    }

    public String getCapacity() {
        return this.capacity;
    }

}
