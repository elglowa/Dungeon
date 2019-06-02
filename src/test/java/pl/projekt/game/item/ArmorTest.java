package pl.projekt.game.item;

import org.junit.Assert;
import org.junit.Test;
import pl.projekt.game.mob.*;

public class ArmorTest {
    AbstractMonster M1 = new Dwarf();
    AbstractMonster M2 = new Elf();
    AbstractMonster M3 = new Minotaur();
    AbstractMonster M4 = new Orc();

    AbstractItem A1 = new Armor(M1);
    AbstractItem A2 = new Armor(M2);
    AbstractItem A3 = new Armor(M3);
    AbstractItem A4 = new Armor(M4);


    //FORMUŁA:Parametr Wpisywany+Punkty Statystyk Itemu+Bonus Procentowy

    @Test
    public void addAttack() {
        A1.addAttack(0);
        A2.addAttack(1);
        A3.addAttack(2);
        A4.addAttack(3);

        Assert.assertEquals(5,M1.getAttack(),0); //0+0+0
        Assert.assertEquals(7,M2.getAttack(),0); //1+0+0
        Assert.assertEquals(14,M3.getAttack(),0); //2+0+0
        Assert.assertEquals(10,M4.getAttack(),0); //3+0+0
    }

    @Test
    public void addHP() {
        A1.addHP(0);
        A2.addHP(1);
        A3.addHP(2);
        A4.addHP(3);

        Assert.assertEquals(9.4,M1.getHealth(),0); //0+1+8*5%
        Assert.assertEquals(11.45,M2.getHealth(),0); //1+1+9*5%
        Assert.assertEquals(9.3,M3.getHealth(),0); //2+1+6*5%
        Assert.assertEquals(14.5,M4.getHealth(),0); //3+1+10*5%
    }

    @Test
    public void addArmour() {
        A1.addArmour(0);
        A2.addArmour(1);
        A3.addArmour(2);
        A4.addArmour(3);

        Assert.assertEquals(14.2,M1.getDefence(),0); //0+4+10*2%
        Assert.assertEquals(14.18,M2.getDefence(),0); //1+4+9*2%
        Assert.assertEquals(11.1,M3.getDefence(),0); //2+4+5*2%
        Assert.assertEquals(14.14,M4.getDefence(),0); //3+4+7*2%
    }
}