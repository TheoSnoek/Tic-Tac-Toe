package com.main;

import java.util.*;

public class Main {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

        char[][] gameboard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printgameboard(gameboard);

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Your placements (1-9);");
            int playerpos = scan.nextInt();
            while (playerPositions.contains(playerpos) || cpuPositions.contains(playerpos)) {
                System.out.println("Poistion is taken! Enter a correct Position");
                playerpos = scan.nextInt();
            }

            placePiece(gameboard, playerpos, "Player");

            String result = checkWinner();
            if (result.length() > 0)
                System.out.println(result);
            break;
        }

        Random rand = new Random();
        int cpuPos = rand.nextInt(9) + 1;
        while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
            cpuPos = rand.nextInt(9) + 1;
        }

        placePiece(gameboard, cpuPos, "cpu");

        printgameboard(gameboard);

        String result = checkWinner();
        if (result.length() > 0)
            System.out.println(result);
        break;
    }

    private static String checkWinner() {
        return null;
    }


    public static void printgameboard(char[][] gameboard) {
        for (char[] row : gameboard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    public static void placePiece(char[][] gameboard, int pos, String user) {

        char symbol = 'X';

        if (user.equals("player")) {
            symbol = 'X';
        } else if (user.equals("cpu")) {
            symbol = 'O';
        }

        switch (pos) {
            case 1:
                gameboard[0][0] = symbol;
                break;
            case 2:
                gameboard[0][2] = symbol;
                break;
            case 3:
                gameboard[0][4] = symbol;
                break;
            case 4:
                gameboard[2][0] = symbol;
                break;
            case 5:
                gameboard[2][2] = symbol;
                break;
            case 6:
                gameboard[2][4] = symbol;
                break;
            case 7:
                gameboard[4][0] = symbol;
                break;
            case 8:
                gameboard[4][2] = symbol;
                break;
            case 9:
                gameboard[4][4] = symbol;
                break;
            default:
                break;

        }


        private static String checkWinner() {

            List topRow = Arrays.asList(1, 2, 3);
            List midRow = Arrays.asList(4, 5, 6);
            List botRow = Arrays.asList(7, 8, 9);
            List leftCol = Arrays.asList(1, 4, 7);
            List midCol = Arrays.asList(2, 5, 8);
            List rightCol = Arrays.asList(3, 6, 9);
            List cross1 = Arrays.asList(1, 5, 9);
            List cross2 = Arrays.asList(7, 5, 3);

            List<List> winningConditions = new ArrayList<List>();
            winningConditions.add(topRow);
            winningConditions.add(midRow);
            winningConditions.add(botRow);
            winningConditions.add(leftCol);
            winningConditions.add(midCol);
            winningConditions.add(rightCol);
            winningConditions.add(cross1);
            winningConditions.add(cross2);

            for (List l : winningConditions) {
                if (playerPositions.containsAll(l)) {
                    return;
                } else if (cpuPositions.containsAll(l)) {
                    return;
                } else if (playerPositions.size() + cpuPositions.size() == 9) {
                    return;
                }

            }

        }

    }
}