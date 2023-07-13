package com.ank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ANK_Main {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(ANK_Main.class);

        app.setBanner((environment, sourceClass, out) -> out.print(
                "\n" +
                        "                                             \n" +
                        "      _____  _____   ______    ____    ____  \n" +
                        "  ___|\\    \\|\\    \\ |\\     \\  |    |  |    | \n" +
                        " /    /\\    \\\\\\    \\| \\     \\ |    |  |    | \n" +
                        "|    |  |    |\\|    \\  \\     ||    | /    // \n" +
                        "|    |__|    | |     \\  |    ||    |/ _ _//  \n" +
                        "|    .--.    | |      \\ |    ||    |\\    \\'  \n" +
                        "|    |  |    | |    |\\ \\|    ||    | \\    \\  \n" +
                        "|____|  |____| |____||\\_____/||____|  \\____\\ \n" +
                        "|    |  |    | |    |/ \\|   |||    |   |    |\n" +
                        "|____|  |____| |____|   |___|/|____|   |____|\n" +
                        "  \\(      )/     \\(       )/    \\(       )/  \n" +
                        "   '      '       '       '      '       '   \n" +
                        "                                             \n"));
        app.run(args);
    }
}