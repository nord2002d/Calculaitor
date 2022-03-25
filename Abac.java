package Nacalo;

import java.util.Scanner;


public class Abac {

    public static void main(String[] args) throws TestException {

        System.out.println("Input: " + "Введите два числа и знак операции через пробел. Числа могут быть только римские или арабские от 1 до 10.");


        Scanner s = new Scanner(System.in);


        String line = s.nextLine();
        String[] split = line.split(" ");

        if (split.length <= 2)

         try {throw  new ArrayIndexOutOfBoundsException  ();}

        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Строка не является математической операцией");}

        String a = split[0];
        String b = split[1];
        String c = split[2];


        if(split.length>3){throw new TestException("Форма математической операции не удовлетворяет заданию- два операнда и один оператор (+,-,/,*)");}

            int sim1 = 0;
            int sim2 = 0;
            int sim3 = 0;



            switch (a) {
                case "1":sim1 = 1;break;
                case "2":sim1 = 2;break;
                case "3":sim1 = 3;break;
                case "4":sim1 = 4;break;
                case "5":sim1 = 5;break;
                case "6":sim1 = 6;break;
                case "7":sim1 = 7;break;
                case "8":sim1 = 8;break;
                case "9":sim1 = 9;break;
                case "10":sim1 = 10;break;
                default:
            }

            switch (c) {
                case "1":sim2 = 1;break;
                case "2":sim2 = 2;break;
                case "3":sim2 = 3;break;
                case "4":sim2 = 4;break;
                case "5":sim2 = 5;break;
                case "6":sim2 = 6;break;
                case "7":sim2 = 7;break;
                case "8":sim2 = 8;break;
                case "9":sim2 = 9;break;
                case "10":sim2 = 10;break;
                default:

            }

            if (sim1 == 0 && sim2 > 0 || sim1 > 0 && sim2 == 0) {
                throw new TestException("Неверный формат записи");
            } else if (b.equals("+") && sim1 != 0 && sim2 != 0) {
                sim3 = sim1 + sim2;
            } else if (b.equals("-") && sim1 != 0 && sim2 != 0) {
                sim3 = sim1 - sim2;
            } else if (b.equals("*") && sim1 != 0 && sim2 != 0) {
                sim3 = sim1 * sim2;
            } else if (b.equals("/") && sim1 != 0 && sim2 != 0) {
                sim3 = sim1 / sim2;
            }

            int i = 0;
            int current = 0;
            int pred = 0;
            int current1 = 0;
            int pred1 = 0;
            int Abac = 0;
            int Abac1 = 0;
            int Abac3 = 0;

            for (i = 0; i < a.length(); ) {
                char Stroca = a.charAt(i);


                switch (Stroca) {
                    case 'I': current = 1;break;
                    case 'V': current = 5;break;
                    case 'X': current = 10;break;
                    case 'C': current = 100;break;
                }

                if (current > pred) {
                    Abac += current - (pred * 2);
                } else {
                    Abac += current;
                }
                pred = current;
                i++;
            }

            for (i = 0; i < c.length(); ) {
                char Stroca1 = c.charAt(i);

                switch (Stroca1) {
                    case 'I': current1 = 1;break;
                    case 'V': current1 = 5;break;
                    case 'X': current1 = 10;break;
                    case 'C': current1 = 100;break;
                }

                if (current1 > pred1) {
                    Abac1 += current1 - (pred1 * 2);
                } else {
                    Abac1 += current1;
                }
                pred1 = current1;
                i++;
            }


            if (Abac > 10 ||  Abac1 > 10) {
                throw new TestException("Неверный формат записи");
            } else if (b.equals("+") && Abac != 0 && Abac1 != 0) {
                Abac3 = (Abac + Abac1);
            } else if (b.equals("-") && Abac != 0 && Abac1 != 0) {
                Abac3 = (Abac - Abac1);
            } else if (b.equals("*") && Abac != 0 && Abac1 != 0) {
                Abac3 = Abac * Abac1;
            } else if (b.equals("/") && Abac != 0 && Abac1 != 0) {
                Abac3 = Abac / Abac1;
            }
            if (Abac3 < 0) {
                throw new TestException("В римской системе нет отридцательных чисел");
            }

            int[] Ar = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] Rome = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            StringBuilder rem = new StringBuilder();

            for (i = 0; i < Ar.length; i++) {
                while (Abac3 >= Ar[i]) {
                    Abac3 -= Ar[i];
                    rem.append(Rome[i]);

                }
            }
            rem.toString();


            if (b.equals("+") && sim3 != 0) {
                System.out.println("Output:\n" + sim3);
            } else if (b.equals("-") && sim3 != 0) {
                System.out.println("Output:\n" + sim3);
            } else if (b.equals("*") && sim3 != 0) {
                System.out.println("Output:\n" + sim3);
            } else if (b.equals("/") && sim3 != 0) {
                System.out.println("Output:\n" + sim3);
            }

            if (b.equals("+") && sim3 == 0) {
                System.out.println("Output:\n" + rem.toString());
            } else if (b.equals("-") && sim3 == 0) {
                System.out.println("Output:\n" + rem.toString());
            } else if (b.equals("*") && sim3 == 0) {
                System.out.println("Output:\n" + rem.toString());
            } else if (b.equals("/") && sim3 == 0) {
                System.out.println("Output:\n" + rem.toString());
            }


        }

    }





