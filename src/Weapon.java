public class Weapon {
    private String name;
    private CombatType combateType;
    private DamageType damageType;
    private int damage;
    private int speed;
    private int strength;
    private int value;

    public Weapon(String name, CombatType combateType, DamageType damageType, int damage, int speed, int strength, int value) {
        this.name = name;
        this.combateType = combateType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public CombatType getCombateType() {
        return combateType;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStrength() {
        return strength;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCombateType(CombatType combateType) {
        this.combateType = combateType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
