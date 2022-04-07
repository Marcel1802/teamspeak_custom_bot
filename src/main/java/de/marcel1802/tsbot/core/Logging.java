package de.marcel1802.tsbot.core;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logging {

    public static FileHandler init(Logger logger) {

        try {
            System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT | %4$s | %5$s%n");//"%1$tF %1$tT %4$s %2$s %5$s%6$s%n"
            String s = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).substring(0,19).replace(":","-");
            FileHandler fh;

            Files.createDirectories(Paths.get("logs"));

            fh = new FileHandler("logs/ts3bot_" + s +".log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.setUseParentHandlers(false);

            return fh;
        }
        catch (Exception ex) {
            System.out.println("Cannot create log files.");
            return null;
        }
    }
}
