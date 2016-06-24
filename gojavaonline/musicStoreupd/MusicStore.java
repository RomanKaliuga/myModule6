package nightglyuk.gojavaonline.musicStoreupd;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class MusicStore {
    public List<Instrument> instruments;
    Scanner scanner=new Scanner(System.in);
    public List<Instrument> prepareInstruments(Map<String, Integer> order) {
        for (int i = 0; i < instruments.size(); i++) {
            for (Map.Entry<String, Integer> entry : order.entrySet()) {
                if ((entry.getKey().equals(this.instruments.get(i).getName())) && (entry.getValue() > this.instruments.get(i).getAmount()))
                    try {
                        throw new NotEnoughAmountException(entry.getValue());
                    } catch (NotEnoughAmountException e) {
                        System.out.println("not enough" + entry.getKey() + "instruments at the store");
                    }
                else {
                    this.instruments.get(i).setAmount(this.instruments.get(i).getAmount() - entry.getValue());
                }

            }
        }
        return this.instruments;
    }
    public List<Instrument> initMusicStore () throws NegativeAmountException {

        /** инициализация магазина */
        MusicStore myMusicStore = new MusicStore();

        myMusicStore.instruments = Arrays.asList(guitar,pianos,trumpet);
        System.out.println("input number of guitars");

        myMusicStore.instruments.get(0).setName("guitar");
        myMusicStore.instruments.get(0).setAmount(scanner.nextInt());
        if (myMusicStore.instruments.get(0).getAmount()<0) {
            try {
                throw new NegativeAmountException(myMusicStore.instruments.get(0).getAmount());
            } catch (NegativeAmountException ex) {
                System.out.println("Amount of guitars shouldn't be negative");
            }
        }

        System.out.println("input number of pianos");
        myMusicStore.instruments.get(1).setName("piano");
        myMusicStore.instruments.get(1).setAmount(scanner.nextInt());
        if (myMusicStore.instruments.get(1).getAmount()<0) {
            try {
                throw new NegativeAmountException(myMusicStore.instruments.get(1).getAmount());
            } catch (NegativeAmountException ex) {
                System.out.println("Amount of pianos shouldn't be negative");
            }
        }

        System.out.println("input number of trumpet");
        myMusicStore.instruments.get(2).setName("trumpet");
        myMusicStore.instruments.get(2).setAmount(scanner.nextInt());
        if (myMusicStore.instruments.get(2).getAmount()<0) {
            try {
                throw new NegativeAmountException(myMusicStore.instruments.get(2).getAmount());
            } catch (NegativeAmountException ex) {
                System.out.println("Amount of trumpets shouldn't be negative");
            }
        }
        return myMusicStore.instruments;
    }
    /** инициализация заказа*/
    public Map<String,Integer> initOrder(){
        Map order = new HashMap<String,Integer>();
        System.out.println("input number of instrument names");
        int instrumentAmount =scanner.nextInt();
        for (int i = 0; i< instrumentAmount; i++) {
            System.out.println("input instrument name");
            String tempString = scanner.next();
            System.out.println("input amount of this instrument in order");
            int tempAmount=scanner.nextInt();
            if (tempAmount<=0) try {
                throw new NegativeAmountException(tempAmount);
            } catch (NegativeAmountException e) {
                System.out.println("you can't order less then 1 instrument");
            } else {
                if ((tempString!="piano")||(tempString!="trumpet")||(tempString!="guitar")) try {
                    throw new WrongInstrumentException(tempString);
                } catch (WrongInstrumentException e) {
                    System.out.println("there is no such instrument at the store");
                }else{
                    order.put(tempString,tempAmount);
                }
            }
        }
        return order;
    }
}


