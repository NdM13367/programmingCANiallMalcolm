package org.example;

import java.util.Comparator;

public class ShowAverageScoreComparator implements Comparator<Shows>
{
    @Override
    public int compare(Shows p1, Shows p2)
    {
        return p2.getYourScore() - p1.getYourScore();
    }
}
