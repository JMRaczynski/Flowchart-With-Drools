package com.drools.example;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.logger.*;

import javax.swing.*;

/**
 * This is a sample class to launch a rule.
 */
public class Main {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");
            KieRuntimeLogger kLogger = ks.getLoggers().newFileLogger(kSession, "test");

            // go !
            kSession.fireAllRules();
            kLogger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static void createAndShowWelcomingWindow() {
        String[] k = new String[]{"Zaczynajmy!"};
        JOptionPane.showOptionDialog(null, "Witaj! Jeśli chcesz się dowiedzieć, od jakiego gatunku pochodzisz, kliknij przycisk 'Zaczynajmy!', znajdujący się poniżej ;-)",
                "Witamy!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, k, k[0]);
    }

    public static String showQuestion(String question, String[] options) {
        int answerNumber = JOptionPane.showOptionDialog(null, question, "Odpowiedz :-)", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return options[answerNumber];
    }

    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
