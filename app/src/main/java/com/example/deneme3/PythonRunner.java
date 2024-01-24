import org.python.util.PythonInterpreter;

import java.util.Arrays;
package com.example.deneme3;

public class PythonRunner {
    public static void runPythonScriptWithArgs(String script, String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();

        // Python betiğine argümanları iletme
        interpreter.exec(String.format("import sys\nsys.argv = %s", Arrays.toString(args)));

        // Python betiğini çalıştırma
        interpreter.execfile(script);

        // Python betiğinden bir sonuç almak için bir değişken
        String pythonSonucu = interpreter.getLocals().get("__result__").toString();

        // Elde edilen sonucu döndürme
        return pythonSonucu;
    }
}
