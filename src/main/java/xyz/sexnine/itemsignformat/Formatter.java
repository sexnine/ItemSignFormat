package xyz.sexnine.itemsignformat;

record CodePair(String a, String b) {
    public String replace(String string) {
        return string.replace(this.a, this.b);
    }
}

public class Formatter {
    private static final CodePair[] formatters = {
            new CodePair("&k", "§k"),
            new CodePair("&k", "§k"),
            new CodePair("&l", "§l"),
            new CodePair("&m", "§m"),
            new CodePair("&n", "§n"),
            new CodePair("&o", "§o"),
            new CodePair("&r", "§r"),
    };

    private static final CodePair[] colors = {
            new CodePair("&0", "§0"),
            new CodePair("&1", "§1"),
            new CodePair("&2", "§2"),
            new CodePair("&3", "§3"),
            new CodePair("&4", "§4"),
            new CodePair("&5", "§5"),
            new CodePair("&6", "§6"),
            new CodePair("&7", "§7"),
            new CodePair("&8", "§8"),
            new CodePair("&9", "§9"),
            new CodePair("&a", "§a"),
            new CodePair("&b", "§b"),
            new CodePair("&c", "§c"),
            new CodePair("&d", "§d"),
            new CodePair("&e", "§e"),
            new CodePair("&f", "§f"),
    };

    public static String applyFormatting(String string) {
        String temp = string;

        for (CodePair pair : formatters) {
            temp = pair.replace(temp);
        }

        return temp;
    }

    public static String applyColors(String string) {
        String temp = string;

        for (CodePair pair : colors) {
            temp = pair.replace(temp);
        }

        return temp;
    }
}
