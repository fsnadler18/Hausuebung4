import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();

    public void readFile() throws IOException {
        weapons = (ArrayList<Weapon>) Files.lines(new File("C:\\HTL\\3.Klasse\\POS1\\Random Files\\Weapons.csv").toPath())
                .skip(1)
                .map(s -> s.split(";"))
                .map(s -> new Weapon(
                        s[0],
                        CombatType.valueOf(s[1]),
                        DamageType.valueOf(s[2]),
                        Integer.parseInt(s[3]),
                        Integer.parseInt(s[4]),
                        Integer.parseInt(s[5]),
                        Integer.parseInt(s[6])
                ))
                .collect(Collectors.toList());
    }

    public void sortAfterDamage() {
        weapons.sort((a, b) -> {
            return a.getDamage() - b.getDamage();
        });
    }

    public void sortAfterMultiple() {
        weapons.sort((a, b) -> {
            if (a.getCombateType().compareTo(b.getCombateType()) != 0)
                return a.getCombateType().compareTo(b.getCombateType());
            if (a.getDamageType().compareTo(b.getDamageType()) != 0)
                return a.getDamageType().compareTo(b.getDamageType());
            return a.getName().compareTo(b.getName());
        });
    }

    public void print(List<Weapon> weapons) {
        sortAfterMultiple();
        Printable pr = (weaponList) -> {
            for (Weapon wp : weaponList) {
                System.out.println(wp.getName() + " " + wp.getCombateType() + " " + wp.getDamageType() + " " + wp.getDamage() + " " + wp.getSpeed() + " " + wp.getStrength() + " " + wp.getValue());
            }
        };
    }

    public void printAllAsTable() {
        sortAfterMultiple();
        Printable print = (weaponList) -> {
            String format = "| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s| %n";

            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.format(format, "Name", "CombatType", "DamageType", "Damage", "Speed", "Strength", "value");

            for (Weapon w : weapons) {
                System.out.println("-----------------------+----------------------+----------------------+----------------------+----------------------+----------------------+----------------------");
                System.out.format(format, w.getName(), w.getCombateType(), w.getDamageType(), w.getDamage(), w.getSpeed(), w.getStrength(), w.getValue());
            }

            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        };
        print.print(weapons);

    }

}
