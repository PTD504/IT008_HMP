package com.hotel.hotel.response;

import java.time.LocalDate;

public class BookingResponse {
    private Long bookingId;

    private Long roomId;
    private String roomNumber;
    private String roomState;
    private String roomFloor;
    private Double roomPrice;
    private Double roomSize;
    private String roomTypeText;
    private String bedDetailText;
    
    private Long guestId;
    private String guestName;
    private String guestCitizenId;
    private String guestPhone;
    private String guestEmail;
    private LocalDate guestDob;
    private String guestGender;
    private String guestAddress;
    
    private Long staffId;
    private String staffName;
    
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private Boolean isPaid;
    private Double totalPrice;

    public BookingResponse(Long bookingId, Long roomId, String roomNumber, String roomState, String roomFloor, Double roomPrice, Double roomSize, String roomTypeText, String bedDetailText, Long guestId, String guestName, String guestCitizenId, String guestPhone, String guestEmail, LocalDate guestDob, String guestGender, String guestAddress, Long staffId, String staffName, LocalDate checkinDate, LocalDate checkoutDate, Boolean isPaid, Double totalPrice) {
        this.bookingId = bookingId;
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomState = roomState;
        this.roomFloor = roomFloor;
        this.roomPrice = roomPrice;
        this.roomSize = roomSize;
        this.roomTypeText = roomTypeText;
        this.bedDetailText = bedDetailText;
        this.guestId = guestId;
        this.guestName = guestName;
        this.guestCitizenId = guestCitizenId;
        this.guestPhone = guestPhone;
        this.guestEmail = guestEmail;
        this.guestDob = guestDob;
        this.guestGender = guestGender;
        this.guestAddress = guestAddress;
        this.staffId = staffId;
        this.staffName = staffName;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.isPaid = isPaid;
        this.totalPrice = totalPrice;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomState() {
        return roomState;
    }

    public void setRoomState(String roomState) {
        this.roomState = roomState;
    }

    public String getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(String roomFloor) {
        this.roomFloor = roomFloor;
    }

    public Double getRoomPrice() {
        return roomPrice;
    }
    public void setRoomPrice(Double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Double getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Double roomSize) {
        this.roomSize = roomSize;
    }

    public String getRoomTypeText() {
        return roomTypeText;
    }

    public void setRoomTypeText(String roomTypeText) {
        this.roomTypeText = roomTypeText;
    }

    public String getBedDetailText() {
        return bedDetailText;
    }

    public void setBedDetailText(String bedDetailText) {
        this.bedDetailText = bedDetailText;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestCitizenId() {
        return guestCitizenId;
    }

    public void setGuestCitizenId(String guestCitizenId) {
        this.guestCitizenId = guestCitizenId;
    }

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public LocalDate getGuestDob() {
        return guestDob;
    }

    public void setGuestDob(LocalDate guestDob) {
        this.guestDob = guestDob;
    }

    public String getGuestGender() {
        return guestGender;
    }

    public void setGuestGender(String guestGender) {
        this.guestGender = guestGender;
    }

    public String getGuestAddress() {
        return guestAddress;
    }

    public void setGuestAddress(String guestAddress) {
        this.guestAddress = guestAddress;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}