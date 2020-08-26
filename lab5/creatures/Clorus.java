package creatures;

import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

import static huglife.HugLifeUtils.randomEntry;

/**
 * An implementation of a motile pacifist photosynthesizer.
 *
 * @author Josh Hug
 */
public class Clorus extends Creature {

    /**
     * red color.
     */
    private int r;
    /**
     * green color.
     */
    private int g;
    /**
     * blue color.
     */
    private int b;

    /**
     * creates plip with energy equal to E.
     */
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /**
     * creates a plip with energy equal to 1.
     */
    public Clorus() {
        this(1);
    }

    /**
     * Should return a color with red = 99, blue = 76, and green that varies
     * linearly based on the energy of the Plip. If the plip has zero energy,
     * it should have a green value of 63. If it has max energy, it should
     * have a green value of 255. The green value should vary with energy
     * linearly in between these two extremes. It's not absolutely vital
     * that you get this exactly correct.
     */
    public Color color() {
        r = 34;
        g = 0;
        b = 231;
        return color(r, g, b);
    }

    /**
     * Do nothing with C, Plips are pacifists.
     */
    public void attack(Creature c) {

        energy += c.energy();

    }

    /**
     * Plips should lose 0.15 units of energy when moving. If you want to
     * to avoid the magic number warning, you'll need to make a
     * private static final variable. This is not required for this lab.
     */
    public void move() {
        energy -= 0.03;

    }


    /**
     * Plips gain 0.2 energy when staying due to photosynthesis.
     */
    public void stay() {
        energy -= 0.01;

    }

    /**
     * Plips and their offspring each get 50% of the energy, with none
     * lost to the process. Now that's efficiency! Returns a baby
     * Plip.
     */
    public Clorus replicate() {
        Clorus x = new Clorus(this.energy /2 );
        energy /= 2;
        return x;
    }

    /**
     * Plips take exactly the following actions based on NEIGHBORS:
     * 1. If no empty adjacent spaces, STAY.
     * 2. Otherwise, if energy >= 1, REPLICATE towards an empty direction
     * chosen at random.
     * 3. Otherwise, if any Cloruses, MOVE with 50% probability,
     * towards an empty direction chosen at random.
     * 4. Otherwise, if nothing else, STAY
     * <p>
     * Returns an object of type Action. See Action.java for the
     * scoop on how Actions work. See SampleCreature.chooseAction()
     * for an example to follow.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        // Rule 1
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        boolean anyPlip = false;
        // TODO
        int empty = 0;

        for (Map.Entry<Direction, Occupant> entry: neighbors.entrySet()){

            if(entry.getValue().name() != "empty"){
                empty ++;

            }else {
                emptyNeighbors.addFirst(entry.getKey());
                //System.out.println(emptyNeighbors.getFirst());
                continue;
            }


        }
        // (Google: Enhanced for-loop over keys of NEIGHBORS?)
        // for () {...}

        if (empty == 4) {
            return new Action(Action.ActionType.STAY);
        }

        // Rule 2
        Deque<Direction> plip = new ArrayDeque<>();
        for (Map.Entry<Direction, Occupant> entry: neighbors.entrySet()){
            if(entry.getValue().name() == "plip") {
                anyPlip = true;
                plip.addFirst(entry.getKey());
                //return new Action(Action.ActionType.ATTACK,entry.getKey());
            }

        }
        if (anyPlip){
            Direction direction = randomEntry(plip);
            return new Action(Action.ActionType.ATTACK,direction);
        }

        // HINT: randomEntry(emptyNeighbors)

        // Rule 3
        if(energy >= 1) {
            Direction direction = randomEntry(emptyNeighbors);
            return new Action(Action.ActionType.REPLICATE,direction);
        }

        // Rule 4
        return new Action(Action.ActionType.MOVE, randomEntry(emptyNeighbors));
    }
}