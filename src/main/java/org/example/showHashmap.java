package org.example;

import java.util.HashMap;

public class showHashmap
{
    public static void main(String[] args)
    {
        HashMap<String, String> Shows = new HashMap<String, String>();

        Shows.put("Gainax", "Neon Genesis Evangelion");
        Shows.put("Sunrise", "Cowboy Bebop");
        Shows.put("Studio Pierrot", "Yu Yu Hakusho");
        Shows.put("VAP", "Berserk");
        Shows.put("Sunrise", "Samurai Champloo");
        Shows.put("Madhouse", "Death Note");
        Shows.put("Madhouse", "One Punch Man");
        Shows.put("White Fox", "Steins Gate");
        Shows.put("David Productions", "Jojo's Bizarre Adventure");
        Shows.put("Sunrise", "Mobile Suit Gundam");
        System.out.println(Shows);
    }
}
