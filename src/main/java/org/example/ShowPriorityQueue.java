package com.dkit.gd2.johnloane;

import org.example.ShowAverageScoreComparator;
import org.example.Shows;

import java.util.PriorityQueue;

public class ShowPriorityQueue
{
    public static void main(String[] args)
    {
        PriorityQueue<Shows> testQueue = new PriorityQueue(new ShowAverageScoreComparator());
        Shows show1 = new Shows(1, "Neon Genesis Evangelion", 1995, "Sci-Fi", "Gainax", 100, 95, 56615);
        show1.setAverageScore(95);
        Shows show2 = new Shows(2, "Cowboy Bebop", 1998, "Sci-Fi", "Sunrise", 98, 96, 61456);
        show2.setAverageScore(96);
        Shows show3 = new Shows(3, "Yu Yu Hakusho", 1992, "Action", "Studio Pierrot", 89, 85, 51894);
        show3.setAverageScore(85);
        Shows show4 = new Shows(4, "Berserk", 1997, "Action", "VAP", 94, 91, 96243);
        show4.setAverageScore(91);
        Shows show5 = new Shows(5, "Samurai Champloo", 2004, "Action", "Sunrise", 87, 92, 26731);
        show5.setAverageScore(92);
        Shows show6 = new Shows(6, "Death Note", 2006, "Drama", "Madhouse", 93, 91, 64237);
        show6.setAverageScore(91);
        Shows show7 = new Shows(7, "One Punch Man", 2015, "Comedy", "Madhouse", 93, 97, 75133);
        show7.setAverageScore(97);
        Shows show8 = new Shows(8, "Steins Gate", 2007, "Drama", "White Fox", 85, 91, 73124);
        show8.setAverageScore(91);
        Shows show9 = new Shows(9, "Jojo's Bizarre Adventure", 2014, "Action", "David Productions", 90, 100, 65154);
        show9.setAverageScore(90);
        Shows show10 = new Shows(10, "Mobile Suit Gundam", 1979, "Mecha", "Sunrise", 95, 93, 1048534);
        show10.setAverageScore(93);

        testQueue.add(show1);
        testQueue.add(show2);
        testQueue.add(show3);
        testQueue.add(show4);
        testQueue.add(show5);
        testQueue.add(show6);
        testQueue.add(show7);
        testQueue.add(show8);
        testQueue.add(show9);
        testQueue.add(show10);
        System.out.println(testQueue);
        System.out.println(testQueue.poll());
        System.out.println(testQueue.poll());
        System.out.println(testQueue.poll());
        System.out.println(testQueue.poll());
        System.out.println(testQueue.poll());
        System.out.println(testQueue.poll());
        System.out.println(testQueue.poll());
        System.out.println(testQueue.poll());
        System.out.println(testQueue.poll());
        System.out.println(testQueue.poll());

    }
}
