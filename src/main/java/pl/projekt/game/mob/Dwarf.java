package pl.projekt.game.mob;

import pl.projekt.game.item.AbstractItem;
import pl.projekt.game.item.Dagger;

import java.util.ArrayList;

public class Dwarf extends AbstractMonster{
        private double healthPoints = 10;
        private double defencePoints = 10;
        private double attacPoints = 5;
        private int Woodnmb = 0;
        private int Diamondnmb = 0;
        private int Stonenmb = 0;
        private ArrayList<AbstractItem> Equipment = new ArrayList<AbstractItem>();


        public Dwarf(){ }

        public Dwarf(double healthPoints, double defencePoints, double attacPoints){
            this.attacPoints = attacPoints;
            this.defencePoints = defencePoints;
            this.healthPoints = healthPoints;
        }

        @Override
        public void addHP(double HP) { super.addHP(HP); }

        @Override
        public void addArmour(double armr) { super.addArmour(armr); }

        @Override
        public void addAttack(double attack) { super.addAttack(attack); }

        /**
         * metoda zwiększa ilość posiadanego przez moba kamienia o 1
         */
        public void collectStone(){ Stonenmb++; }

        /**
         * metoda tworzy oraz dodaje do Ekwipunku moba jedną sztukę Młota oraz
         * odejmuje od ilości kawałków drewna oraz kamienia cenę za stworzenie
         * Młota(odpowiednio 2 i 1)
         */
        public void createHammer()
        {
                if(Woodnmb==2 && Stonenmb==1){
                for(int i=0;i<Equipment.size();i++)
                {
                        if(Equipment.get(i) instanceof Dagger)
                                inmb++;
                }
                if(inmb==0)
                {
                        AbstractItem D1=new Dagger(this);
                        Equipment.add(D1);
                        D1.addAttack(0);
                        D1.addArmour(0);
                        D1.addHP(0);
                }
                inmb=0;
                Woodnmb-=2;
                Stonenmb-=1;
                }
        }

}
