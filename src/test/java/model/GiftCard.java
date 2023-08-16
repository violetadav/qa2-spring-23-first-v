package model;

import java.math.BigDecimal;

public class GiftCard {
    private BigDecimal giftCardValue;
    private int quantity;
    private String recipientFirstName;
    private String recipientLastName;
    private String commentWishes;
    private String recipientEmailAddress;
    private long phoneNumber;

    public BigDecimal getGiftCardValue() {
        return giftCardValue;
    }

    public void setGiftCardValue(BigDecimal giftCardValue) {
        this.giftCardValue = giftCardValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRecipientFirstName() {
        return recipientFirstName;
    }

    public void setRecipientFirstName(String recipientFirstName) {
        this.recipientFirstName = recipientFirstName;
    }

    public String getRecipientLastName() {
        return recipientLastName;
    }

    public void setRecipientLastName(String recipientLastName) {
        this.recipientLastName = recipientLastName;
    }

    public String getCommentWishes() {
        return commentWishes;
    }

    public void setCommentWishes(String commentWishes) {
        this.commentWishes = commentWishes;
    }

    public String getRecipientEmailAddress() {
        return recipientEmailAddress;
    }

    public void setRecipientEmailAddress(String recipientEmailAddress) {
        this.recipientEmailAddress = recipientEmailAddress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void printFullName(){
        System.out.println(recipientFirstName + " " + recipientLastName);
    }

    public void printValueAndQuantity(){
        System.out.println(giftCardValue + "x" + quantity);
    }
}
