package pl.projekt.simulation;

import org.junit.Assert;
import org.junit.Test;
import pl.projekt.game.mob.AbstractMonster;
import pl.projekt.game.mob.Elf;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void move() {
        Board B1=new Board(5,25);
        B1.createArray();

        B1.move();
        Assert.assertNotEquals(25,B1.getAliveMobs(),0);
    }
}