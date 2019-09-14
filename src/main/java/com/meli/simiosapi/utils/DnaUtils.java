package com.meli.simiosapi.utils;

import com.meli.simiosapi.exception.BadRequestException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DnaUtils {

    public static boolean isSimian(String[] dna){
        if (dna.length < 4) {
            throw new BadRequestException("Sequencia de DNA invalida não pertence a um humano nem a um simio");
        }

        for (String sequence : dna) {
            if (sequence.length() != dna.length) {
                throw new BadRequestException("Sequencia de DNA invalida não pertence a um humano nem a um simio");
            }
        }

        String matrizDNA[][] = new String[dna.length][dna.length];
        int linha = 0;
        int coluna = 0;

        if (naoPossuiCaracteresValidos(dna, matrizDNA, linha, coluna)) return false;

        int caracterSequencia = 0;
        int contadorSequencia = 0;
        int contadorSequenciaLinha = 0;
        int contadorSequenciaColuna = 0;
        int contadorSequenciaDiagonal = 0;
        int contadorSequenciaDiagonalInversa = 0;
        String lastChar = "";
        contadorSequenciaLinha = getContadorSequencia(matrizDNA, caracterSequencia, contadorSequencia, lastChar, true);
        if (contadorSequenciaLinha <= 1){
            contadorSequencia = 0;
            contadorSequenciaColuna = getContadorSequencia(matrizDNA, caracterSequencia, contadorSequencia, lastChar, false);

            if(contadorSequenciaLinha + contadorSequenciaColuna <= 1) {
                contadorSequencia = 0;
                contadorSequenciaDiagonal = getContadorSequenciaDiagonal(matrizDNA, caracterSequencia, contadorSequencia, lastChar, false);

                if(contadorSequenciaLinha + contadorSequenciaColuna + contadorSequenciaDiagonal <= 1) {
                    contadorSequencia = 0;
                    contadorSequenciaDiagonalInversa = getContadorSequenciaDiagonal(matrizDNA, caracterSequencia, contadorSequencia, lastChar, true);
                }
            }
        }

        if(contadorSequenciaLinha + contadorSequenciaColuna + contadorSequenciaDiagonal + contadorSequenciaDiagonalInversa > 1 ) {
            return true;
        }

        return false;
    }

    private static boolean naoPossuiCaracteresValidos(String[] dna, String[][] matrizDNA, int linha, int coluna) {
        for (String sequence: dna) {
            List<String> chars = new ArrayList<>(Arrays.asList(sequence.split("")));

            for (String c: chars) {
                if(!"A".equalsIgnoreCase(c) &&
                        !"T".equalsIgnoreCase(c) &&
                        !"C".equalsIgnoreCase(c) &&
                        !"G".equalsIgnoreCase(c)){
                    return true;
                }

                matrizDNA[linha][coluna] = c;
                coluna++;
            }
            coluna = 0;
            linha++;
        }
        return false;
    }

    private static int getContadorSequencia(String[][] matrizDNA, int caracterSequencia, int contadorSequencia, String lastChar, boolean contarPorLinha) {
        for(int i = 0; i < matrizDNA.length; i++) {
            for(int j = 0; j < matrizDNA.length ; j ++) {
                String actualChar = contarPorLinha ? matrizDNA[i][j] : matrizDNA[j][i];
                if (lastChar.equalsIgnoreCase(actualChar)) {
                    caracterSequencia++;
                    if(caracterSequencia == 3){
                        contadorSequencia++;
                    }
                }else{
                    caracterSequencia=0;
                }
                lastChar = actualChar;
            }

            caracterSequencia = 0;
            lastChar = "";
        }
        return contadorSequencia;
    }

    private static int getContadorSequenciaDiagonal(String[][] matrizDNA, int caracterSequencia, int contadorSequencia, String lastChar, boolean diagonalInversa) {
        int linha = 0;
        int z = 0;
        for(int i = 0; i < matrizDNA.length && linha < matrizDNA.length; i++){
            for(int j = 0; j <= linha && linha < matrizDNA.length; j++){
                String actualChar = matrizDNA[linha][j];
                if (lastChar.equalsIgnoreCase(actualChar)) {
                    caracterSequencia++;
                    if(caracterSequencia == 3){
                        contadorSequencia++;
                    }
                }else{
                    caracterSequencia=0;
                }
                lastChar = actualChar;
                linha++;
                z = j;
            }
            linha = linha - z;
            caracterSequencia = 0;
            lastChar = "";
        }
        return contadorSequencia;
    }
}
