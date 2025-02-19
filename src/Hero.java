public class Hero {
    private String name;
    private int hitPoints;

    public Hero(String name) {
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void attack(Hero opponent) {
        int damage = (int)(Math.random() * 10) + 1;
        opponent.hitPoints -= damage;
        if (opponent.hitPoints < 0) {
            opponent.hitPoints = 0;
        }
    }

    public void fightUntilTheDeath(Hero opponent) {
        fightUntilTheDeathHelper(opponent);
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            this.attack(opponent);
            if (opponent.hitPoints > 0) {
                opponent.attack(this);
            }
        }
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        return nFightsToTheDeathHelper(opponent, n);
    }

    private String nFightsToTheDeathHelper(Hero opponent, int n) {
        int hero1Wins = 0;
        int hero2Wins = 0;

        for (int i = 0; i < n; i++) {

            fightUntilTheDeath(opponent);

            if (this.hitPoints > 0) {
                hero1Wins++;
            } else {
                hero2Wins++;
            }

            // Reset hitPoints for next fight
            this.senzuBean();
            opponent.senzuBean();
        }

        return this.name + ": " + hero1Wins + " wins\n" +
                opponent.name + ": " + hero2Wins + " wins";
    }

    public void senzuBean() {
        this.hitPoints = 100;
    }

    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }

    public void dramaticFightToTheDeath(Hero opponent) {
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            // First hero attacks
            this.attack(opponent);
            System.out.println(this.getName() + ": " + this.getHitPoints() + "\t" +
                    opponent.getName() + ": " + opponent.getHitPoints());


            // Second hero attacks if still alive
            if (opponent.hitPoints > 0) {
                opponent.attack(this);
                System.out.println(this.getName() + ": " + this.getHitPoints() + "\t" +
                        opponent.getName() + ": " + opponent.getHitPoints());
            }
        }
    }

}