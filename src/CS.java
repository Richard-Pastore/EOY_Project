import javax.swing.ImageIcon;

public class PlayerShip extends Ship {

    public PlayerShip() {
        super();
    }

    public PlayerShip(int xV, int yV, int w, int h) {
        super(xV, yV, new ImageIcon("Player_Ship.png"), w, h);
    }

    public void setX(int x1) {
        super.setX(x1 - super.getX());
    }

    public void setY(int y1) {
        super.setY(y1 - super.getY());
    }

    // Reset method to reset ship's position
    public void reset() {
        // Reset ship's position to initial values
        setX(800); // Initial x-coordinate
        setY(500); // Initial y-coordinate
        // You can reset other attributes here if needed
    }

    // Method to handle missile firing
    public void Missile(int i) {
        // TODO: Implement missile firing logic
    }

    // Method to check if the ship is hit by an alien missile
    public boolean hit(AlienMissile am) {
        if ((am.getY() + am.getH()) > super.getY() && am.getY() < (super.getY() + super.getH())
                && am.getX() < (super.getX() + super.getW()) && (am.getX() + am.getW()) > super.getX()) {
            System.out.println("You lose!!");
            return true;
        }
        return false;
    }
}
