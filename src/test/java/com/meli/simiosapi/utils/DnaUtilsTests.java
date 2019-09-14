package com.meli.simiosapi.utils;

import com.meli.simiosapi.exception.BadRequestException;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class DnaUtilsTests {
    @Test(expected = BadRequestException.class)
    public void deveRetornarErroQuandoSequenciaDeDNAForMenorDoQueAMinimaPermitida() throws Exception {
        String[] dna = {"CTGAGA", "CTGAGC", "TATTGT"};
        DnaUtils.isSimian(dna);
    }

    @Test
    public void deveRetornarErroQuandoSequenciaDeDNAPossuirCaracterInvalido() throws Exception {
        String[] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGBG", "CCCCTA", "TCACTG"};
        assertFalse(DnaUtils.isSimian(dna));
    }

    @Test(expected = BadRequestException.class)
    public void deveRetornarErroQuandoUmaSequenciaDeDNAPossuirUmaLinhaComCaracterExcedente() throws Exception {
        String[] dna = {"CTGAGA", "CTGAGC", "TATTGGT", "AGAGGG", "CCCCTA", "TCACTG"};
        DnaUtils.isSimian(dna);
    }

    @Test(expected = BadRequestException.class)
    public void deveRetornarFalsoQuandoSequenciaDeDNANaoPossuirMesmoNumeroDeLinhasEColunas() throws Exception {
        String[] dna = {"CTGAGAT", "CTGAGCT", "TATTGGT", "AGAGGGT", "CCCCTAT", "TCACTGT"};
        DnaUtils.isSimian(dna);
    }

    @Test
    public void deveRetornarSucessoQuandoPossuiDuasSequenciasDNAValidaNasLinhas() throws Exception {
        String[] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGGGGG", "CCCCTA", "TCACTG"};
        assertTrue(DnaUtils.isSimian(dna));
    }

    @Test
    public void deveRetornarSucessoQuandoPossuiSequenciasDNAValidaNasColunas() throws Exception {
        String[] dna = {"CAGAGA", "CAGAGC", "CATTGT", "CAGGGG", "CCCTTA", "TCACTG"};
        assertTrue(DnaUtils.isSimian(dna));
    }

    @Test
    public void deveRetornarSucessoQuandoDNAValidoNaLinhaEDiagonal() throws Exception {
        String[] dna = {"TTGGGG", "CTGAGC", "TATTGT", "AGATCG", "CCCGTA", "TCACTG"};
        assertTrue(DnaUtils.isSimian(dna));
    }

    @Test
    public void deveRetornarSucessoQuandoDNAValidoNaLinhaColunaEDiagonal() throws Exception {
        String[] dna = {"TTGAGA", "CTGAGC", "TATTGT", "AGATGG", "CCCCTA", "TCACTG"};
        assertTrue(DnaUtils.isSimian(dna));
    }

    @Test
    public void deveRetornarSucessoQuandoDNAValidoNaLinhaColunaEDiagonalSentidoInverso() throws Exception {
        String[] dna = {"CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
        assertTrue(DnaUtils.isSimian(dna));
    }
}
