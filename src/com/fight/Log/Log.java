package com.fight.Log;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    public static void logUserHero(String userHeroString) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
        String filePath = "logs/" + dateFormat.format(date) + ".txt";

        try {
            File file = new File(filePath);

            if (!file.exists()) {
                File parentDir = file.getParentFile();

                if (!parentDir.exists()) {
                    parentDir.mkdir();
                }

                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);

            fw.write(timeFormat.format(date) + " User started with a hero: \n" + userHeroString + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
