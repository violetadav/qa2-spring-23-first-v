import model.Address;
import model.GiftCard;
import model.HairDryer;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class HomeWorkTestObjects {
    @Test
    public void creatingAndUsingObjectsForHomeWork() {
        Address home = new Address();
        home.setCountry("Latvia");
        home.setCity("Riga");
        home.setStreet("Brivibas iela");
        home.setHouseNumber(123);
        home.setFlatNumber(45);
        home.setPostalCode(1010);
        home.setPhoneNumber(987654321);

        GiftCard birthdayGift = new GiftCard();
        birthdayGift.setRecipientFirstName("Anna");
        birthdayGift.setRecipientLastName("Prieciga");
        birthdayGift.setGiftCardValue(new BigDecimal("50.10"));
        birthdayGift.setQuantity(5);
        birthdayGift.setCommentWishes("Daudz laimes dzimsanas diena!");
        birthdayGift.setRecipientEmailAddress("anna.prieciga@svetki.lv");
        birthdayGift.setPhoneNumber(123456789);

        HairDryer fen = new HairDryer();
        fen.setBrand("Kitay");
        fen.setModel("NZ-12");
        fen.setPower(1200);
        fen.setTempControl(3);
        fen.setNumberOfSpeeds(4);
        fen.setNumberOfNozzles(6);
        fen.setWireLength(2);

        home.printLocality();
        home.printAdress();
        System.out.println(home.getPostalCode());
        System.out.println(home.getPhoneNumber());

        birthdayGift.printFullName();
        System.out.println(birthdayGift.getCommentWishes());
        birthdayGift.printValueAndQuantity();
        System.out.println(birthdayGift.getRecipientEmailAddress());
        System.out.println(birthdayGift.getPhoneNumber());

        fen.printProductName();
        fen.printTechnicalSpecifications();
    }

}
