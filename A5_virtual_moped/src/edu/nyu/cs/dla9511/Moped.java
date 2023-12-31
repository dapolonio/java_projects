package edu.nyu.cs.dla9511;


public class Moped {
      /**
   * The main function is automatically called first in a Java program.
   * It should instantiate a Moped and contain the main logic of the program, following the instructions.
   * 
   * @param args An array of any command-line arguments.
   */ 
    private int[] location;  // [street, avenue]
    private String orientation;
    private double gasLevel; 

    public Moped() {
        location = new int[]{10, 5}; // starting at 10th St and 5th Ave
        orientation = "south";  // facing South
        gasLevel = 1.0;  // start with full gas
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation.toLowerCase();
    }

    public String getOrientation() {
        return orientation;
    }

    public void printLocation() {
        int street = location[0];
        int avenue = location[1];

        // check if there is a location-based ad
        String ad = getLocationAd(street, avenue);

        System.out.printf("Now at %dst St. and %d%s Ave, facing %s. %s%n",
                street, avenue, getAvenueSuffix(avenue), orientation, ad);
    }

    private String getAvenueSuffix(int avenue) {
        if (avenue >= 11 && avenue <= 13) {
            return "th";
        }
        int lastDigit = avenue % 10;
        switch (lastDigit) {
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
            default: return "th";
        }
    }

    private String getLocationAd(int street, int avenue) {
        // advertising based on special locations
        if (street == 79 && avenue == 8) {
            return "Look, The American Museum of Natural History is nearby!";
        } else if (street == 74 && avenue == 1) {
            return "Visit Memorial Sloan Kettering at 74th St. and 1st Ave.";
        } else if (street == 56 && avenue == 3) {
            return "Enjoy delicious Cuban cuisine at Tina’s Cuban Cuisinerestaurant.";
        } else if (street == 12 && avenue == 4) {
            return "Explore The Strand book store at 12th St. and 4th Ave.";
        }
        return ""; // no advertisement if moped not on special location
    }



    public void goLeft() {
        move(0, 1);
    }

    public void goRight() {
        move(0, -1);
    }

    public void goStraight() {
        move(-1, 0);
    }

    public void goBackwards() {
        move(1, 0);
    }

    private void move(int streetChange, int avenueChange) {
        int newStreet = location[0] + streetChange;
        int newAvenue = location[1] + avenueChange;
    
        if (isValidMove(newStreet, newAvenue)) {
            location[0] = newStreet;
            location[1] = newAvenue;
            updateOrientation(streetChange, avenueChange);
            consumeGas();
        } else {
            changeOrientation(streetChange, avenueChange);
        }
    }
    
    private void updateOrientation(int streetChange, int avenueChange) {
        if (streetChange != 0) {
            orientation = (streetChange == 1) ? "north" : "south";
        } else {
            orientation = (avenueChange == 1) ? "west" : "east";
        }
    }

    private boolean isValidMove(int newStreet, int newAvenue) {
        return newStreet >= 1 && newStreet <= 200 && newAvenue >= 1 && newAvenue <= 10;
    }

    private void changeOrientation(int streetChange, int avenueChange) {
        if (streetChange != 0) {
            orientation = (streetChange == 1) ? "north" : "south";
        } else {
            orientation = (avenueChange == 1) ? "west" : "east";
        }
    }

    private void consumeGas() {
        gasLevel -= 0.05; // burn 1/20th of gallon per city block
        if (gasLevel <= 0) {
            System.out.println("We have run out of gas. Bye bye!");
            System.exit(0);
        }
    }

    public int getGasLevel() {
        return (int) (gasLevel * 100);
    }

    public void printGasLevel() {
        if (gasLevel > 0) {
            System.out.printf("The gas tank is currently %d%% full.%n", getGasLevel());
        } else {
            System.out.println("We have run out of gas. Bye bye!");
            System.exit(0);
        }
    }

    public void fillGas() {
        gasLevel = 1.0; // fill gas tank to the maximum
        System.out.println("Gas filled.");
    }

    public void park() {
        System.out.println("We have parked");
        System.exit(0);  // quit the program
    }

    public void goToXianFamousFoods() {
        int destinationStreet = 15;
        int destinationAvenue = 8;

        while (location[0] != destinationStreet || location[1] != destinationAvenue) {
            int streetChange = Integer.compare(destinationStreet, location[0]);
            int avenueChange = Integer.compare(destinationAvenue, location[1]);

            move(streetChange, avenueChange);
        }
        // check if gas needs to be filled during homing
        if (location[0] == destinationStreet && location[1] == destinationAvenue) {
            fillGas();
        }
    }

    public String getHelp() {
        return "List of commands: go left, go right, straight on, back up, how we doin'?, fill it up, park, go to Xi'an Famous Foods, help";
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public int[] getLocation() {
        return location;
    }
}
