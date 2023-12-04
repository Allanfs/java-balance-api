package com.github.allanfs.balanceapi.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class TransactionRecurrency {
    // numero total de parcelas (prestacoes)
    private Integer totalInstallments;
    // tipo de recorrencia (diario, semanal, mensal...)
    private Recurrency recurrency;
    // valor total da compra
    private Long totalAmount;
    // data criacao
    private Date createdAt;
    // vencimento da primeira parcela
    private Date expiresIn;


    String String() {
        return String.format("totalAmount dividido em %d com recorrencia %s", totalInstallments, recurrency.toString() );
    }
}
