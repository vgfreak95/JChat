package com.example.jchat;

public class Room {

//    private String room_id;
    private String roomName;
//    private String king_id;
    private String createTime;
    private String capacity;

//    public Room(String room_id, String room_name, String king_id, String create_time, String capacity) {
//        this.room_id = room_id;
//        this.room_name = room_name;
//        this.king_id = king_id;
//        this.create_time = create_time;
//        this.capacity = capacity;
//    }

    public Room(String roomName, String create_time, String capacity) {
        this.roomName = roomName;
        this.createTime = create_time;
        this.capacity = capacity;
    }

//    public String getRoomId() {
//        return this.room_id;
//    }

    public String getRoomName() {
        return this.roomName;
    }
//
//    public String getKingId() {
//        return this.king_id;
//    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getCapacity() {
        return this.capacity;
    }

}
