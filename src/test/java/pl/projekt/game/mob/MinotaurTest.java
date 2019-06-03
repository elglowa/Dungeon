package pl.projekt.game.mob;

import org.junit.Assert;
import org.junit.Test;
import pl.projekt.game.item.AbstractItem;
import pl.projekt.game.item.Jewelery;
import pl.projekt.game.material.*;

import static org.junit.Assert.*;

public class MinotaurTest {

    AbstractMonster M1 = new Minotaur();
    AbstractMaterials W1 = new Wood();
    AbstractMaterials D1 = new Diamond();

    @Test
    public void collectWood() {
        M1.collectMaterial(M1,W1);
        Assert.assertEquals(1,M1.getWoodnmb(),0);
    }

    @Test
    public void createJewelery() {
        M1.collectMaterial(M1,D1);
        do {
            M1.craftNewItem(M1);
            if(M1.getEquipment().isEmpty()) {}
            else
            { if(M1.getEquipment().get(0).getClass().getName().equals("pl.projekt.game.item.Jewelery")){ break; } }
        }while(true);
        Assert.assertEquals("pl.projekt.game.item.Jewelery",M1.getEquipment().get(0).getClass().getName());
    }
}