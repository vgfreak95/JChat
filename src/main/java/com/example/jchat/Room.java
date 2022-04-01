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

    @Override
    public String toString() {
        return this.roomName + " " + this.createTime + " " + this.capacity;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getCapacity() {
        return this.capacity;
    }

    public void setRoomName(String name) {
        this.roomName = name;
    }

    public void setCreateTime(String time) {
        this.createTime = time;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

}
