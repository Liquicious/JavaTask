package org.example;

import java.lang.reflect.Field;
import java.lang.management.ManagementFactory;

public class FieldGenerator {
    private static long m = (long)Math.pow(2, 31);
    private static long a = 1103515245;
    private static long c = 12345;
    private long seed;
    public FieldGenerator()
    {
        this.seed = ManagementFactory.getRuntimeMXBean().getStartTime();
    }
    private void updateSeed()
    {
        seed = (a * seed + c) % m;
    }
    public <T> void generateFields(T inputClass)
    {
        Field[] classFields = inputClass.getClass().getDeclaredFields();
        for (Field classField : classFields)
        {
            try
            {
                classField.setAccessible(true);
                // boolean, byte, short, int , long, double, float, char, string
                if (classField.getType().equals(boolean.class))
                {
                    classField.set(inputClass, (seed % 2 == 1));
                    updateSeed();
                }
                else if (classField.getType().equals(byte.class))
                {
                    classField.set(inputClass, (byte) (seed % Byte.MAX_VALUE));
                    updateSeed();
                }
                else if (classField.getType().equals(int.class))
                {
                    classField.set(inputClass, (int) (seed % Integer.MAX_VALUE));
                    updateSeed();
                }
                else if (classField.getType().equals(long.class))
                {
                    classField.set(inputClass, (int) (seed % Long.MAX_VALUE));
                    updateSeed();
                }
                else if (classField.getType().equals(double.class))
                {
                    classField.set(inputClass, seed * 0.0000000001);
                    updateSeed();
                }
                else if (classField.getType().equals(float.class))
                {
                    classField.set(inputClass, (float) (seed * 0.0000000001));
                    updateSeed();
                }
                else if (classField.getType().equals(char.class))
                {
                    classField.set(inputClass, (char) (seed % Character.MAX_VALUE));
                    updateSeed();
                }
                else if (classField.getType().equals(String.class))
                {
                    StringBuilder tmp = new StringBuilder();
                    for (int i = 0; i < seed % 100; i++)
                    {
                        updateSeed();
                        tmp.append((char) (seed % Character.MAX_VALUE));
                    }
                    updateSeed();
                    classField.set(inputClass, tmp.toString());
                }
            }
            catch (IllegalAccessException e)
            {
                throw new RuntimeException();
            }
        }
    }
}
