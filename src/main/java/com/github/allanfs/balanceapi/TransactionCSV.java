package com.github.allanfs.balanceapi;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
public class TransactionCSV {
    @CsvBindByName(column = "Nome")
    private String name;

    @CsvBindByName(column = "Valor")
    private Float value;

    @CsvBindByName(column = "Vencimento")
    private String vencimento;

    @CsvBindByName(column = "Efetivado")
    private String paid;
}
