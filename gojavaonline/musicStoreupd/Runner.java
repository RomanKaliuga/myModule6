package nightglyuk.gojavaonline.musicStoreupd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class Runner {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        MusicStore myMusicStore =  new MusicStore();
        try {
            myMusicStore.initMusicStore();
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }

        Map newOrder = new HashMap<String,Integer>();
        newOrder = myMusicStore.initOrder();


    }
}
