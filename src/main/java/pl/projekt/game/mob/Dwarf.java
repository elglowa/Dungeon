package pl.projekt.game.mob;

import pl.projekt.game.material.AbstractMaterials;
import pl.projekt.game.material.Stone;

import java.util.ArrayList;

public class Dwarf extends AbstractMonster{
        private double healthPoints = 10;
        private double defencePoints = 10;
        private double attacPoints = 5;
        private ArrayList<AbstractMaterials> Inventory;


        public Dwarf(){ }

        public Dwarf(double healthPoints, double defencePoints, double attacPoints){
            this.attacPoints = attacPoints;
            this.defencePoints = defencePoints;
            this.healthPoints = healthPoints;
        }

        @Override
        public void addHP(double HP) {
                super.addHP(HP);
        }

        @Override
        public void addArmour(double armr) {
                super.addArmour(armr);
        }

        @Override
        public void addAttack(double attack) {
                super.addAttack(attack);
        }

        public void collectStone(Stone st){
              //  Inventspr();
                Inventory.add(st);
        }

        public void createDagger(){

        }

}
